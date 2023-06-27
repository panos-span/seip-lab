package demo;

import codeanalyzer.SourceCodeAnalyzerFacade;
import java.io.IOException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DemoClientTest {
    @Mock
    private SourceCodeAnalyzerFacade mockFacade;

    private DemoClient client;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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

    @Test
    public void testRun_withMissingArguments_exitsSystem() throws IOException {
        String[] args = new String[]{"src/main/resources/TestClass.java", "regex", "local"};
        // Expects System.exit(1) to be called
        exit.expectSystemExitWithStatus(1);
        client.run(args);
    }

}
