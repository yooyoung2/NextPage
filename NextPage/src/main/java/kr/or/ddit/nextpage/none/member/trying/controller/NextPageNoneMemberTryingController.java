package kr.or.ddit.nextpage.none.member.trying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NextPageNoneMemberTryingController {

	@RequestMapping( value = "nextpage/user/template/trying.do", method = RequestMethod.GET )
	public String nextPageNoneMemberTrying() {
		
		return "nextpage/17_nextPageNoneMemberTry/nextPageNoneMemberTry";
		
	}
	
}
