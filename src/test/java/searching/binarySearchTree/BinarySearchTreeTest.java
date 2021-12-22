package searching.binarySearchTree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {

    @Test
    @DisplayName("Tests the constructor")
    public void testConstructor() {
        BinarySearchTree tree = new BinarySearchTree();

        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }

    @Test
    @DisplayName("Tests adding to the tree")
    public void testAdding() {
        // Arrange
        BinarySearchTree tree = new BinarySearchTree();

        // Act
        tree.insert(10);
        tree.insert(20);

        // Assert
        assertEquals(2, tree.size());
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(20));
        assertFalse(tree.contains(150));
    }

    @Test
    @DisplayName("Tests adding a duplicate to the tree")
    public void testAddingDuplicate() {
        // Arrange
        BinarySearchTree tree = new BinarySearchTree();
        boolean exceptionThrown = false;

        // Act
        tree.insert(10);
        tree.insert(20);
        try {
            tree.insert(10);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        // Assert
        assertEquals(2, tree.size());
        assertTrue(exceptionThrown);
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(20));
        assertFalse(tree.contains(150));
    }

    @Test
    @DisplayName("Tests deleting from the tree")
    public void testDeletion() {
        // Arrange
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(20);

        // Act
        tree.delete(10);

        // Assert
        assertEquals(1, tree.size());
        assertFalse(tree.contains(10));
        assertTrue(tree.contains(20));
    }

    @Test
    @DisplayName("Tests deletion on an empty tree")
    public void testDeletionOnEmptyTree() {
        // Arrange
        BinarySearchTree tree = new BinarySearchTree();
        boolean exceptionThrown = false;

        // Act
        try {
            tree.delete(10);
        }
        catch (IllegalStateException e) {
            exceptionThrown = true;
        }

        // Assert
        assertTrue(tree.isEmpty());
        assertTrue(exceptionThrown);
    }

    @Test
    @DisplayName("Tests a special case of deletion #1")
    public void testDeletionCase1() {
        // Arrange
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Act
        tree.delete(20);

        // Assert
        assertEquals(6, tree.size());
        assertFalse(tree.contains(20));

        assertTrue(tree.contains(50));
        assertTrue(tree.contains(30));
        assertTrue(tree.contains(40));
        assertTrue(tree.contains(70));
        assertTrue(tree.contains(60));
        assertTrue(tree.contains(80));
    }

    @Test
    @DisplayName("Tests a special case of deletion #2")
    public void testDeletionCase2() {
        // Arrange
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Act
        tree.delete(20);
        tree.delete(30);

        // Assert
        assertEquals(5, tree.size());
        assertFalse(tree.contains(20));
        assertFalse(tree.contains(30));

        assertTrue(tree.contains(50));
        assertTrue(tree.contains(40));
        assertTrue(tree.contains(70));
        assertTrue(tree.contains(60));
        assertTrue(tree.contains(80));
    }

    @Test
    @DisplayName("Tests a special case of deletion #3")
    public void testDeletionCase3() {
        // Arrange
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Act
        tree.delete(20);
        tree.delete(30);
        tree.delete(50);

        // Assert
        assertEquals(4, tree.size());
        assertFalse(tree.contains(20));
        assertFalse(tree.contains(30));
        assertFalse(tree.contains(50));

        assertTrue(tree.contains(40));
        assertTrue(tree.contains(70));
        assertTrue(tree.contains(60));
        assertTrue(tree.contains(80));
    }
}