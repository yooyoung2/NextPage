package kr.or.ddit.generation.options.footer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FooterController {

	@RequestMapping( value = "generation/options/footer", method = RequestMethod.GET )
	public String printFooter() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
