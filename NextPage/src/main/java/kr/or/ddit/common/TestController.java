package kr.or.ddit.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( "test/" )
public class TestController {

	@RequestMapping( value = "jack/snider" , method = RequestMethod.GET )
	public String testView() {
		
		String viewName = "";
		
		viewName = "template02/1_template02/template02Main";
		
		return viewName;
		
	}
	
	
}
