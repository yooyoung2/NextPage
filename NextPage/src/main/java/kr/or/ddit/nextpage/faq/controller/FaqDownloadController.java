package kr.or.ddit.nextpage.faq.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.nextpage.faq.service.NextPageFAQService;
import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.vo.FaqVO;

/*
 * ★양식 다운로드를 위함
 * -김건호
 * 
 */
@Controller
public class FaqDownloadController {
	@Inject
	private NextPageFAQService service;
	
	
	@RequestMapping("nextpage/faq/download")
	public String download(
		@RequestParam(name="what", required=true) int attNo
		, Model model
	)throws IOException {
		FaqVO attatch = service.retrieveFaq(attNo);
		model.addAttribute("attatch", attatch);
		System.out.println("들어오니?");
		return "FaqDown";
	}
}

















