package math;

import io.FileIO;
import java.util.ArrayList;

/**
 * <p>ArrayOperations class.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class ArrayOperations {

    /**
     * <p>findPrimesInFile.</p>
     *
     * @param fileIo   a {@link io.FileIO} object
     * @param filepath a {@link java.lang.String} object
     * @param myMath   a {@link math.MyMath} object
     * @return an array of {@link java.lang.Integer} objects
     */
    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
        int[] grades = fileIo.readFile(filepath);
        ArrayList<Integer> primes = new ArrayList<>();
        for (int x : grades) {
            if (myMath.isPrime(x)) {
                primes.add(x);
            }
        }

        return primes.stream().mapToInt(i -> i).toArray();

    }
}
