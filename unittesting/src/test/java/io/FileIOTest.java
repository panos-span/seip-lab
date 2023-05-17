package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * <p>Test class for the {@link io.FileIO} class.</p>
 *
 * @author Panagiotis Spanakis
 * @version 1.0
 */
public class FileIOTest {

    FileIO fileIO = new FileIO();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Test case for the {@link io.FileIO#readFile(String)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when the file does not exist.
     */
    @Test
    public void testNonExistingFile() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Input file does not exist");
        fileIO.readFile("non-existing-file.txt");
    }

    /**
     * Test case for the {@link io.FileIO#readFile(String)} method.
     * Verifies that an {@link java.lang.IllegalArgumentException} is thrown when the given file is empty.
     */
    @Test
    public void testEmptyFile() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Given file is empty");
        fileIO.readFile("src/test/resources/io/empty-file.txt");
    }


    /**
     * Test case for the {@link io.FileIO#readFile(String)} method.
     * Verifies that the method correctly reads and returns an array of integers from a file.
     */
    @Test
    public void testReadFile() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = fileIO.readFile("src/test/resources/io/file-with-integers.txt");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testReadFileContainsInvalidEntries() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        Assert.assertArrayEquals(expected,
                fileIO.readFile("src/test/resources/io/file-with-other-data.txt"));
    }


}
