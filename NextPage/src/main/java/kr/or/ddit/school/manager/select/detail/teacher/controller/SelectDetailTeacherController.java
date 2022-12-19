package kr.or.ddit.school.manager.select.detail.teacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectDetailTeacherController {
	@RequestMapping("schoolManager/selectDetailTeacher")
	public String selectDetailTeacher() {
		return "schoolManager/116_selectDetailTeacher/selectDetailTeacher";
	}
}
