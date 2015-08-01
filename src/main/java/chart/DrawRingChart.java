package chart;

import model.RingChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawRingChart extends Chart
{
    private List<RingChart> list;

    public DrawRingChart(List<RingChart> list) {
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
        for (RingChart chart : list)
        {
            dataset.setValue(chart.getSecurity(), chart.getWeighting());
        }
        return dataset;
    }

    @Override
    protected JFreeChart createChart(PieDataset piedataset)
    {
        JFreeChart chart = ChartFactory.createRingChart("", piedataset, true, true, true);
        RingPlot plot = (RingPlot)chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", 0, 12));
        plot.setNoDataMessage("No data available");
        plot.setSectionDepth(0.54999999999999998D);
        plot.setCircular(true);
        plot.setLabelGap(0.02D);
        plot.setLabelGenerator(null);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false); //remove image border
        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{2}"));

//        TextTitle title = new TextTitle();
//        title.setPosition(RectangleEdge.RIGHT);
//        chart.addSubtitle(title);

        LegendTitle legend = chart.getLegend();
        legend.setPosition(RectangleEdge.RIGHT);
        legend.setFrame(BlockBorder.NONE);

        return chart;
    }

    @Override
    protected void paintChart(JFreeChart chart) {
        List<Color> colors = new ArrayList<>();
        colors.add(new Color(126, 208, 150));
        colors.add(new Color(41, 157, 135));
        colors.add(new Color(25, 144, 212));
        colors.add(new Color(57, 91, 133));
        colors.add(new Color(95, 85, 25));
        colors.add(new Color(22, 90, 63));

        if (list.size() > colors.size()) {
            Random random = new Random();
            for (RingChart ringChart : list) {
                int r = random.nextInt(255);
                int g = random.nextInt(255);
                int b = random.nextInt(255);
                colors.add(new Color(r,g,b));
            }
        }

        int i = 0;
        RingPlot plot = (RingPlot) chart.getPlot();
        List<String> painteds = new ArrayList<>(); //ensure the color scheme will keep
        for (RingChart ringChart : list)
        {
            if (!painteds.contains(ringChart.getSecurity()))
            {
                plot.setSectionPaint(ringChart.getSecurity(), colors.get(i));
                painteds.add(ringChart.getSecurity());
            }
            i++;
        }
    }

    @Override
    protected void savePNG(JFreeChart jfreechart) {
        try {
            int width = 640; /* Width of the image */
            int height = 480; /* Height of the image */
            File file = new File("output/RingChart.png");
            ChartUtilities.saveChartAsPNG(file, jfreechart, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}