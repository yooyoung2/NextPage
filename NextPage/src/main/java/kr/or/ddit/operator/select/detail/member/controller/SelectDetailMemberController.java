package kr.or.ddit.operator.select.detail.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectDetailMemberController {
	@RequestMapping("operator/selectDetailMember")
	public String selectDetailMember() {
		return "operator/04_selectDetailMember/selectDetailMember";
	}

	
}
