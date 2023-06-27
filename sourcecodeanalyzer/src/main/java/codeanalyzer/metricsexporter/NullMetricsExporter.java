package codeanalyzer.metricsexporter;

import java.util.Map;


/**
 * The NullMetricsExporter class is a placeholder class that represents a null implementation of the MetricsExporter interface.
 * It is used when there is no need to export metrics or when the functionality is not implemented.
 * <p>Note: The writeFile method always throws an exception, indicating that the export is not performed.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class NullMetricsExporter implements MetricsExporter {

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        throw new IllegalArgumentException("Unknown export type, process terminated");
    }

}
