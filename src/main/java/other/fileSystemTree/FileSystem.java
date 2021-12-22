package other.fileSystemTree;

import java.io.File;
import java.util.List;

/**
 * A simplified version of the Java File class.
 */
public interface FileSystem {

    /**
     * Return a handler to the file
     * @param path
     * @return
     */
    File get(String path);

    /**
     * Check whether a file is a directory of not
     * @param file
     * @return
     */
    boolean isDirectory(File file);

    /**
     * Returns the content of the given directory or an empty list if given a file.
     * @param file
     * @return
     */
    List<File> contentsOf(File file);

    /**
     * Return the name of the file
     * @param file
     * @return
     */
    String getName(File file);
}