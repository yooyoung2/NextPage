package kr.or.ddit.school.manager.select.detail.parent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectDetailParentController {
	@RequestMapping("schoolManager/selectDetailParent")
	public String selectDetailParent() {
		return "schoolManager/115_selectDetailParent/selectDetailParent";
	}
}
