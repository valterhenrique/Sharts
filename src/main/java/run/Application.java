package run;

import chart.DrawPieChart;
import chart.DrawRingChart;
import chart.PDF;
import dao.PieChartDAO;
import dao.RingChartDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import parse.CSV;
import parse.Excel;

/**
 * Author: Valter
 */
class Application
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");

		Excel excel = new Excel("input/piechart-data.xls");
		PieChartDAO pieChartDAO = context.getBean(PieChartDAO.class);
		pieChartDAO.save(excel.getPieChartData());

		DrawPieChart drawPieChart = new DrawPieChart("ANTEIL AM FONDSVERM\u00D6GEN", pieChartDAO.list());
		drawPieChart.draw();

		CSV CSV = new CSV("input/Ring Chart Data.csv");
		RingChartDAO ringChartDAO = context.getBean(RingChartDAO.class);
		ringChartDAO.save(CSV.getRingChartData());

		DrawRingChart drawRingChart = new DrawRingChart(ringChartDAO.list());
		drawRingChart.draw();

		PDF pdf = new PDF();
		pdf.generate();

		context.close();

	}
}
