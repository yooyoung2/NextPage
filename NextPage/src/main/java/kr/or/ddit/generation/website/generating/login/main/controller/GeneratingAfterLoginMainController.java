package kr.or.ddit.generation.website.generating.login.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneratingAfterLoginMainController {
	@RequestMapping( "generation/generatingAfterLoginMain" )
	public String generatingAfterLoginMain() {
		return "generation/template01/nomenu/46_generatingAfterLoginMain/generatingAfterLoginMain";
		
	}

}
