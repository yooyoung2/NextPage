package kr.or.ddit.school.manager.select.detail.ask_.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectDetailAskController {
	@RequestMapping("schoolManager/selectDetailAsk")
	public String selectDetailAsk() {
		return "schoolManager/120_selectDetailAsk/selectDetailAsk";
	}
}
