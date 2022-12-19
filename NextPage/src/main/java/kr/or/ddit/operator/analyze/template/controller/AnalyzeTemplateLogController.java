package kr.or.ddit.operator.analyze.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnalyzeTemplateLogController {
	
	@RequestMapping( "operator/analyzeTemplate_Log" )
	public String analyzeTemplate_Log() {
		return "operator/16_analyzeTemplate_log/analyzeTemplate_Log";
		
	}


}
