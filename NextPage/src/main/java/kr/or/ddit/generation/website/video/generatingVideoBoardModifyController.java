package kr.or.ddit.generation.website.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class generatingVideoBoardModifyController {

	@RequestMapping( "generation/generatingVideoBoardModify" )
	public String generatingVideoBoardModify() {
		return "generation/template01/generatingBoardModify/generatingVideoBoardModify";
		
	}
}
