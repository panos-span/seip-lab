package codeanalyzer;


import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegexAnalyzerTest {

    private final static String TEST_CLASS = "src/test/resources/TestClass.java";
    private final RegexAnalyzer regexAnalyzer = new RegexAnalyzer(new LocalFileReader());


    @Test
    public void testCalculateRegexLOC() throws IOException {
        assertEquals(21, regexAnalyzer.calculateLOC(TEST_CLASS));
    }

    @Test
    public void testCalculateRegexNOM() throws IOException {
        assertEquals(3, regexAnalyzer.calculateNOM(TEST_CLASS));
    }

    @Test
    public void testCalculateRegexNOC() throws IOException {
        assertEquals(3, regexAnalyzer.calculateNOC(TEST_CLASS));
    }


}
