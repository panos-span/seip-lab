package math;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * <p>Test suite for the {@link math.MyMath} class.</p>
 * Runs both {@link math.MyMathTest} and {@link math.MyMathParameterizedTest} test classes.
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathParameterizedTest.class})
public class MyMathSuiteTest {
    /*
     * This class remains empty,
     * it is used only as a holder for the above annotations
     */
}
