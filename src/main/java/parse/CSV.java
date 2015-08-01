package parse;

import com.opencsv.CSVReader;
import model.RingChart;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Valter
 */
public class CSV {
    private String file;

    public CSV(String file) {
        this.file = file;
    }

    public List<RingChart> getRingChartData() {
        try {
            List<RingChart> list = new ArrayList<>();
            CSVReader reader = new CSVReader(new FileReader(file), '\t');

            String[] line;
            boolean skip = true;

            //Read one line at a time
            while ((line = reader.readNext()) != null) {
                if (!skip) {
                    RingChart ringChart = new RingChart();
                    for (String token : line) {
                        int column = 0;
                        for (String t : token.split(",")) {
                            if (column == 0) {
                                //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = new Date(format.parse(t).getTime());
                                ringChart.setDate(date);
                            } else if (column == 1) {
                                    ringChart.setSecurity(t);
                                if (!isClean(t)){
                                    // Should we throw an exception when we find some sql/data injection ?
                                    //throw new Exception("Data corrupted:" + t );
                                }
                            } else if (column == 2) {
                                ringChart.setWeighting(Double.parseDouble(t));
                            }
                            column++;
                        }
                    }
                list.add(ringChart);
                }
                skip = false;
            }
            reader.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isClean(String check){
        String[] items ={ "drop", "table", "//" };
        for (String item : items)
            if (check.contains(item))
                return false;
        return true;
    }
}