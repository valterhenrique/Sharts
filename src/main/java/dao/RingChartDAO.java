package dao;

import model.RingChart;

import java.util.List;

/**
 * Author: Valter
 */
public interface RingChartDAO
{

	void save(RingChart ringChart);

	void save(List<RingChart> ringChartList);

	List<RingChart> list();
}
