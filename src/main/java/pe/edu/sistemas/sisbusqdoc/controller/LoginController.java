package pe.edu.sistemas.sisbusqdoc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.sistemas.sisbusqdoc.constante.ViewConstant;
@Controller
public class LoginController {
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	public String redirectLogin() {
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model,@RequestParam(name="error",required=false) String error,@RequestParam(name="logout",required=false) String logout) {
		LOG.info("Method redirectToLogin() -- PARAMS:  error =" + error + " logout="+logout );
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		LOG.info("returning login view");
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"/Loginsuccess","/"})
	public String LoginCheck() {
		LOG.info("Method: LoginCheck()");
		LOG.info("returning contacts view");
		return "redirect:/horarios/mostrarHorarios";
	}
	
}
