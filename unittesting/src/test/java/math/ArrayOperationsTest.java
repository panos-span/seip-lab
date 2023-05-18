package math;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

/**
 * Test class for the {@link ArrayOperations} class.
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class ArrayOperationsTest {

    ArrayOperations arrayOperations = new ArrayOperations();

    /**
     * Test case for the {@link ArrayOperations#findPrimesInFile(FileIO, String, MyMath)} method.
     * Verifies that the method correctly finds prime numbers in a file using mocked dependencies.
     */
    @Test
    public void testFindPrimesInFile() {
        String filepath = "src/test/resources/math/grades.txt";
        MyMath myMath_mock = mock(MyMath.class);
        FileIO fileIO_mock = mock(FileIO.class);
        int[] grades = {2, 3, 4, 5, 6};

        when(fileIO_mock.readFile(filepath)).thenReturn(grades);
        when(myMath_mock.isPrime(2)).thenReturn(true);
        when(myMath_mock.isPrime(3)).thenReturn(true);
        when(myMath_mock.isPrime(4)).thenReturn(false);
        when(myMath_mock.isPrime(5)).thenReturn(true);
        when(myMath_mock.isPrime(6)).thenReturn(false);

        int[] expected = {2, 3, 5};

        Assert.assertArrayEquals(expected, arrayOperations.findPrimesInFile(fileIO_mock, filepath, myMath_mock));

    }
}
