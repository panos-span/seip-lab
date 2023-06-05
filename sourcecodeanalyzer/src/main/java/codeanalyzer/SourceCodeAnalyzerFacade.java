package codeanalyzer;

import codeanalyzer.analyzer.SourceCodeAnalyzer;
import codeanalyzer.analyzer.SourceCodeAnalyzerFactory;
import codeanalyzer.filereader.SourceFileReader;
import codeanalyzer.filereader.SourceFileReaderFactory;
import codeanalyzer.metricsexporter.MetricsExporter;
import codeanalyzer.metricsexporter.MetricsExporterFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The SourceCodeAnalyzerFacade class provides a simplified interface for exporting metrics of a source code file.
 * It encapsulates the process of analyzing the source code, calculating metrics, and exporting them using a specific MetricsExporter implementation.
 *
 * <p>Note: The SourceCodeAnalyzerFacade class assumes that the necessary dependencies
 * (e.g., SourceFileReader, SourceCodeAnalyzer, MetricsExporter) are available and properly configured.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see SourceFileReaderFactory
 * @see SourceCodeAnalyzerFactory
 * @see MetricsExporterFactory
 */
public class SourceCodeAnalyzerFacade {

    /**
     * Exports the metrics of a source code file using the specified parameters.
     *
     * @param filepath               the filepath of the source code file to be analyzed
     * @param sourceCodeAnalyzerType the type of source code analyzer to use (e.g., "regex", "strcomp")
     * @param sourceFileLocation     the location of the source code file ("local", "web", etc.)
     * @param outputFilePath         the filepath where the metrics file will be created
     * @param outputFileType         the type of output file to generate (e.g., "csv", "json")
     * @throws IOException if an I/O error occurs during the export process
     */
    public void exportMetrics(String filepath, String sourceCodeAnalyzerType,
                              String sourceFileLocation, String outputFilePath,
                              String outputFileType) throws IOException {

        SourceFileReaderFactory readerFactory = new SourceFileReaderFactory();
        SourceFileReader reader = readerFactory.createSourceFileReader(sourceFileLocation);

        SourceCodeAnalyzerFactory analyzerFactory = new SourceCodeAnalyzerFactory();
        SourceCodeAnalyzer analyzer = analyzerFactory.createSourceCodeAnalyzer(reader, sourceCodeAnalyzerType);

        int loc = analyzer.calculateLOC(filepath);
        int nom = analyzer.calculateNOM(filepath);
        int noc = analyzer.calculateNOC(filepath);

        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc", loc);
        metrics.put("nom", nom);
        metrics.put("noc", noc);

        MetricsExporterFactory exporterFactory = new MetricsExporterFactory();
        MetricsExporter exporter = exporterFactory.createMetricsExporter(outputFileType);
        exporter.writeFile(metrics, outputFilePath);
    }
}