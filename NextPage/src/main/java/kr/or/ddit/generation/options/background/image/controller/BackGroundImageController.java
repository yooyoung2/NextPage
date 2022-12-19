package kr.or.ddit.generation.options.background.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackGroundImageController {

	@RequestMapping( "generation/options/backgroundimage" )
	public String printBackGround() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
