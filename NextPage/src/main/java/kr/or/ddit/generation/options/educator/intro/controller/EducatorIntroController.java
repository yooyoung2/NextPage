package kr.or.ddit.generation.options.educator.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EducatorIntroController {

	
	@RequestMapping( value = "generation/options/educator/intro",
					method = RequestMethod.GET )
	public String printEducatorIntro() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
