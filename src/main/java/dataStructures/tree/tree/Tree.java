package dataStructures.tree.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Tree parent;
    private final String value;
    private final List<Tree> children;

    public Tree(String value) {
        this(null, value, new ArrayList<>());
    }

    public Tree(Tree parent, String value, List<Tree> children) {
        this.parent = parent;
        this.value = value;
        this.children = children;
    }

    public void addChild(Tree child) {
        if (child != null) {
            child.parent = this;
            this.children.add(child);
        }
    }

    public int size() {
        int sum = 1;
        for (var child : this.children) {
            sum += child.size();
        }
        return sum;
    }

    public int depth() {
        if (this.isRoot()) {
            return 0;
        }
        return 1 + this.parent.depth();
    }
    /**
     * Returns true if the parent node is the root
     * @return
     */
    private boolean isRoot() {
        return this.parent == null;
    }

    private void show() {
        System.out.println(this.value);
        for (var child : this.children) {
            child.show();
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree("Project");
        tree.addChild(new Tree("setup.py"));

        var app = new Tree("app");
        app.addChild(new Tree("runner.py"));

        var generator = new Tree("generator.py");
        app.addChild(generator);

        tree.addChild(app);
        System.out.println("Size: " + tree.size());

        System.out.println("Depth of generator: " + generator.depth());

        tree.show();
    }
}
