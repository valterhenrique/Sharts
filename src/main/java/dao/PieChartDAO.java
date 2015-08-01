package dao;

import model.PieChart;

import java.util.List;

/**
 * Author: Valter
 */
public interface PieChartDAO
{
	void save(PieChart pieChart);

	void save(List<PieChart> list);

	List<PieChart> list();

}
