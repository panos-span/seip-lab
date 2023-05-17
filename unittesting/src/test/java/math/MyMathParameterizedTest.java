package math;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * <p>Test class for the {@link math.MyMath} class using parameterized tests.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
@RunWith(Parameterized.class)
public class MyMathParameterizedTest {

    MyMath myMath = new MyMath();

    @Parameter()
    public int n;

    @Parameter(value = 1)
    public int expected;

    /**
     * Provides the data for the parameterized tests.
     *
     * @return a {@link java.util.Collection} of test data, where each entry is an array containing 'n' and the expected factorial result.
     */
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{0, 1}, {1, 1}, {2, 2}, {12, 479001600}};
        return Arrays.asList(data);
    }

    /**
     * Test case for the {@link math.MyMath#factorial(int)} method.
     * Verifies the correct factorial result for the provided 'n' value.
     */
    @Test
    public void testFactorial() {
        int result = myMath.factorial(n);
        Assert.assertEquals(expected, result);
    }


}
