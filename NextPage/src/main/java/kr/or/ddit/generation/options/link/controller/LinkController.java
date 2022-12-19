package kr.or.ddit.generation.options.link.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LinkController {

	@RequestMapping( value = "generation/options/link", method = RequestMethod.GET )
	public String printLink() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
