package searching.binarySearchTree;

/**
 * The class Node represents a single Node in the tree.
 * @author Marko
 * @version 14-11-2021
 */
public class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return this.data;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    /**
     * Returns true if the Node has a left child.
     */
    public boolean hasLeft() {
        return this.left != null;
    }

    /**
     * Returns true if the Node has a right child.
     */
    public boolean hasRight() {
        return this.right != null;
    }
}
