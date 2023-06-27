package codeanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SourceCodeAnalyzerFacadeTest {

    private final SourceCodeAnalyzerFacade facade = new SourceCodeAnalyzerFacade();
    private final String outputFilePath = "metrics_results.csv";
    private final String outputFileName = "metrics_results";
    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
    private final String sourceCodeAnalyzerType = "regex";
    private final String outputFileType = "csv";
    private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";

    @Test
    public void testExportMetricsLocal() throws IOException {
        facade.exportMetrics(TEST_CLASS_LOCAL, sourceCodeAnalyzerType, "local", outputFileName, outputFileType);
        // Check that outputFile now exists (this assumes that the exporter should create the file if it doesn't exist)
        assertTrue(Files.exists(Paths.get(outputFilePath)));
    }

    @Test
    public void testExportMetricsWeb() throws IOException {
        facade.exportMetrics(TEST_CLASS_WEB, sourceCodeAnalyzerType, "web", outputFileName, outputFileType);
        // Check that outputFile now exists (this assumes that the exporter should create the file if it doesn't exist)
        assertTrue(Files.exists(Paths.get(outputFilePath)));
    }

}