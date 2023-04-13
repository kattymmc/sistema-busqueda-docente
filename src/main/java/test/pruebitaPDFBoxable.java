package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;

public class pruebitaPDFBoxable {
	public static void main(String[] args) {
	}
	public static byte[] crearPdf() {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ByteArrayInputStream inStream;
		PDDocument doc = new PDDocument();
		PDPage page = addNewPage(doc);
		float margin = 5;
		float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);

		// Initialize table
		float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
		boolean drawContent = true;
		float yStart = yStartNewPage;
		float bottomMargin = 70;
		
		List<List> data = new ArrayList<List>();
		data.add(new ArrayList<>(
				Arrays.asList("Column One", "Column Two", "Column Three", "Column Four", "Column Five")));
		for (int i = 1; i <= 50; i++) {
			data.add(new ArrayList<>(Arrays.asList("Row " + i + " Col One", "Row " + i + " Col Two",
					"Row " + i + " Col Three", "Row " + i + " Col Four", "Row " + i + " Col Five")));
			BaseTable dataTable;
			try {
				dataTable = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true,
						true);
				DataTable t = new DataTable(dataTable, page);
				t.addListToTable(data, DataTable.HASHEADER);
				dataTable.draw();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		try {
			doc.save(outStream);
			doc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//inStream = new ByteArrayInputStream(outStream.toByteArray());
		return outStream.toByteArray();
	}
	
	

	private static PDPage addNewPage(PDDocument doc) {
		PDPage page = new PDPage();
		doc.addPage(page);
		return page;
	}
}
