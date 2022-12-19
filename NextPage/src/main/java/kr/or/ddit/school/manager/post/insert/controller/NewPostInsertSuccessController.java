package kr.or.ddit.school.manager.post.insert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewPostInsertSuccessController {
	
	@RequestMapping("schoolManager/newPostInsertSuccess")
	public String newPostInsertSuccess() {
		return "schoolManager/119_newPostInsertSuccess/newPostInsertSuccess";
	}
}
