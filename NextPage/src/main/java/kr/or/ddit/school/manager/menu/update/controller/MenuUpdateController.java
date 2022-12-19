package kr.or.ddit.school.manager.menu.update.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuUpdateController {
	
	@RequestMapping("school/manager/menuUpdate")
	public String bhj() {
		return "schoolManager/79_menuUpdate/menuUpdate";
	}
}
