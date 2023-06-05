package codeanalyzer;

/**
 * The SourceCodeAnalyzerFactory class is responsible for creating instances of SourceCodeAnalyzer based on the specified analyzer type.
 * It provides a factory method to create the appropriate SourceCodeAnalyzer implementation based on the analyzer type.
 *
 * <p>Note: The specific implementation details of the SourceCodeAnalyzerFactory may vary depending on the analyzer types and their corresponding implementations.</p>
 *
 * <p>Supported analyzer types:</p>
 * <ul>
 *   <li>regex</li>
 *   <li>strcomp</li>
 * </ul>
 *
 * <p>Note: The createSourceCodeAnalyzer method assumes that the analyzerType parameter is a valid analyzer type.</p>
 * <p>If an unknown analyzer type is provided, a NullSourceCodeAnalyzer instance is returned.</p>
 *
 * <p>Implemented SourceCodeAnalyzer:</p>
 * <ul>
 *   <li>RegexAnalyzer</li>
 *   <li>StrcompAnalyzer</li>
 *   <li>NullSourceCodeAnalyzer</li>
 * </ul>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see RegexAnalyzer
 * @see StrcompAnalyzer
 * @see NullSourceCodeAnalyzer
 * @see SourceFileReader
 */
public class SourceCodeAnalyzerFactory {

    /**
     * Creates a SourceCodeAnalyzer instance based on the specified analyzer type.
     *
     * @param fileReader   the SourceFileReader implementation to use for reading source code files
     * @param analyzerType the analyzer type ("regex", "strcomp", etc.)
     * @return a SourceCodeAnalyzer instance for the specified analyzer type
     */
    public SourceCodeAnalyzer createSourceCodeAnalyzer(SourceFileReader fileReader, String analyzerType) {
        SourceCodeAnalyzer sourceCodeAnalyzer;
        if (analyzerType.equals("regex")) {
            sourceCodeAnalyzer = new RegexAnalyzer(fileReader);
        } else if (analyzerType.equals("strcomp")) {
            sourceCodeAnalyzer = new StrcompAnalyzer(fileReader);
        } else {
            sourceCodeAnalyzer = new NullSourceCodeAnalyzer();
        }
        return sourceCodeAnalyzer;
    }
}