package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * <p>Test class for the {@link math.ArithmeticOperations} class.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class ArithmeticOperationsTest {


    ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

    /**
     * Test case for the {@link math.ArithmeticOperations#divide(double, double)} method.
     * Verifies the correct division result when given valid input.
     */
    @Test
    public void testDivide() {
        double result = arithmeticOperations.divide(10, 2);
        Assert.assertEquals(5, result, 0);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#divide(double, double)} method.
     * Verifies that an {@link java.lang.ArithmeticException} is thrown when dividing by zero.
     */
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        arithmeticOperations.divide(10, 0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies the correct multiplication result when given valid input.
     */
    @Test
    public void testMultiply() {
        int result = arithmeticOperations.multiply(10, 2);
        Assert.assertEquals(20, result);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when 'x' is negative.
     */
    @Test
    public void testMultiplyWithNegativeX() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(-10, 2);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when 'y' is negative.
     */
    @Test
    public void testMultiplyWithNegativeY() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(10, -2);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when both 'x' and 'y' are negative.
     */
    @Test
    public void testMultiplyWithNegativeXAndY() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(-10, -2);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that the method works correctly when multiplying by the maximum integer value.
     */
    @Test
    public void testMultiplyWithMaxValue() {
        int result = arithmeticOperations.multiply(Integer.MAX_VALUE, 1);
        Assert.assertEquals(Integer.MAX_VALUE, result);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when multiplying the maximum integer value by a negative number.
     */
    @Test
    public void testMultiplyWithMaxValueAndNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(Integer.MAX_VALUE, -1);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that the method works correctly when multiplying by the minimum integer value.
     */
    @Test
    public void testMultiplyWithXZero() {
        int result = arithmeticOperations.multiply(0, 1);
        Assert.assertEquals(0, result);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that the method works correctly when multiplying by the minimum integer value.
     */
    @Test
    public void testMultiplyWithYZero() {
        int result = arithmeticOperations.multiply(1, 0);
        Assert.assertEquals(0, result);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that the method works correctly when multiplying by the minimum integer value.
     */
    @Test
    public void testMultiplyWithXAndYZero() {
        int result = arithmeticOperations.multiply(0, 0);
        Assert.assertEquals(0, result);
    }

    /**
     * Test case for the {@link math.ArithmeticOperations#multiply(int, int)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when the multiplication result overflows.
     */
    @Test
    public void testMultiplyWithOverflow() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        arithmeticOperations.multiply(Integer.MAX_VALUE, 2);
    }


}
