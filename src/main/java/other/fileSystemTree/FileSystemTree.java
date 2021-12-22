package other.fileSystemTree;

import java.io.File;
import java.nio.file.Path;

/**
 * Displays the directory structure of a path graphically to the console.
 */
public class FileSystemTree {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String TAB = "\t";

    /**
     * Lists the files from a given FileSystem to the console
     */
    public void list(FileSystem fileSystem, String givenPath) {
        // Guard condition
        if (fileSystem == null || givenPath == null) {
            return;
        }

        File file = fileSystem.get(givenPath);

        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();

            String result = this.printStep(files, 0, 0, new StringBuilder());
            System.out.println(result);
        }
    }

    /**
     * A step in the recursive algorithm
     */
    public String printStep(File[] files, int index, final int level, StringBuilder builder) {
        if (index == files.length) {
            return builder.toString();
        }

        // Add tabs to the builder to represent levels
        // builder.append("\t".repeat(Math.max(0, level)));
        int i = 0;
        while (i < level) {
            builder.append(TAB);
            i++;
        }

        if (files[index].isFile()) {
            builder.append(files[index].getName()).append(NEW_LINE);
        }
        if (files[index].isDirectory()) {
            builder.append(files[index].getName()).append(NEW_LINE);

            int tmp = level;
            tmp++;
            this.printStep(files[index].listFiles(), 0, tmp, builder);
        }

        return this.printStep(files, ++index, level, builder);
    }

    /**
     * Lists only the files and their path that leads to them
     */
    public void listFilesOnly(FileSystem fileSystem, Path givenPath) {
        if (fileSystem == null || givenPath == null) {
            return;
        }

        File file = fileSystem.get(givenPath.toString());

        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();

            String result = this.printStepWithoutFolders(files, 0, new StringBuilder());
            System.out.println(result);
        }
    }

    /**
     * A step in the recursive algorithm without folders
     */
    public String printStepWithoutFolders(File[] files, int index, StringBuilder builder) {
        if (index == files.length) {
            return builder.toString();
        }

        if (files[index].isFile()) {
            builder.append(files[index].getPath()).append(NEW_LINE);
        }
        if (files[index].isDirectory()) {
            this.printStepWithoutFolders(files[index].listFiles(), 0, builder);
        }

        return this.printStepWithoutFolders(files, ++index, builder);
    }

    // -------------------
    // TEST METHODS
    // -------------------

    public void list1(File file, String givenPath) {
        // Guard condition
        if (file == null || givenPath == null) {
            return;
        }

        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();

            String result = this.printStep(files, 0, 0, new StringBuilder());
            System.out.println(result);
        }
    }

    public void list2(File file, String givenPath) {
        // Guard condition
        if (file == null || givenPath == null) {
            return;
        }

        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();

            String result = this.printStepWithoutFolders(files, 0, new StringBuilder());
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        final File file = new File(".");
        new FileSystemTree().list1(file, "");
        new FileSystemTree().list2(file, "");
    }
}
