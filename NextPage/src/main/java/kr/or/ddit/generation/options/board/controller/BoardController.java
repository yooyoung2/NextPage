package kr.or.ddit.generation.options.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	@RequestMapping( value = "generation/options/board", method = RequestMethod.GET )
	public String printBoard() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
