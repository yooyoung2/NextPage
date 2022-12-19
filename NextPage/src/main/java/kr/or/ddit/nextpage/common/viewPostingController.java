package kr.or.ddit.nextpage.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class viewPostingController {

	@RequestMapping("nextpage/viewPosting")
	public String PostingView() {
		return "nextpage/22_nextPageMemberCenter/PostingView";
	}
	
}
