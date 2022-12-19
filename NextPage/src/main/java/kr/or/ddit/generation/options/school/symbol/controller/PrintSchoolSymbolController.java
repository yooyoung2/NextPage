package kr.or.ddit.generation.options.school.symbol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrintSchoolSymbolController {

	@RequestMapping( value = "generation/school/symbol",
					method = RequestMethod.GET
			)
	public String printSchoolSymbol() {
		
			String viewName = null;
			
			return viewName;
		
	}
	
}
