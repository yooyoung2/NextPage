package kr.or.ddit.school.manager.post.history.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostHistoryController {
	@RequestMapping("school/manager/post/history")
	public String postHistory() {
		return "schoolManager/98_postHistory/postHistory";
	}
}
