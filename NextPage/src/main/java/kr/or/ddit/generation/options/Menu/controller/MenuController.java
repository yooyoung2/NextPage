package kr.or.ddit.generation.options.Menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {

	@RequestMapping( value = "generation/options/menu",
					method = RequestMethod.GET )
	public String printMenu() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
