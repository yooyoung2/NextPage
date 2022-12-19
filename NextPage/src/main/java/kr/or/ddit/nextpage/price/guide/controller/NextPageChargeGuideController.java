package kr.or.ddit.nextpage.price.guide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NextPageChargeGuideController {
	
	@RequestMapping( "nextpage/nextPageChargeGuide" )
	public String nextPageChargeGuide() {
		return "nextpage/feeInformation/21_nextPageChargeGuide/nextPageChargeGuide";
	}
}
