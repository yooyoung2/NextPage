package kr.or.ddit.generation.options.bottom.banner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BottomBannerController {

	@RequestMapping( value = "generation/options/bottom/banner", method = RequestMethod.GET )
	public String printBottomBanner() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
