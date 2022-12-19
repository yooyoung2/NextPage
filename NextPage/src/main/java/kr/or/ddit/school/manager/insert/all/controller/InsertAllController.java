package kr.or.ddit.school.manager.insert.all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertAllController {
	@RequestMapping("schoolManager/insertAll")
	public String insertAll() {
		return "schoolManager/101_insertAll/insertAll";
	}
}
