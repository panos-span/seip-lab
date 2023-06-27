package codeanalyzer.metricsexporter;

import org.junit.Test;

public class NullMetricsExporterTest {

    MetricsExporter mex = new NullMetricsExporter();

    @Test(expected = IllegalArgumentException.class)
    public void testWriteFile() {
        mex.writeFile(null, "any-filepath");
    }
}
