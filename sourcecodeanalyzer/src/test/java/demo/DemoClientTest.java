package demo;

import codeanalyzer.SourceCodeAnalyzerFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class DemoClientTest {
    @Mock
    private SourceCodeAnalyzerFacade mockFacade;

    private DemoClient client;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        client = new DemoClient(mockFacade);
    }

    @Test
    public void testRun_withNoArguments() throws IOException {
        String[] args = {};
        client.run(args);
        verify(mockFacade, times(1)).exportMetrics("src/main/resources/TestClass.java", "regex", "local", "output_metrics", "csv");
    }

    @Test
    public void testRun_withAllArguments() throws IOException {
        String[] args = {"test.java", "strcomp", "web", "metrics.csv", "json"};
        client.run(args);
        verify(mockFacade, times(1)).exportMetrics("test.java", "strcomp", "web", "metrics.csv", "json");
    }
}
