package kr.or.ddit.generation.website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class generatingDirectionListController {
	
	@RequestMapping( "generation/generatingDirection" )
	public String generatingDirection() {
		return "generation/template01/60_generatingDirection/generatingDirection";
		
	}

}
