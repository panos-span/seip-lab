package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * The SourceFileReader interface defines the contract for reading the contents of a file.
 * It provides methods to read a file and retrieve its contents as a list of strings or a single string.
 *
 * <p>Note: The specific implementation details of the SourceFileReader may vary depending on the file location and access method
 * (e.g., local file, web file, etc.).</p>
 *
 * <p>Implementing classes:</p>
 * <ul>
 *   <li>LocalFileReader</li>
 *   <li>WebFileReader</li>
 * </ul>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see LocalFileReader
 * @see WebFileReader
 */
public interface SourceFileReader {

    /**
     * Reads the contents of the specified file and returns them as a list of strings.
     *
     * @param filepath the filepath of the file to be read
     * @return a list of strings containing the contents of the file, where each string represents a line
     * @throws IOException if an I/O error occurs while reading the file
     */
    List<String> readFileIntoList(String filepath) throws IOException;

    /**
     * Reads the contents of the specified file and returns them as a single string.
     *
     * @param filepath the filepath of the file to be read
     * @return a string containing the contents of the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    String readFileIntoString(String filepath) throws IOException;

}