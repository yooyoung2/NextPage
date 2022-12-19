package kr.or.ddit.generation.options.educator.intro.Info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EducatorIntroInfoController {

	@RequestMapping( value = "generation/options/educator/intro/info",
					method = RequestMethod.GET )
	public String printEducatorIntroInfo() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
