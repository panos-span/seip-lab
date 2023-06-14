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
    public void testCreateSourceCodeAnalyzerRegexLocal() {
        SourceCodeAnalyzer sca_local = scaf.createSourceCodeAnalyzer(localFileReader, TYPE_REGEX);
        Assert.assertTrue(sca_local instanceof RegexAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerRegexWeb() {
        SourceCodeAnalyzer sca_web = scaf.createSourceCodeAnalyzer(webFileReader, TYPE_REGEX);
        Assert.assertTrue(sca_web instanceof RegexAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerStrcompLocal() {
        SourceCodeAnalyzer sca_local = scaf.createSourceCodeAnalyzer(localFileReader, TYPE_STRCOMP);
        Assert.assertTrue(sca_local instanceof StrcompAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerStrcompWeb() {
        SourceCodeAnalyzer sca_web = scaf.createSourceCodeAnalyzer(webFileReader, TYPE_STRCOMP);
        Assert.assertTrue(sca_web instanceof StrcompAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerNullLocal() {
        SourceCodeAnalyzer sca_local = scaf.createSourceCodeAnalyzer(localFileReader, "null");
        Assert.assertTrue(sca_local instanceof NullSourceCodeAnalyzer);
    }

    @Test
    public void testCreateSourceCodeAnalyzerNullWeb() {
        SourceCodeAnalyzer sca_web = scaf.createSourceCodeAnalyzer(webFileReader, "null");
        Assert.assertTrue(sca_web instanceof NullSourceCodeAnalyzer);
    }
}
