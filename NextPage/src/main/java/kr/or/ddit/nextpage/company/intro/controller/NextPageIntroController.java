package kr.or.ddit.nextpage.company.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NextPageIntroController {
	
	@RequestMapping( "nextpage/user/company/info.do" )
	public String nextPageIntro() {
		return "nextpage/companyIntroduction/11_nextPageCompanyIntro/nextPageCompanyIntro";
	}
	
}
