package codeanalyzer.analyzer;

import codeanalyzer.filereader.SourceFileReader;
import java.io.IOException;

/**
 * The SourceCodeAnalyzer class is an abstract class that represents a source code analyzer.
 * It provides the basic structure and contract for analyzing Java source code files and calculating metrics such as lines of code (LOC),
 * number of methods (NOM), and number of classes (NOC).
 *
 * <p>Note: The specific implementation details of the SourceCodeAnalyzer may vary depending on the analysis technique used
 * (e.g., regex, string comparison, etc.).</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see RegexAnalyzer
 * @see StrcompAnalyzer
 * @see SourceFileReader
 */
public abstract class SourceCodeAnalyzer {

    protected final SourceFileReader fileReader;

    /**
     * Constructs a new SourceCodeAnalyzer instance with the specified SourceFileReader.
     *
     * @param fileReader the SourceFileReader implementation to use for reading source code files
     */
    public SourceCodeAnalyzer(SourceFileReader fileReader) {
        this.fileReader = fileReader;
    }

    /**
     * Calculates the Lines of Code (LOC) in the specified source code file.
     *
     * @param filepath the filepath of the source code file to be analyzed
     * @return the number of Lines of Code (LOC) in the source code file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public abstract int calculateLOC(String filepath) throws IOException;

    /**
     * Calculates the Number of Methods (NOM) in the specified source code file.
     *
     * @param filepath the filepath of the source code file to be analyzed
     * @return the number of Methods (NOM) in the source code file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public abstract int calculateNOM(String filepath) throws IOException;

    /**
     * Calculates the Number of Classes (NOC) in the specified source code file.
     *
     * @param filepath the filepath of the source code file to be analyzed
     * @return the number of Classes (NOC) in the source code file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public abstract int calculateNOC(String filepath) throws IOException;

}