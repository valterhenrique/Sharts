package util.chart;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;

/**
 * Provies a minimal structure to create a util.temp.chart and save it in a .png file.
 */
abstract class Chart
{
	/**
	 * Creates a chart, paint it and save it in a .png file.
	 */
	public abstract void draw();

	/**
	 * Creates chart's dataset.
	 * @return dataset
	 */
	protected abstract PieDataset createDataset();

	/**
	 * Creates a piechart based in a dataset.
	 * @param dataset the dataset that you want to your chart
	 * @return chart
	 */
	protected abstract JFreeChart createChart(PieDataset dataset);

	/**
	 * Paints the chart's sections.
	 * @param chart the chart created
	 */
	protected abstract void paintChart(JFreeChart chart);

	/**
	 * Save the chart created in a .png file.
	 * @param chart the chart created
	 */
	protected abstract void savePNG(JFreeChart chart);
}