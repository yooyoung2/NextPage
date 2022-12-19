package kr.or.ddit.school.manager.menu.history.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuHistoryController {
	@RequestMapping("school/manager/menu/history")
	public String menuHistory() {
		return "schoolManager/96_menuHistory/menuHistory";
	}

}
