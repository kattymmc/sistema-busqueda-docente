package pe.edu.sistemas.sisbusqdoc.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.vandeseer.easytable.RepeatedHeaderTableDrawer;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

import pe.edu.sistemas.sisbusqdoc.converter.HorarioClaseConverter;
import pe.edu.sistemas.sisbusqdoc.entity.HorarioClase;
import pe.edu.sistemas.sisbusqdoc.model.HorarioClaseModel;
import pe.edu.sistemas.sisbusqdoc.service.HorarioClaseService;
@Service
public class PdfGenerator {
	@Autowired
	@Qualifier("horarioClaseServiceImpl")
	private HorarioClaseService horarioService;
	
	public byte[] Lista2PDF(List<HorarioClaseModel> lista) {
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		 try (PDDocument document = new PDDocument()) {
	            final PDPage page = new PDPage(PDRectangle.A4);
	            document.addPage(page);
	                // Build the table
			 		//alto A4 = 841.8898
			 		//ancho A4 = 595.27563
			 		 try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

	                Table.TableBuilder myTable = Table.builder()
	                		
	                        .addColumnsOfWidth(135,135,70,50,50,50,65)
	                        .fontSize(8)
	                        .addRow(Row.builder()
	                        		.add(TextCell.builder().text("Profesor").borderWidth(1).backgroundColor(new Color(98, 175, 227)).build())
	                        		.add(TextCell.builder().text("Curso").borderWidth(1).backgroundColor(new Color(98, 175, 227)).build())
	                        		.add(TextCell.builder().text("Tipo").borderWidth(1).backgroundColor(new Color(98, 175, 227)).build())
	                        		.add(TextCell.builder().text("Grupo").borderWidth(1).backgroundColor(new Color(98, 175, 227)).build())
	                        		.add(TextCell.builder().text("Aula").borderWidth(1).backgroundColor(new Color(98, 175, 227)).build())
	                        		.add(TextCell.builder().text("Dia").borderWidth(1).backgroundColor(new Color(98, 175, 227)).build())
	                        		.add(TextCell.builder().text("Horario").borderWidth(1).backgroundColor(new Color(98, 175, 227)).build())
	                                .build());
	            
	                  for(HorarioClaseModel h: lista) {
	                	  myTable.addRow(Row.builder()
	                			  .add(TextCell.builder().borderWidthLeft(1).borderWidthBottom(1) .text(h.getDocente().getPersona().getFullName()).build())
	                			  .add(TextCell.builder().borderWidthBottom(1).text(h.getGrupo().getCurso().getNombre()).build())
	                			  .add(TextCell.builder().borderWidthBottom(1).text(h.getTipoHorario()).build())
	                			  .add(TextCell.builder().borderWidthBottom(1).text(h.getGrupo().getNumeroCurso().toString()).build())
	                			  .add(TextCell.builder().borderWidthBottom(1).text(h.getAula()).build())
	                			  .add(TextCell.builder().borderWidthBottom(1).text(h.getDiaTexto()).build())
	                			  .add(TextCell.builder().borderWidthRight(1).borderWidthBottom(1).text(h.getHoraInicio() + " " + h.getHoraFin()).build())
	                			  //.height(50f)
	                			  
	                			  .borderColor(Color.black)
	                			  
	                			  .build());
	        
	                  }
	       

	                // Set up the drawer
	                  RepeatedHeaderTableDrawer tableDrawer = RepeatedHeaderTableDrawer.builder()
	                        .contentStream(contentStream)
	                        .startX(20f)
	                        .startY(page.getMediaBox().getUpperRightY() - 20f)
	                       // .startY(50f)
	                        .endY(50F)
	                        .table(myTable.build())
	                        .build();

	                // And go for it!
	                tableDrawer.draw(() -> document, () -> new PDPage(PDRectangle.A4), 50f);
	            }

	            document.save(outStream);
	        } catch (IOException e) {

				e.printStackTrace();
			}
		 
	
			return outStream.toByteArray();
	}
	

}
