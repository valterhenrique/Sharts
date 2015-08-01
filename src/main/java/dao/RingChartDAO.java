package dao;

import model.RingChart;

import java.util.List;

/**
 * Created by Valter on 7/30/2015.
 */
public interface RingChartDAO {

    public void save(RingChart ringChart);
    public void save(List<RingChart> ringChartList);

    public List<RingChart> list();
}
