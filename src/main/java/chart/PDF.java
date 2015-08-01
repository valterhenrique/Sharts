package chart;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: Valter
 */
public class PDF
{
	public void generate()
	{
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("output/Sharts.pdf"));
			document.open();

			// add piechart image to pdf
			String filename = "output/PieChart.png";
			Image image = Image.getInstance(filename);
			document.add(image);

			// add ringchart image to pdf
			filename = "output/RingChart.png";
			image = Image.getInstance(filename);
			document.add(image);

		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}
}
