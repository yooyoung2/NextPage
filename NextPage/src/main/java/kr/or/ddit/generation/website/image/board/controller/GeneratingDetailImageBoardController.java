package kr.or.ddit.generation.website.image.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneratingDetailImageBoardController {
	
	@RequestMapping( "generation/generatingDetailImageBoard" )
	public String generatingDetailImageBoard() {
		return "generation/template01/55_generatingDetailImageBoard/generatingDetailImageBoard";
		
	}

}
