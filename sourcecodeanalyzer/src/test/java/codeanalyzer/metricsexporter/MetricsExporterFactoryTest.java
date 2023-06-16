package codeanalyzer.metricsexporter;

import org.junit.Assert;
import org.junit.Test;

public class MetricsExporterFactoryTest {

    private final MetricsExporterFactory mex = new MetricsExporterFactory();

    @Test
    public void testCreateMetricsExporterCSV() {
        MetricsExporter metricsExporter = mex.createMetricsExporter("csv");
        Assert.assertTrue(metricsExporter instanceof CsvMetricsExporter);
    }

    @Test
    public void testCreateMetricsExporterJSON() {
        MetricsExporter metricsExporter = mex.createMetricsExporter("json");
        Assert.assertTrue(metricsExporter instanceof JsonMetricsExporter);
    }


    @Test
    public void testCreateMetricsExporterNull() {
        MetricsExporter metricsExporter = mex.createMetricsExporter("null");
        Assert.assertTrue(metricsExporter instanceof NullMetricsExporter);
    }

}
