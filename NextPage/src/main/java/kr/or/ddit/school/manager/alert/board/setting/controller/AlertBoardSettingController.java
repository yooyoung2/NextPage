package kr.or.ddit.school.manager.alert.board.setting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlertBoardSettingController {
	
	@RequestMapping("school/manager/alertBoardSetting")
	public String AlertBoardSetting() {
		return "schoolManager/73_alertBoardSetting/alertBoardSetting";
	}
}
