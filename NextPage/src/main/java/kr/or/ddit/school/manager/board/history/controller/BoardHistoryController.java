package kr.or.ddit.school.manager.board.history.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardHistoryController {
	@RequestMapping("school/manager/board/history")
	public String boardHistory() {
		return "schoolManager/97_boardHistory/boardHistory";
	}
}
