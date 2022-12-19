package kr.or.ddit.school.manager.menu.add.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuAddController {
	
	@RequestMapping("school/manager/menuAdd")
	public String bhj() {
		return "schoolManager/77_menuAdd/menuAdd";
	}
}
