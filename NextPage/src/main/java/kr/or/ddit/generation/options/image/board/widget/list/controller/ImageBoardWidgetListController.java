package kr.or.ddit.generation.options.image.board.widget.list.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImageBoardWidgetListController {

	@RequestMapping( value = "generation/options/image/board/widget/list",
					method = RequestMethod.GET
					)
	public String printImageBoardWidgetList() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
