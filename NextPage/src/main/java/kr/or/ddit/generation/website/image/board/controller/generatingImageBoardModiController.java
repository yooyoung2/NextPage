package kr.or.ddit.generation.website.image.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class generatingImageBoardModiController {
	@RequestMapping( "generation/generatingImageBoardModify" )
	public String generatingImageBoardModify() {
		return "generation/template01/generatingBoardModify/generatingImageBoardModify";
		
	}


}
