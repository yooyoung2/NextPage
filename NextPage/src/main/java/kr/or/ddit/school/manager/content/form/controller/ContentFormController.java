package kr.or.ddit.school.manager.content.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(  )
@Controller
public class ContentFormController {
	
	@RequestMapping("schoolManager/contentForm")
	public String contentForm() {
		return "schoolManager/93_94_contentForm/contentForm";
	} 

}
