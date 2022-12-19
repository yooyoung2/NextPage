package kr.or.ddit.school.manager.main.Image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainImageController {
	
	@RequestMapping("school/manager/mainImage")
	public String bhj() {
		return "schoolManager/70_mainImage/mainImage";
	}
}
