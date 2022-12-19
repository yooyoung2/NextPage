package kr.or.ddit.nextpage.member.center.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.vo.NoticeBoardVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 공지사항 상세조회
 *
 * @author PC-06
 *
 */
@Slf4j
@Controller
@RequestMapping("nextpage/PostingView.do")
public class NotiBoardViewController {

	@Inject
	private NextPageMemberCenterService service;

//	@ModelAttribute("command")
//	public String command() {
//		return "수정";
//	}

	@GetMapping
	public String notiBoardView(@RequestParam(name = "who") int notisNum, Model model) {
		NoticeBoardVO noti = service.retrieveNotiboard(notisNum);
		model.addAttribute("noti", noti);

		log.info("model은???", model);

		String viewName = "nextpage/customerService/22_nextPageMemberCenter/PostingView";

		return viewName;

	}


}
