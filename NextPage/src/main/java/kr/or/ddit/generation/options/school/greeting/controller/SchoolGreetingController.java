package kr.or.ddit.generation.options.school.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SchoolGreetingController {

	@RequestMapping( value = "generation/options/school/print", 
					method = RequestMethod.GET )
	public String printSchoolGreeting() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
