package kr.or.ddit.operator.select.visitor.amount.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class selectVisitorAmountController {
	@RequestMapping("operator/selectVisitorAmount")
	public String SelectVisitorAmount() {
		return "operator/06_selectVisitorAmount/selectVisitorAmount";
	}
}
