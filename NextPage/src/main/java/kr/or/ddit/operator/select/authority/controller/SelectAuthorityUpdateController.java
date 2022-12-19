package kr.or.ddit.operator.select.authority.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectAuthorityUpdateController {
	@RequestMapping("operator/selectAuthorityUpdate")
	public String SelectAuthorityUpdate() {
		return "operator/05_selectAuthority/selectAuthorityUpdate";
	}
}
