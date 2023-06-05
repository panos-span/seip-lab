package codeanalyzer;

/**
 * The NullSourceCodeAnalyzer class is a placeholder class that represents a null implementation of the SourceCodeAnalyzer class.
 * It is used when there is no need to analyze the source code or when the functionality is not implemented.
 * <p>Note: The calculateLOC, calculateNOM, and calculateNOC methods always return an error value (-1), indicating that the analysis is not performed.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class NullSourceCodeAnalyzer extends SourceCodeAnalyzer {

    private final int error_value = -1;

    /**
     * <p>Constructor for NullSourceCodeAnalyzer.</p>
     */
    public NullSourceCodeAnalyzer() {
        super(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateLOC(String filepath) {
        return error_value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateNOM(String filepath) {
        return error_value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateNOC(String filepath) {
        return error_value;
    }
}
