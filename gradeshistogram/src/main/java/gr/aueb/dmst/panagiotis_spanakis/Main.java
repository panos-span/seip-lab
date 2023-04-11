package gr.aueb.dmst.panagiotis_spanakis;


/**
 * <p>This class is responsible for running the program.</p>
 *
 * @author panagiotis
 * @version $Id: 1.0
 */
public class Main {
    /**
     * <p>This method runs the program.</p>
     *
     * @param args the file to read the grades from.
     * @return Nothing.
     */
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Wrong number of arguments");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        HistogramGenerator histogramGenerator = new HistogramGenerator();
        int[] grades = histogramGenerator.readFile(args[0]);
        histogramGenerator.generateHistogram(grades);

    }
}
