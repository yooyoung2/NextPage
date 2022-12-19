package kr.or.ddit.nextpage.member.center.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.vo.NoticeBoardVO;
import kr.or.ddit.vo.SchMemberFileVO;

/*
 * ★양식 다운로드를 위함
 * -김건호
 * 
 */
@Controller
public class NoticeBoardDownloadController {
	@Inject
	private NextPageMemberCenterService service;
	
	
	@RequestMapping("notice/board/download")
	public String download(
		@RequestParam(name="what", required=true) int attNo
		, Model model
	)throws IOException {
		NoticeBoardVO attatch = service.retrieveNotiboard(attNo);
		model.addAttribute("attatch", attatch);
		System.out.println("들어오니?");
		return "NoticeDown";
	}
}

















