package run;

import dao.PieChartDAO;
import dao.RingChartDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.chart.DrawPieChart;
import util.chart.DrawRingChart;
import util.pdf.PDF;
import util.read.CSV;
import util.read.Excel;

/**
 * Author: Valter
 */
class Application
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");

		// read the piechart from the .xls file and save the data in db
		Excel excel = new Excel("input/piechart-data.xls");
		PieChartDAO pieChartDAO = context.getBean(PieChartDAO.class);
		pieChartDAO.save(excel.getPieChartData());

		// get the piechart data from db and draw it in a .png file
		DrawPieChart drawPieChart = new DrawPieChart("ANTEIL AM FONDSVERM\u00D6GEN", pieChartDAO.list());
		drawPieChart.draw();

		// read the ringchart from .csv file and save the data in db
		CSV CSV = new CSV("input/Ring Chart Data.csv");
		RingChartDAO ringChartDAO = context.getBean(RingChartDAO.class);
		ringChartDAO.save(CSV.getRingChartData());

		// get the ringchart data from db and draw it in a .png file
		DrawRingChart drawRingChart = new DrawRingChart(ringChartDAO.list());
		drawRingChart.draw();

		// generate the pdf with both charts images
		PDF pdf = new PDF();
		pdf.generate();

		context.close();

	}
}
