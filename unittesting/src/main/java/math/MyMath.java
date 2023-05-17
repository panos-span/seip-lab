package math;

/**
 * <p>MyMath class.</p>
 *
 * @author Panagioits Spanakis
 * @version 1.0
 */
public class MyMath {

    /**
     * <p>Calculate the factorial of a number.</p>
     *
     * @param n an int
     * @return an int
     * @throws java.lang.IllegalArgumentException when 'n' is negative or greater than 12.
     */
    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("n should be >= 0 and <= 12");
        } else if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * <p>Check if a number is prime.</p>
     *
     * @param n an int
     * @return a boolean
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // if the remainder is 0, then the number is not prime
                return false;
            }
        }
        return true;
    }
}
