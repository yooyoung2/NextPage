package kr.or.ddit.school.manager.image.board.slot.setting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class imageBoardSlotSettingController {
	
	@RequestMapping("school/manager/imageBoardSlotSetting")
	public String bhj() {
		return "schoolManager/72_imageBoardSlotSetting/imageBoardSlotSetting";
	}
}
