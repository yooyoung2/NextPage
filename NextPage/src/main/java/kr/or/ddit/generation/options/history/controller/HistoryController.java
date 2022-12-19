package kr.or.ddit.generation.options.history.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoryController {

	/*
	 * 1. NEXTPAGE에서 넣은 연혁 데이터를 여기서 불러온다.
	 * 2. 출력하고 
	 * 3. VIEWNAME -> 출력할 페이지 경로로 뿌린다.
	 * 
	 * 
	 */
	
	@RequestMapping( "generation/options/history" )
	public String printHistory() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
	
}
