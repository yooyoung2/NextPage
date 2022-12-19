package kr.or.ddit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class template02Controller {
	
	@RequestMapping("template02/template02Main")
	public String bhj() {
		return "template02/nomenu/1_template02/template02Main";
	}
}
