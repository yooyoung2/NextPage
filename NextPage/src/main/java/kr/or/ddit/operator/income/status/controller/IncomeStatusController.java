package kr.or.ddit.operator.income.status.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncomeStatusController {
	@RequestMapping("operator/incomeStatus")
	public String incomeStatus() {
		return "operator/09_incomeStatus/incomeStatus";
	}
}
