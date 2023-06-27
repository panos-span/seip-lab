package codeanalyzer.analyzer;

import codeanalyzer.filereader.SourceFileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The RegexAnalyzer class is responsible for analyzing source code using regular expressions.
 * It extends the SourceCodeAnalyzer class and implements the calculateLOC, calculateNOM, and calculateNOC methods.
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class RegexAnalyzer extends SourceCodeAnalyzer {

    /**
     * <p>Constructor for RegexAnalyzer.</p>
     *
     * @param fileReader a {@link SourceFileReader} object
     */
    public RegexAnalyzer(SourceFileReader fileReader) {
        super(fileReader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateLOC(String filepath) throws IOException {
        String sourceCode = fileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
            nonCodeLinesCounter++;
        }

        int sourceFileLength = sourceCode.split("\n").length;
        int loc = sourceFileLength - nonCodeLinesCounter;

        return loc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateNOM(String filepath) throws IOException {
        String sourceCode = fileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
            methodCounter++;
        }
        return methodCounter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateNOC(String filepath) throws IOException {
        String sourceCode = fileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*\\s*class\\s+.*");
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
            classCounter++;
        }
        return classCounter;
    }
}
