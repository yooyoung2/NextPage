package kr.or.ddit.nextpage.company.onway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NextPageOnwayController {
	
	@RequestMapping( value = "nextpage/compnay/onway.do", method = RequestMethod.GET )
	public String nextPageOnWay() {
		return "nextpage/companyIntroduction/13_nextPageCompanyOnWay/nextPageCompanyOnWay";
	}
	
}
