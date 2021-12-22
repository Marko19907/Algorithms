package dataStructures.tree.binaryTree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    @Test
    @DisplayName("Tests the constructor")
    public void testConstructor() {
        BinaryTree tree = new BinaryTree(50);

        assertEquals(1, tree.size());
        assertEquals(0, tree.height());
        assertEquals(0, tree.depth(50));
        assertTrue(tree.contains(50));
    }

    @Test
    @DisplayName("Tests insertion into the tree")
    public void testInsertion() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);

        // Act
        tree.insert(25);
        tree.insert(75);
        BinaryTree subTree = tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);

        // Assert
        assertEquals(7, tree.size());
        assertEquals(2, subTree.size());
        assertEquals(3, tree.height());
    }

    @Test
    @DisplayName("Tests min/max")
    public void testMinMax() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);

        // Act
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);

        // Assert
        assertEquals(7, tree.size());
        assertEquals(25, tree.minimum());
        assertEquals(99, tree.maximum());
    }

    @Test
    @DisplayName("Test the depth function")
    public void testTreeDepth() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);

        // Act
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);

        // Assert
        assertEquals(7, tree.size());
        assertEquals(0, tree.depth(50));
        assertEquals(2, tree.depth(45));
    }

    @Test
    @DisplayName("Test the depth function with a value that is not in the tree")
    public void testTreeDepthAbsent() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);
        boolean exceptionThrown = false;

        // Act
        try {
            tree.depth(Integer.MAX_VALUE);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

        // Assert
        assertEquals(7, tree.size());
        assertTrue(exceptionThrown);
    }

    @Test
    @DisplayName("Tests searching")
    public void testSearch() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);

        // Assert
        assertEquals(7, tree.size());
        assertTrue(tree.contains(50));
        assertTrue(tree.contains(25));
        assertTrue(tree.contains(75));
        assertTrue(tree.contains(45));
        assertTrue(tree.contains(99));
        assertTrue(tree.contains(36));
        assertTrue(tree.contains(51));

        assertFalse(tree.contains(Integer.MIN_VALUE));
    }

    @Test
    @DisplayName("Tests the successor")
    public void testSuccessor() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);

        // Act
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);

        // Assert
        assertEquals(7, tree.size());
        assertEquals(36, tree.successor(25));
        assertEquals(99, tree.successor(75));
    }

    @Test
    @DisplayName("Tests the successor, edge case")
    public void testSuccessorEdgeCase() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);
        boolean exceptionThrown = false;

        // Act
        try {
            tree.successor(99);
        }
        catch (RuntimeException e) {
            exceptionThrown = true;
        }

        // Assert
        assertTrue(exceptionThrown);
    }

    @Test
    @DisplayName("Tests the deletion")
    public void testDeletion() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);

        // Act
        tree.delete(50);

        // Assert
        assertEquals(6, tree.size());
        assertTrue(tree.contains(45));
        assertTrue(tree.contains(51));
        assertTrue(tree.contains(99));
    }

    @Test
    @DisplayName("Tests the deletion on the edge of a tree")
    public void testDeletionOnTreeEdge() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);

        // Act
        tree.delete(99);

        // Assert
        assertEquals(6, tree.size());
        assertTrue(tree.contains(45));
        assertTrue(tree.contains(51));
        assertTrue(tree.contains(50));
    }

    @Test
    @DisplayName("Tests the deletion of a value that is not in the tree")
    public void testDeletionNegative() {
        // Arrange
        BinaryTree tree = new BinaryTree(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(45);
        tree.insert(99);
        tree.insert(36);
        tree.insert(51);
        boolean exceptionThrown = false;

        // Act
        try {
            tree.delete(Integer.MAX_VALUE);
        }
        catch (NoSuchValueException e) {
            exceptionThrown = true;
        }

        // Assert
        assertEquals(7, tree.size());
        assertTrue(exceptionThrown);
    }
}