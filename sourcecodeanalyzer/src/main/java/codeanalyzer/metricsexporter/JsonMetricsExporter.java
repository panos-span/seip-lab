package codeanalyzer.metricsexporter;

import java.util.Map;

/**
 * The JsonMetricsExporter class is responsible for exporting metrics to a JSON file.
 * It implements the MetricsExporter interface.
 * <p>Note: The functionality of writing the metrics to a JSON file is not implemented in this class.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class JsonMetricsExporter implements MetricsExporter {

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        // Functionality not implemented yet
        // No need to implement it for the assignment
    }
}
