package kr.or.ddit.nextpage.useguide.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NextPageServiceUseGuideController {

	@RequestMapping( "nextpage/nextPageServiceUseGuide" )
	public String nextPageServiceUseGuide() {
		return "nextpage/19_nextPageServiceUseGuide/nextPageServiceUseGuide";
	}
	
}
