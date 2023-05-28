package math;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test class for the {@link math.MyMath} class.
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class MyMathTest {

    MyMath myMath = new MyMath();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Test case for the {@link math.MyMath#factorial(int)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when 'n' is negative.
     */
    @Test
    public void testFactorialNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be >= 0 and <= 12");
        myMath.factorial(-1);
    }

    /**
     * Test case for the {@link math.MyMath#factorial(int)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when 'n' is greater than 12.
     */
    @Test
    public void testFactorialGreaterThan12() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n should be >= 0 and <= 12");
        myMath.factorial(13);
    }

    /**
     * Test case for the {@link math.MyMath#isPrime(int)} method.
     * Verifies that the method correctly identifies a prime number as a prime.
     */
    @Test
    public void testPrimeTrue() {
        Assert.assertTrue(myMath.isPrime(5));
    }

    /**
     * Test case for the {@link math.MyMath#isPrime(int)} method.
     * Verifies that the method correctly identifies a non-prime number as not prime.
     */
    @Test
    public void testPrimeFalse() {
        Assert.assertFalse(myMath.isPrime(4));
    }

    /**
     * Test case for the {@link math.MyMath#isPrime(int)} method.
     * Verifies that the method throws an {@link java.lang.IllegalArgumentException} when the input is not valid.
     */
    @Test
    public void testPrimeNotValidInput() {
        thrown.expect(IllegalArgumentException.class);
        myMath.isPrime(1);
    }

    /**
     * Test case for the {@link math.MyMath#isPrime(int)} method.
     * Verifies that the method correctly identifies 2 (a border case number) as a prime.
     */
    @Test
    public void testPrimeIs2() {
        Assert.assertTrue(myMath.isPrime(2));
    }


}
