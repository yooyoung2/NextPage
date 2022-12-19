package kr.or.ddit.school.manager.insert.all.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertAllFormController {
	@RequestMapping("schoolManager/insertAllForm")
	public String insertAllForm() {
		return "schoolManager/102_insertAllForm/insertAllForm";
	}
}
