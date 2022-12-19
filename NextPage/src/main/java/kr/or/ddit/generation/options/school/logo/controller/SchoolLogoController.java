package kr.or.ddit.generation.options.school.logo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SchoolLogoController {

	@RequestMapping( value = "generation/options/school/logo",
					 method = RequestMethod.GET )
	public String printSchoolLogo() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
