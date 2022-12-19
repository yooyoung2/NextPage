package kr.or.ddit.operator.detail.oto.ask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailOneToOneAskController {

	@RequestMapping( "operator/detailOnetoOneAsk" )
	public String detailOnetoOneAsk() {
		return "operator/18_detailOnetoOneAsk/detailOnetoOneAsk";
		
	}
}
