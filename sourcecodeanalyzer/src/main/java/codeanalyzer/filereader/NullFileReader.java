package codeanalyzer.filereader;

import java.util.List;

/**
 * The NullFileReader class is a placeholder class that represents a null implementation of the SourceFileReader interface.
 * It is used when there is no need to read files or when the functionality is not implemented.
 * <p>Note: The readFileIntoString and readFileIntoList methods return null, indicating that no file reading is performed.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class NullFileReader implements SourceFileReader {

    /**
     * {@inheritDoc}
     */
    @Override
    public String readFileIntoString(String filepath) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> readFileIntoList(String filepath) {
        return null;
    }
}
