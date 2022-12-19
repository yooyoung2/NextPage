package kr.or.ddit.nextpage.company.team.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NextPageTeamIntroController {

	@RequestMapping( value = "nextpage/compnay/team/intro.do", method = RequestMethod.GET )
	public String nextPageTeamIntro() {
		return "nextpage/companyIntroduction/12_nextPageCompanyTeamIntro/nextPageCompanyTeamIntro";
	}
	
}
