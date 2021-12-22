package dataStructures.tree.binaryTree;

public class BinaryTree {

    private int value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int value) {
        this.value = value;
    }

    public BinaryTree insert(int givenValue) {
        if (givenValue < this.value) {
            // Insert on the left
            if (this.left != null) {
                return this.left.insert(givenValue);
            }
            else {
                this.left = new BinaryTree(givenValue);
                return this.left;
            }
        }
        else if (givenValue > this.value) {
            // Insert on the right
            if (this.right != null) {
                return this.right.insert(givenValue);
            }
            else {
                this.right = new BinaryTree(givenValue);
                return this.right;
            }
        }
        else {
            // Duplicate
            throw new IllegalArgumentException("Duplicate values are not allowed!");
        }
    }

    public int minimum() {
        if (this.hasLeftChild()) {
            return this.left.minimum();
        }
        return this.value;
    }

    public int maximum() {
        return this.hasRightChild() ? this.right.maximum() : this.value;
    }

    public int successor(int givenValue) {
        if (this.value < givenValue) {
            if (this.hasRightChild()) {
                return this.right.successor(givenValue);
            }
            throw new NoSuchValueException(givenValue);
        }
        else if (this.value > givenValue) {
            if (this.hasLeftChild()) {
                try {
                    return this.left.successor(givenValue);
                }
                catch (SuccessorNotFoundException e) {
                    return this.value;
                }
            }
            throw new NoSuchValueException(givenValue);
        }
        else {
            // Found the given value
            if (this.hasRightChild()) {
                return this.right.minimum();
            }
            throw new SuccessorNotFoundException("No minimum value!");
        }
    }

    public boolean contains(int givenValue) {
        if (this.value == givenValue) {
            return true;
        }
        if (!this.hasLeftChild() && !this.hasRightChild()) {
            // Definitely not in tree
            return false;
        }
        if (givenValue < this.value && this.hasLeftChild()) {
            return this.left.contains(givenValue);
        }
        if (givenValue > this.value && this.hasRightChild()) {
            return this.right.contains(givenValue);
        }
        return false;
    }

    /**
     * Returns the size of the tree.
     * @return The size of the tree
     */
    public int size() {
        int leftCount = this.hasLeftChild() ? this.left.size() : 0;

        int rightCount = this.hasRightChild() ? this.right.size() : 0;

        return 1 + leftCount + rightCount;
    }

    public BinaryTree delete(int givenValue) {
        if (!this.contains(givenValue)) {
            throw new NoSuchValueException("Value to delete is not in tree!");
        }

        if (givenValue < this.value) {
            if (this.hasLeftChild()) {
                this.left = this.left.delete(givenValue);
                return this;
            }
            throw new NoSuchValueException(givenValue);
        }
        else if (givenValue > this.value) {
            if (this.hasRightChild()) {
                this.right = this.right.delete(givenValue);
                return this;
            }
            throw new NoSuchValueException(givenValue);
        }
        else {
            // Found and then delete
            if (this.hasLeftChild() && !this.hasRightChild()) {
                return this.left;
            }
            if (!this.hasLeftChild() && this.hasRightChild()) {
                return this.right;
            }
            if (this.hasLeftChild() && this.hasRightChild()) {
                try {
                    this.value = this.successor(givenValue);
                }
                catch (SuccessorNotFoundException e) {
                    return null;
                }
                this.right.delete(this.value);
                return this;
            }
            return null;
        }
    }

    public String show() {
        String leftSide = this.hasLeftChild() ? this.left.show() : "?";

        String rightSide = this.hasRightChild() ? this.right.show() : "?";

        return "(" + leftSide + "," + this.value + "," + rightSide + ")";
    }

    /**
     * Returns the height of the tree.
     * @return The height of the tree
     */
    public int height() {
        if (!this.hasLeftChild() && !this.hasRightChild()) {
            return 0;
        }
        final int leftDepth = this.hasLeftChild() ? this.left.height() : 0;
        final int rightDepth = this.hasRightChild() ? this.right.height() : 0;

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int depth(int givenValue) {
        if (givenValue < this.value) {
            if (this.hasLeftChild()) {
                return 1 + this.left.depth(givenValue);
            }
            throw new IllegalArgumentException("Not in tree!");
        }
        else if (givenValue > this.value) {
            if (this.hasRightChild()) {
                return 1 + this.right.depth(givenValue);
            }
            throw new IllegalArgumentException("Not in tree!");
        }
        else {
            return 0;
        }
    }

    /**
     * Returns true if the tree has a right child.
     * @return True if the tree has a right child
     */
    private boolean hasRightChild() {
        return this.right != null;
    }

    /**
     * Returns true if the tree has a left child.
     * @return True if the tree has a left child
     */
    private boolean hasLeftChild() {
        return this.left != null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(50);
        tree.insert(25);
        tree.insert(75);
        BinaryTree subTree = tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);

        // Should be 7
        System.out.println("Size: " + tree.size());

        System.out.println("Size of subtree: " + subTree.size());

        //
        System.out.println("Depth of tree: " + tree.height());


        String tmp = tree.show();
        System.out.println(tmp);

        System.out.println("Depth (root) = " + tree.depth(50));
        System.out.println("Depth (root) = " + tree.depth(45));

        System.out.println("Min = " + tree.minimum());
        System.out.println("Max = " + tree.maximum());

        if (!tree.contains(99)) {
            System.out.println("Search broken!");
        }
        if (!tree.contains(50)) {
            System.out.println("Search broken!");
        }
        if (!tree.contains(25)) {
            System.out.println("Search broken!");
        }
        if (tree.contains(37)) {
            System.out.println("Search broken!");
        }
        if (tree.contains(52)) {
            System.out.println("Search broken!");
        }
        if (tree.contains(10)) {
            System.out.println("Search broken!");
        }
        if (tree.contains(110)) {
            System.out.println("Search broken!");
        }

        if (tree.successor(25) != 36) {
            System.out.println("Successor broken!");
        }
        if (tree.successor(25) != 36) {
            System.out.println("Successor broken!");
        }

        try {
            tree.successor(99);
            System.out.println("Successor broken!");
        }
        catch (RuntimeException e) {
        }


        tree = tree.delete(45);
        if (tree.contains(45)) {
            System.out.println("Broken deletion 45");
        }
        if (!tree.contains(36)) {
            System.out.println("Broken deletion 36");
        }


        tree.delete(50);
        if (tree.contains(50)) {
            System.out.println("Broken deletion 50");
        }
        if (!tree.contains(25)) {
            System.out.println("Broken deletion 50 -> 25");
        }
        if (!tree.contains(99)) {
            System.out.println("Broken deletion 50 -> 99");
        }


        System.out.println("Ok");
    }
}
