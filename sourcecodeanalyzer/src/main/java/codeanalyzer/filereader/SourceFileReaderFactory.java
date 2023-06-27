package codeanalyzer.filereader;

/**
 * The SourceFileReaderFactory class is responsible for creating instances of SourceFileReader based on the specified file reader type.
 * It provides a factory method to create the appropriate SourceFileReader implementation based on the file reader type.
 *
 * <p>Note: The specific implementation details of the SourceFileReaderFactory may vary depending
 * on the file reader types and their corresponding implementations.</p>
 *
 * <p>Supported file reader types:</p>
 * <ul>
 *   <li>local</li>
 *   <li>web</li>
 * </ul>
 *
 * <p>Note: The createSourceFileReader method assumes that the fileReaderType parameter is a valid file reader type.</p>
 * <p>If an unknown file reader type is provided, a NullFileReader instance is returned.</p>
 *
 * <p>Implemented SourceFileReader:</p>
 * <ul>
 *   <li>LocalFileReader</li>
 *   <li>WebFileReader</li>
 *   <li>NullFileReader</li>
 * </ul>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see LocalFileReader
 * @see WebFileReader
 * @see NullFileReader
 * @see SourceFileReader
 */
public class SourceFileReaderFactory {

    /**
     * Creates a SourceFileReader instance based on the specified file reader type.
     *
     * @param fileReaderType the file reader type ("local", "web", etc.)
     * @return a SourceFileReader instance for the specified file reader type
     */
    public SourceFileReader createSourceFileReader(String fileReaderType) {
        SourceFileReader sourceFileReader;
        if (fileReaderType.equals("local")) {
            sourceFileReader = new LocalFileReader();
        } else if (fileReaderType.equals("web")) {
            sourceFileReader = new WebFileReader();
        } else {
            sourceFileReader = new NullFileReader();
        }
        return sourceFileReader;
    }
}