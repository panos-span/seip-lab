package codeanalyzer;

import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrcompAnalyzerTest {

    private final static String TEST_CLASS = "src/test/resources/TestClass.java";
    private final StrcompAnalyzer StrcompAnalyzer = new StrcompAnalyzer(new LocalFileReader());

    @Test
    public void testCalculateRegexLOC() throws IOException {
        assertEquals(7, StrcompAnalyzer.calculateLOC(TEST_CLASS));
    }

    @Test
    public void testCalculateRegexNOM() throws IOException {
        assertEquals(3, StrcompAnalyzer.calculateNOM(TEST_CLASS));
    }

    @Test
    public void testCalculateRegexNOC() throws IOException {
        assertEquals(3, StrcompAnalyzer.calculateNOC(TEST_CLASS));
    }
}
