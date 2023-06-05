package codeanalyzer.analyzer;

import codeanalyzer.filereader.SourceFileReader;
import java.io.IOException;
import java.util.List;

/**
 * The StrcompAnalyzer class is responsible for analyzing source code using string comparison.
 * It extends the SourceCodeAnalyzer class and implements the calculateLOC, calculateNOM, and calculateNOC methods.
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 * @see SourceCodeAnalyzer
 * @see SourceFileReader
 */
public class StrcompAnalyzer extends SourceCodeAnalyzer {

    /**
     * Constructs a new StrcompAnalyzer instance with the specified SourceFileReader.
     *
     * @param fileReader the SourceFileReader implementation to use for reading source code files
     */
    public StrcompAnalyzer(SourceFileReader fileReader) {
        super(fileReader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateLOC(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        int nonCodeLinesCounter = 0;
        for (String line : sourceCodeList) {
            //line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
            line = line.trim();
            if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
                nonCodeLinesCounter++;
        }
        int loc = sourceCodeList.size() - nonCodeLinesCounter;
        return loc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateNOM(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        int methodCounter = 0;
        for (String line : sourceCodeList) {
            //line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
            line = line.trim();
            if (((line.contains("public") || line.contains("private") || line.contains("protected"))
                    || line.contains("void") || line.contains("int") || line.contains("String"))
                    && line.contains("(") && line.contains(")") && line.contains("{"))
                methodCounter++;
        }
        return methodCounter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateNOC(String filepath) throws IOException {
        List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
        int classCounter = 0;
        for (String line : sourceCodeList) {
            //line = line.strip(); //remove leading and trailing white spaces
            line = line.trim();
            if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                classCounter++;
            }
        }
        return classCounter;
    }
}
