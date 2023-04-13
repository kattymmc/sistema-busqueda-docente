package test;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

import pe.edu.sistemas.sisbusqdoc.service.HorarioClaseService;

public class pruebitaEasyTable {
	public static byte[] generarPDF() {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		 try (PDDocument document = new PDDocument()) {
	            final PDPage page = new PDPage(PDRectangle.A4);
	            document.addPage(page);

	            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

	                // Build the table
	                Table myTable = Table.builder()
	                        .addColumnsOfWidth(100, 100)
	                        .addRow(Row.builder()
	                                .add(TextCell.builder().text("One One").borderWidth(1).backgroundColor(Color.GRAY).build())
	                                .add(TextCell.builder().text("One Two").borderWidth(1).backgroundColor(Color.LIGHT_GRAY).build())
	                                .build())
	                        .addRow(Row.builder()
	                                .add(TextCell.builder().text("Two One").borderWidth(1).textColor(Color.RED).build())
	                                .add(TextCell.builder().text("Two Two").borderWidth(1).horizontalAlignment(HorizontalAlignment.RIGHT).build())
	                                .build())
	                        .build();

	                // Set up the drawer
	                TableDrawer tableDrawer = TableDrawer.builder()
	                        .contentStream(contentStream)
	                        .startX(20f)
	                        .startY(page.getMediaBox().getUpperRightY() - 20f)
	                        .table(myTable)
	                        .build();

	                // And go for it!
	                tableDrawer.draw();
	            }

	            document.save(outStream);
	        } catch (IOException e) {

				e.printStackTrace();
			}
			return outStream.toByteArray();
	    }
	
	
    public static void main(String[] args) throws IOException {

        try (PDDocument document = new PDDocument()) {
            final PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

                // Build the table
                Table myTable = Table.builder()
                        .addColumnsOfWidth(100, 100)
                        .addRow(Row.builder()
                                .add(TextCell.builder().text("One One").borderWidth(1).backgroundColor(Color.GRAY).build())
                                .add(TextCell.builder().text("One Two").borderWidth(1).backgroundColor(Color.LIGHT_GRAY).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text("Two One").borderWidth(1).textColor(Color.RED).build())
                                .add(TextCell.builder().text("Two Two").borderWidth(1).horizontalAlignment(HorizontalAlignment.RIGHT).build())
                                .build())
                        .build();

                // Set up the drawer
                TableDrawer tableDrawer = TableDrawer.builder()
                        .contentStream(contentStream)
                        .startX(20f)
                        .startY(page.getMediaBox().getUpperRightY() - 20f)
                        .table(myTable)
                        .build();

                // And go for it!
                tableDrawer.draw();
            }

            document.save("example.pdf");
        }
    }
	
	
}
