package codeanalyzer.metricsexporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The CsvMetricsExporter class is responsible for exporting metrics to a CSV file.
 * It implements the MetricsExporter interface.
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class CsvMetricsExporter implements MetricsExporter {

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        File outputFile = new File(filepath + ".csv");
        StringBuilder metricsNames = new StringBuilder();
        StringBuilder metricsValues = new StringBuilder();

        for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
            metricsNames.append(entry.getKey() + ",");
            metricsValues.append(entry.getValue() + ",");
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.append(metricsNames + "\n");
            writer.append(metricsValues + "\n");
            writer.close();
            System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
