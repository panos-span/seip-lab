package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SourceFileReaderFactoryTest {

    private final SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
    private SourceFileReader sfr = null;
    private final static String TYPE_WEB = "web";
    private final static String TYPE_LOCAL = "local";
    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";


    @BeforeClass
    public static void setUp() throws IOException {
        List<String> expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
        String expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter)
    }

    @Test
    public void testCreateSourceFileReaderLocal() {
        sfr = sfrf.createSourceFileReader(TYPE_LOCAL);
        Assert.assertTrue(sfr instanceof LocalFileReader);
    }

    @Test
    public void testCreateSourceFileReaderWeb() {
        sfr = sfrf.createSourceFileReader(TYPE_WEB);
        Assert.assertTrue(sfr instanceof WebFileReader);
    }

    @Test
    public void testCreateSourceFileReaderNull() {
        sfr = sfrf.createSourceFileReader("non-existing-type");
        Assert.assertTrue(sfr instanceof NullFileReader);
    }
}
