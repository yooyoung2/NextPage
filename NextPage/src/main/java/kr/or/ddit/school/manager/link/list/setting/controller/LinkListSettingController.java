package kr.or.ddit.school.manager.link.list.setting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinkListSettingController {
	
	@RequestMapping("school/manager/linkListSetting")
	public String bhj() {
		return "schoolManager/74_linkListSetting/linkListSetting";
	}
}
