package gr.aueb.dmst.panagiotis_spanakis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * <p>This class is responsible for reading the grades from a file and generating a
 * histogram.</p>
 *
 * @author Panagiotis Spanakis
 * @version $Id: 1.0
 */
public class HistogramGenerator {

    /**
     * <p>This method reads the grades from a file and returns them as an array.</p>
     *
     * @param file the file to read the grades from.
     * @return an array containing the grades.
     * @throws java.lang.RuntimeException if the file cannot be read.
     */
    protected int[] readFile(String file) {
        int lines = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {
            String currentLine = reader.readLine();
            while (currentLine != null) {
                lines++;
                temp.add(Integer.parseInt(currentLine));
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + file);
        }
        int[] grades = new int[lines];
        for (int i = 0; i < lines; i++) {
            grades[i] = temp.get(i);
        }
        return grades;

    }

    /**
     * <p>This method generates a histogram from the grades.</p>
     *
     * @param dataValues the grades to be visualized.
     */
    protected void generateHistogram(int[] dataValues) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        /*
         * The XYSeries that are loaded in the dataset. There might be many
         * series in one dataset.
         */
        XYSeries data = new XYSeries("Grades");

        /*
         * Populating the XYSeries data object from the input Integer array
         * values.
         */
        for (int i = 0; i < dataValues.length; i++) {
            data.add(i, dataValues[i]);
        }

        // add the series to the dataset
        dataset.addSeries(data);

        boolean legend = false; // do not visualize a legend
        boolean tooltips = false; // do not visualize tooltips
        boolean urls = false; // do not visualize urls

        // Declare and initialize a createXYLineChart JFreeChart
        JFreeChart chart = ChartFactory.createXYLineChart("Grades", "Students", "Grades", dataset,
                PlotOrientation.VERTICAL, legend, tooltips, urls);

        /*
         * Initialize a frame for visualizing the chart and attach the
         * previously created chart.
         */
        ChartFrame frame = new ChartFrame("Grades", chart);
        frame.pack();
        // makes the previously created frame visible
        frame.setVisible(true);
        frame.setDefaultCloseOperation(ChartFrame.EXIT_ON_CLOSE);
    }


}
