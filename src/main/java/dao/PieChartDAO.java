package dao;

import model.PieChart;

import java.util.List;

/**
 * Created by Valter on 7/30/2015.
 */
public interface PieChartDAO {
    public void save(PieChart pieChart);
    public void save(List<PieChart> list);

    List<PieChart> list();

}
