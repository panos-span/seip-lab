package codeanalyzer.analyzer;

import codeanalyzer.filereader.LocalFileReader;
import codeanalyzer.filereader.WebFileReader;
import org.junit.Assert;
import org.junit.Test;

public class SourceCodeAnalyzerFactoryTest {

    private final SourceCodeAnalyzerFactory scaf = new SourceCodeAnalyzerFactory();
    private final LocalFileReader localFileReader = new LocalFileReader();
    private final WebFileReader webFileReader = new WebFileReader();

    private final static String TYPE_REGEX = "regex";
    private final static String TYPE_STRCOMP = "strcomp";

    @Test
    public void testCreateSourceCodeAnalyzerRegex() {
        SourceCodeAnalyzer sca_local = scaf.createSourceCodeAnalyzer(localFileReader, TYPE_REGEX);
        Assert.assertTrue(sca_local instanceof RegexAnalyzer);
        SourceCodeAnalyzer sca_web = scaf.createSourceCodeAnalyzer(webFileReader, TYPE_REGEX);
        Assert.assertTrue(sca_web instanceof RegexAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerStrcomp() {
        SourceCodeAnalyzer sca_local = scaf.createSourceCodeAnalyzer(localFileReader, TYPE_STRCOMP);
        Assert.assertTrue(sca_local instanceof StrcompAnalyzer);
        SourceCodeAnalyzer sca_web = scaf.createSourceCodeAnalyzer(webFileReader, TYPE_STRCOMP);
        Assert.assertTrue(sca_web instanceof StrcompAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerNull() {
        SourceCodeAnalyzer sca_local = scaf.createSourceCodeAnalyzer(localFileReader, "null");
        Assert.assertTrue(sca_local instanceof NullSourceCodeAnalyzer);
        SourceCodeAnalyzer sca_web = scaf.createSourceCodeAnalyzer(webFileReader, "null");
        Assert.assertTrue(sca_web instanceof NullSourceCodeAnalyzer);
    }
}
