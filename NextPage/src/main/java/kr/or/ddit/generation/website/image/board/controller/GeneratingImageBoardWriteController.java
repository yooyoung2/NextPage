package kr.or.ddit.generation.website.image.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneratingImageBoardWriteController {

	@RequestMapping( "generation/generatingImageBoardWrite" )
	public String generatingImageBoardWrite() {
		return "generation/template01/56_generatingImageBoardWrite/generatingImageBoardWrite";
		
	}
}
