package kr.or.ddit.school.manager.board.slot.setting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardSlotSettingController {
	
	@RequestMapping("school/manager/boardSlotSetting")
	public String bhj() {
		return "schoolManager/71_boardSlotSetting/boardSlotSetting";
	}
}
