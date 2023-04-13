package pe.edu.sistemas.sisbusqdoc.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.sistemas.sisbusqdoc.constante.ViewConstant;
import pe.edu.sistemas.sisbusqdoc.converter.HorarioClaseConverter;
import pe.edu.sistemas.sisbusqdoc.model.HorarioClaseModel;
import pe.edu.sistemas.sisbusqdoc.service.DocenteService;
import pe.edu.sistemas.sisbusqdoc.service.HorarioClaseService;
import pe.edu.sistemas.sisbusqdoc.service.impl.PdfGenerator;

@Controller
@RequestMapping("/horarios")
public class HorarioController {
	@Autowired
	@Qualifier("horarioClaseServiceImpl")
	private HorarioClaseService horarioService;

	@Autowired
	@Qualifier("docenteServiceImpl")
	private DocenteService docService;
	
	@Autowired
	@Qualifier("pdfGenerator")
	private PdfGenerator pdfGen;
	

	private List<HorarioClaseModel> busquedaActual= new ArrayList<>();
	public static final Log LOG = LogFactory.getLog(HorarioController.class);

	@GetMapping("/mostrarHorarios")
	private String mostarContactos(Model model, @RequestParam(name = "busqueda", defaultValue = "") String busqueda, @RequestParam(name = "tipo", defaultValue = "profesor") String tipo) {
		if (!busqueda.equals("")){
			switch(HorarioClaseService.tiposBusqueda.valueOf(tipo)) {
				case curso:
					busquedaActual = horarioService.buscarPorCurso(busqueda);
					break;
				case dia:
					//temporal aun no funcina
					busquedaActual = horarioService.buscarPorDia(0);
					break;
				case profesor:
					busquedaActual = horarioService.buscarPorCodigoOrNombre(busqueda);
					break;
				default:
					break;
			
			}
		}else {
			busquedaActual = horarioService.mostrarPeriodoActual();
		}
		model.addAttribute("horarios",busquedaActual);
		model.addAttribute("tipoBusqueda",HorarioClaseService.tiposBusqueda.values());
		return ViewConstant.HORARIO;
	}

	@GetMapping(value = "/crearPDF")
	public ResponseEntity<byte[]> getFile() {
		try {

			//byte[] pdf = pruebitaPDFBoxable.crearPdf();
			//byte[] pdf = pruebitaEasyTable.generarPDF();
			byte[] pdf = pdfGen.Lista2PDF(busquedaActual);
			ByteArrayInputStream inStream = new ByteArrayInputStream(pdf);

			HttpHeaders respHeaders = new HttpHeaders();
			respHeaders.setContentType(MediaType.parseMediaType("application/pdf"));
			respHeaders.setContentDispositionFormData("attachment", "reporte.pdf");//nombre del archivo
			
			return new ResponseEntity<byte[]>(pdf, respHeaders, HttpStatus.OK);

		} catch (Exception e) {

			LOG.error("error pdf", e);
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
