package chart;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;

/**
 * Created by Valter
 */
public abstract class Chart {
    public abstract void draw();
    protected abstract PieDataset createDataset();
    protected abstract JFreeChart createChart(PieDataset chart);
    protected abstract void paintChart(JFreeChart chart);
    protected abstract void savePNG(JFreeChart chart);
}
