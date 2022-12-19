package kr.or.ddit.nextpage.useguide.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NextPageSystemUseGuideController {

	@RequestMapping( "nextpage/nextPageSystemUseGuide" )
	public String nextPageSystemUseGuide() {
		return "nextpage/systemGuide/20_nextPageSystemUseGuide/nextPageSystemUseGuide";
	}
}
