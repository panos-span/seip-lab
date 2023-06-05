package codeanalyzer.metricsexporter;

/**
 * The MetricsExporterFactory class is responsible for creating instances of MetricsExporter based on the specified file type.
 * It provides a factory method to create the appropriate MetricsExporter implementation based on the file type.
 *
 * <p>Note: The specific implementation details of the MetricsExporterFactory may vary depending on the requirements.</p>
 *
 * <p>Supported file types:</p>
 * <ul>
 *   <li>csv</li>
 *   <li>json</li>
 * </ul>
 *
 * <p>Note: The createMetricsExporter method assumes that the fileType parameter is a valid file type.</p>
 * <p>If an unknown file type is provided, an IllegalArgumentException is thrown.</p>
 *
 * <p>Implemented MetricsExporter:</p>
 * <ul>
 *   <li>CsvMetricsExporter</li>
 *   <li>JsonMetricsExporter</li>
 * </ul>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see CsvMetricsExporter
 * @see JsonMetricsExporter
 */
public class MetricsExporterFactory {

    /**
     * Creates a MetricsExporter instance based on the specified file type.
     *
     * @param fileType the file type for which a MetricsExporter instance will be created
     * @return a MetricsExporter instance for the specified file type
     * @throws IllegalArgumentException if the specified file type is unknown or unsupported
     */
    public MetricsExporter createMetricsExporter(String fileType) {
        MetricsExporter metricsExporter;
        if (fileType.equals("csv")) {
            metricsExporter = new CsvMetricsExporter();
        } else if (fileType.equals("json")) {
            metricsExporter = new JsonMetricsExporter();
        } else {
            throw new IllegalArgumentException("Unknown export type: " + fileType);
        }
        return metricsExporter;
    }
}