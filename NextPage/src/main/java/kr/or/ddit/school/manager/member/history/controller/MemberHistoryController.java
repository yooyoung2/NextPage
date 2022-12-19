package kr.or.ddit.school.manager.member.history.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberHistoryController {
	@RequestMapping("school/manager/member/history")
	public String memberHistory() {
		return "schoolManager/95_memberHistory/memberHistory";
	}
}
