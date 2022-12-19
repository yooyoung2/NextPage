package kr.or.ddit.school.manager.footer.setting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FooterSettingController {
	
	@RequestMapping("school/manager/footerSetting")
	public String bhj() {
		return "schoolManager/75_footerSetting/footerSetting";
	}
}
