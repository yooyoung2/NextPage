package kr.or.ddit.generation.options.linked.list.widget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LinkedListWidgetController {

	@RequestMapping( value = "generation/options/linked/list/widget",
					method = RequestMethod.GET )
	public String printLinkedListWidget() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
