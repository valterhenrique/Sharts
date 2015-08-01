package util.chart;

import model.PieChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.ColumnArrangement;
import org.jfree.chart.block.FlowArrangement;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* Create a pie util.temp.chart and save it in a .png file
*/
public class DrawPieChart extends Chart
{
	private final String title;
	private final List<PieChart> list;

	@SuppressWarnings("SameParameterValue")
	public DrawPieChart(String title, List<PieChart> list)
	{
		this.title = title;
		this.list = list;
	}

	@Override
	public void draw()
	{
		JFreeChart chart = createChart(createDataset());
		paintChart(chart);
		savePNG(chart);
	}

	@Override
	protected PieDataset createDataset()
	{
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (PieChart chart : list) {
			dataset.setValue(chart.getCountry(), chart.getWeight());
		}
		return dataset;
	}

	@Override
	protected JFreeChart createChart(PieDataset dataset)
	{
		JFreeChart chart = ChartFactory.createPieChart("", dataset, true, true, true);
		Color transparent = new Color(0.0f, 0.0f, 0.0f, 0.0f);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setCircular(true);
		plot.setSimpleLabels(true);
		PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator("{2}");
		plot.setLabelGenerator(generator);
		plot.setBackgroundPaint(Color.WHITE); //background
		plot.setOutlineVisible(false); //remove image border

		// label
		plot.setLabelFont(new Font("SansSerif", Font.BOLD, 15));
		plot.setLabelPaint(Color.WHITE);
		plot.setLabelBackgroundPaint(transparent); //background
		plot.setLabelOutlinePaint(transparent); //border
		plot.setLabelShadowPaint(transparent); //shadow

		// legend
		chart.removeLegend();
		FlowArrangement hlayout = new FlowArrangement(HorizontalAlignment.CENTER, VerticalAlignment.CENTER, 537, 1);
		LegendTitle legend = new LegendTitle(plot, hlayout, new ColumnArrangement());
		legend.setItemFont(new Font("SansSerif", 0, 14));
		legend.setPadding(0, 70, 0, 0);
		legend.setPosition(RectangleEdge.BOTTOM);
		chart.addLegend(legend);

		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));
		plot.setBaseSectionOutlinePaint(Color.WHITE);
		plot.setSectionOutlinesVisible(true);

		// title
		TextTitle title = new TextTitle(this.title);
		title.setFont(new Font("SansSerif", 0, 12));
		title.setPosition(RectangleEdge.BOTTOM);
		title.setHorizontalAlignment(HorizontalAlignment.LEFT);
		title.setPadding(0, 70, 0, 0);
		chart.addSubtitle(title);

		return chart;
	}

	@Override
	protected void paintChart(JFreeChart chart)
	{

		List<Color> colors = new ArrayList<>();
		colors.add(new Color(126, 208, 150));
		colors.add(new Color(41, 157, 135));
		colors.add(new Color(25, 144, 212));
		colors.add(new Color(95, 85, 25));
		colors.add(new Color(22, 90, 63));
		colors.add(new Color(134, 125, 25));
		colors.add(new Color(226, 200, 14));
		colors.add(new Color(241, 172, 18));
		colors.add(new Color(245, 200, 51));

		if (list.size() > colors.size()) {
			Random random = new Random();
			for (PieChart pieChart : list) {
				int r = random.nextInt(255);
				int g = random.nextInt(255);
				int b = random.nextInt(255);
				colors.add(new Color(r, g, b));
			}
		}

		int i = 0;
		PiePlot plot = (PiePlot) chart.getPlot();
		List<String> painteds = new ArrayList<>(); //ensure the color scheme will keep
		for (PieChart pieChart : list) {
			if (!painteds.contains(pieChart.getCountry())) {
				plot.setSectionPaint(pieChart.getCountry(), colors.get(i));
				painteds.add(pieChart.getCountry());
			}
			i++;
		}
	}

	@Override
	protected void savePNG(JFreeChart chart)
	{
		try {
			int width = 537;
			int height = 750;
			File file = new File("output/PieChart.png");
			ChartUtilities.saveChartAsPNG(file, chart, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}