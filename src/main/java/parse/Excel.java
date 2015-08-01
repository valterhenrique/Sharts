package parse;

import model.PieChart;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Valter
 */
public class Excel
{

	private final String file;

	@SuppressWarnings("SameParameterValue")
	public Excel(String file)
	{
		this.file = file;
	}

	private HSSFSheet setup()
	{
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(this.file));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			return wb.getSheetAt(0);

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	public List<PieChart> getPieChartData()
	{
		HSSFSheet sheet = setup();
		List<PieChart> list = new ArrayList<>();

		if (sheet != null) {
			boolean skip = true;
			for (Row row : sheet) {
				if (!skip) {
					PieChart pieChart = new PieChart();

					for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
						Cell cell = row.getCell(i);
						if (cell != null) {
							if (i == 0 && (cell.getCellType() == Cell.CELL_TYPE_STRING))
								pieChart.setCountry(cell.getStringCellValue());

							else if (i == 1 && cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								pieChart.setWeight(cell.getNumericCellValue());
							}
						}
					}
					if (pieChart.getCountry() != null && pieChart.getWeight() != null) list.add(pieChart);
				}
				skip = false; //skip first row
			}
		}
		return list;
	}
}