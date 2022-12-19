package kr.or.ddit.generation.options.image.board.widget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImageBoardWidgetController {

	@RequestMapping( value = "generation/options/image/board/widget", method = RequestMethod.GET )
	public String printImageBoardWidget() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
