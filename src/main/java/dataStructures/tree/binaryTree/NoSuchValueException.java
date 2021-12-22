package dataStructures.tree.binaryTree;

public class NoSuchValueException extends RuntimeException {

    private int value;

    public NoSuchValueException(int value) {
        this.value = value;
    }

    public NoSuchValueException() {
    }

    public NoSuchValueException(String message) {
        super(message);
    }
}
