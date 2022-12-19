package kr.or.ddit.school.manager.menu.access.authority.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuAccessAuthorityController {
	
	@RequestMapping("school/manager/menuAccessAuthority")
	public String bhj() {
		return "schoolManager/78_menuAccessAuthority/menuAccessAuthority";
	}
}
