package dataStructures.cacheSystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Represents an efficient order-based cache system.
 * The previously used element is always at the front of the list, the oldest element
 * is always at the end of the list. A HashMap is used to ensure O(1) lookups and a
 * doubly linked list ensures that elements can be moved to the front of the list in O(1) time.
 * O(n) memory complexity.
 */
public class Cache {
    private static final int CAPACITY = 3;

    private final Map<String, UserProfile> profiles;
    private final LinkedList<UserProfile> profilesList;

    private final UserService remote;

    private int count;


    public Cache(UserService givenRemote) {
        this.remote = givenRemote;
        this.profiles = new HashMap<>();
        this.profilesList = new LinkedList<>();
        this.count = 0;
    }

    public UserProfile findUserById(String userId) {
        UserProfile userProfile = this.search(userId);
        if (userProfile != null) {
            return userProfile;
        }
        userProfile = this.remote.findUserById(userId);
        if (this.isFull()) {
            this.discardOne();
        }
        this.addToCache(userProfile);
        return null;
    }

    private boolean isFull() {
        return this.count == CAPACITY;
    }

    private void addToCache(UserProfile userProfile) {
        if (userProfile == null) {
            return;
        }

        if (this.isFull()) {
            this.discardOne();
        }
        this.profiles.put(userProfile.toString(), userProfile);
        this.addToFrontOfList(userProfile);
        this.count++;
    }

    private UserProfile search(String userId) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("The given user ID can not be null!");
        }
        UserProfile result = null;
        result = this.profiles.get(userId);

        if (result != null) {
            // Found in cache, move it to the front
            this.deleteFromList(result);
            this.addToFrontOfList(result);
        }
        else {
            // Not in cache
            // result = UserService.get(userId) // Not implemented in the UserService class
            this.addToCache(result);
        }
        return result;
    }

    private void deleteFromList(UserProfile profile) {
        if (profile != null) {
            this.profilesList.remove(profile);
        }
    }

    private void addToFrontOfList(UserProfile profile) {
        if (profile != null) {
            this.profilesList.offerFirst(profile);
        }
    }

    private void discardOne() {
        UserProfile userProfile = this.profilesList.removeLast();
        this.profiles.remove(userProfile);
        this.count--;
    }
}