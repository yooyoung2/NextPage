package kr.or.ddit.school.manager.teacher.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherIntro {

	@RequestMapping("/school/manager/teacher/intro")
	public String teacherIntro() {
		return "schoolManager/86_87_teacherIntro/teacherIntro";
	}
}
