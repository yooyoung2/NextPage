package kr.or.ddit.generation.website.write.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneratingWriteController {
	
	@RequestMapping( "generation/generatingWrite" )
	public String generatingWrite() {
		return "generation/template01/62_generatingWrite/generatingWrite";
		
	}


}
