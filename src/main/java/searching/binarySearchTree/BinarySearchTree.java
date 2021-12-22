package searching.binarySearchTree;

/**
 * The class BinarySearchTree represents a Binary Search Tree data structure.
 * @author Marko
 * @version 14-11-2021
 */
public class BinarySearchTree {

    /**
     * The size of the tree
     */
    private int size;
    /**
     * The root of the BinarySearchTree
     */
    private Node root;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Inserts the given data into the tree.
     * @param data The data to insert, not a duplicate
     * @throws IllegalArgumentException If the given data is a duplicate
     */
    public void insert(int data) {
        this.root = this.insertRecursively(this.root, data);
        this.incrementSize();
    }

    /**
     * The recursive insertion algorithm.
     */
    private Node insertRecursively(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.getData()) {
            // Insert left
            node.setLeft(this.insertRecursively(node.getLeft(), data));
        }
        else if (data > node.getData()) {
            // Insert right
            node.setRight(this.insertRecursively(node.getRight(), data));
        }
        else {
            // Must be a duplicate
            throw new IllegalArgumentException("Duplicates are not allowed!");
        }
        return node;
    }

    /**
     * Deletes the given data from the tree
     * @param data The data to delete
     * @throws IllegalStateException If the tree is empty
     */
    public void delete(int data) {
        // Guard condition
        if (this.root == null) {
            throw new IllegalStateException("Can not delete when the tree is empty!");
        }

        this.root = this.deleteRecursively(this.root, data);
        this.decreaseSize();
    }

    /**
     * The recursive deletion algorithm.
     */
    private Node deleteRecursively(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.getData()) {
            // Recursively delete on the left
            node.setLeft(this.deleteRecursively(node.getLeft(), data));
        }
        else if (data > node.getData()) {
            // Recursively delete on the right
            node.setRight(this.deleteRecursively(node.getRight(), data));
        }
        else {
            // The Node contains the value to delete

            // Nodes with only one child or no child
            if (!node.hasLeft()) {
                return node.getRight();
            }
            else if (!node.hasRight()) {
                return node.getLeft();
            }

            // Node has two children: Get the inorder successor (smallest in the right subtree)
            int inorderSuccessor = this.inorderSuccessor(node.getRight());
            node.setData(inorderSuccessor);

            // remove the inorder successor
            node.setRight(this.deleteRecursively(node.getRight(), node.getData()));
        }
        return node;
    }

    /**
     * Returns the in-order successor of the given Node.
     * @param node The node to find the in-order successor of, not null
     * @return The in-order successor of the given Node
     * @throws IllegalArgumentException If the given Node is null
     */
    private int inorderSuccessor(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("The given Node can not be null!");
        }
        int minimum = node.getData();
        while (node.hasLeft()) {
            minimum = node.getLeft().getData();
            node = node.getLeft();
        }
        return minimum;
    }

    /**
     * Searches for the Node with the given data.
     * @param data The Node that contains the given data
     * @return The Node with the given data, null if not found
     */
    public Node search(final int data) {
        // Guard condition
        if (this.root == null) {
            throw new IllegalStateException("Can not search when the tree is empty!");
        }

        return this.searchRecursive(this.root, data);
    }

    /**
     * The recursive search algorithm
     */
    private Node searchRecursive(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.getData()) {
            return this.searchRecursive(node.getLeft(), data);
        }
        else if (data > node.getData()) {
            return this.searchRecursive(node.getRight(), data);
        }
        else {
            return node;
        }
    }

    /**
     * Returns true if the tree contains the given data, false otherwise.
     * @param data The data to check for
     * @return True if the tree contains the given data, false otherwise
     */
    public boolean contains(int data) {
        return this.search(data) != null;
    }

    /**
     * Increments the size.
     */
    private void incrementSize() {
        this.size++;
    }

    /**
     * Reduces the size.
     */
    private void decreaseSize() {
        this.size--;
    }

    /**
     * Returns the size of the tree.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if the tree is empty.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void showInOrder() {
        this.showInOrderRecursively(this.root);
    }

    public void showInOrderRecursively(Node node) {
        if (node != null) {
            this.showInOrderRecursively(node.getLeft());
            System.out.println(node.getData());
            this.showInOrderRecursively(node.getRight());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.showInOrder();

        System.out.println(tree.size);

        tree.printTree();

        System.out.println(tree.root.hasLeft());

        System.out.println("-----------");

        tree.delete(20);
        tree.delete(30);
        tree.delete(50);

        tree.printTree();

        System.out.println(tree.search(100));

        System.out.println(tree.contains(1200));
        System.out.println(tree.contains(80));

        System.out.println(tree.isEmpty());
    }


    // --------
    // Tree printout methods
    // --------

    public void printTree() {
        System.out.println(this.traversePreOrder(this.root));
    }

    private String traversePreOrder(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(root.getData());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        this.traverseNodes(builder, "", pointerLeft, root.getLeft(), root.getRight() != null);
        this.traverseNodes(builder, "", pointerRight, root.getRight(), false);

        return builder.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
        // Guard condition
        if (node == null) {
            return;
        }

        sb.append("\n");
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.getData());

        StringBuilder paddingBuilder = new StringBuilder(padding);
        if (hasRightSibling) {
            paddingBuilder.append("│  ");
        } else {
            paddingBuilder.append("   ");
        }

        String paddingForBoth = paddingBuilder.toString();
        String pointerRight = "└──";
        String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

        this.traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
        this.traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
    }
}
