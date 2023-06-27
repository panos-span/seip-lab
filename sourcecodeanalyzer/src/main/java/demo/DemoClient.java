package demo;

import codeanalyzer.SourceCodeAnalyzerFacade;
import java.io.IOException;

/**
 * The DemoClient class is a demonstration client that showcases the usage of the SourceCodeAnalyzerFacade.
 * It provides a main method to run the demo and export metrics for a given source code file.
 *
 * <p>Note: The default arguments will be used if no command-line arguments are provided.</p>
 *
 * <p>Command-line arguments:</p>
 * <ul>
 *   <li>filepath: the filepath of the source code file to be analyzed</li>
 *   <li>sourceCodeAnalyzerType: the type of source code analyzer ("regex", "strcomp", etc.)</li>
 *   <li>sourceFileLocation: the location of the source code file ("local", "web", etc.)</li>
 *   <li>outputFilePath: the filepath for exporting the metrics</li>
 *   <li>outputFileType: the type of the output file ("csv", "json", etc.)</li>
 * </ul>
 *
 * <p>Note: The DemoClient assumes that the provided filepaths and arguments are valid.</p>
 * <p>Incorrect number of arguments will result in an error message.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see SourceCodeAnalyzerFacade
 */
public class DemoClient {

    private final SourceCodeAnalyzerFacade analyzerFacade;

    /**
     * Constructs a DemoClient with the provided SourceCodeAnalyzerFacade.
     *
     * @param facade the SourceCodeAnalyzerFacade to be used by the DemoClient
     */
    public DemoClient(SourceCodeAnalyzerFacade facade) {
        this.analyzerFacade = facade;
    }


    /**
     * Runs the demo and exports metrics for a given source code file.
     *
     * @param args an array of command-line arguments
     * @throws IOException if an I/O error occurs while exporting the metrics
     */
    public static void main(String[] args) throws IOException {
        new DemoClient(new SourceCodeAnalyzerFacade()).run(args);

    }

    /**
     * This method encapsulates the main logic of the DemoClient class. It analyzes the given source code file and exports the metrics.
     *
     * @param args an array of command-line arguments
     * @throws IOException if an I/O error occurs while exporting the metrics
     */
    public void run(String[] args) throws IOException {
        String filepath = "src/main/resources/TestClass.java";
        String sourceCodeAnalyzerType = "regex";
        String sourceFileLocation = "local";
        String outputFilePath = "output_metrics";
        String outputFileType = "csv";

        if (args.length == 5) {
            filepath = args[0];
            sourceCodeAnalyzerType = args[1];
            sourceFileLocation = args[2];
            outputFilePath = args[3];
            outputFileType = args[4];
        } else if (args.length != 0) {
            System.out.println("Incorrect number of arguments.");
            System.exit(1);
        }

        analyzerFacade.exportMetrics(filepath, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath, outputFileType);
    }
}