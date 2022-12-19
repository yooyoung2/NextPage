package kr.or.ddit.school.manager.select.detail.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectDetailStudentController {
	@RequestMapping("schoolManager/selectDetailStudent")
	public String selectDetailStudent() {
		return "schoolManager/114_selectDetailStudent/selectDetailStudent";
	}
}
