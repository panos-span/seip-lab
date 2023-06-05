package codeanalyzer.metricsexporter;

import java.util.Map;


/**
 * The MetricsExporter interface defines the contract for exporting metrics.
 * <p>
 * Any class implementing this interface should provide the functionality to write metrics to a specific format (e.g., CSV, JSON, etc.).
 * <p>Note: The specific implementation details may vary depending on the class that implements this interface.</p>
 * <p>Note: The writeFile method is not implemented in this interface but needs to be implemented by the implementing classes.</p>
 * <p>Example usage:</p>
 * <pre>{@code
 *
 * MetricsExporter exporter = new CsvMetricsExporter();
 *
 * exporter.writeFile(metrics, filepath);
 *
 * }</pre>
 * <p>Note: The specific implementation of the writeFile method may have additional parameters or exceptions thrown. Refer to the implementing class for details.</p>
 * <p>Note: The writeFile method assumes that the metrics are provided as a Map where the keys are String and the values are Integer.</p>
 * <p>Implementing classes:</p>
 * <ul>
 * <li>CsvMetricsExporter</li>
 * <li>JsonMetricsExporter</li>
 * </ul>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see CsvMetricsExporter
 * @see JsonMetricsExporter
 */
public interface MetricsExporter {

    /**
     * Writes the metrics to a file.
     *
     * @param metrics  a Map containing the metrics with their corresponding values
     * @param filepath the filepath where the file will be created
     */
    void writeFile(Map<String, Integer> metrics, String filepath);
}
