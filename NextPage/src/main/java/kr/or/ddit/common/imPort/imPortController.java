package kr.or.ddit.common.imPort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("nextPage/pay")
public class imPortController {
	
	@RequestMapping
	public String payTest() {
		return "/NextPage2/src/main/webapp/WEB-INF/views/nextpage/pay/import.jsp";
	}

}
