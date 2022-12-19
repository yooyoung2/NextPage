package kr.or.ddit.nextpage.member.center.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.NoticeBoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("nextpage/PostingUpdate.do")
public class NotiBoardUpdateController {

	@Inject
	private NextPageMemberCenterService service;

	@Inject
	private LogService logService;

	@ModelAttribute("command")
	public String command() {
		return "UPDATE";

	}

	@GetMapping
	public String notiBoardView(@RequestParam(name = "who") int notisNum, Model model) {
		NoticeBoardVO noti = service.retrieveNotiboard(notisNum);
		model.addAttribute("noti", noti);
		return "nextpage/PostingView.do";
	}




	@PostMapping
	public String doPost(
		@ModelAttribute("noti") NoticeBoardVO noti
		, BindingResult errors
		, Model model
		,HttpSession session
		,MultipartFile boFiles
	) {
		System.out.println(boFiles+"보파일");
		noti.setBoFiles(boFiles);
		log.info("jsp에서 올라온 {} ", noti);

		String adminId = (String) session.getAttribute("authSch");

        //수정 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(adminId);
        inputLog.setLogTypeId(4);
        inputLog.setLogCntnt("공지사항수정");
        

		String logicalViewName = null;
		if(!errors.hasErrors()) {
			
			ServiceResult result = service.modifyNotiBoard(noti);
			switch (result) {
			case OK:
				ServiceResult loginLog = logService.createLog(inputLog);
				logicalViewName = "redirect:/nextpage/service/memcenter.do";
				break;

			default:
				model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
				logicalViewName = "nextpage/PostingView.do";
				break;
			}
		}else {
			logicalViewName = "nextpage/PostingView.do";
		}
		return logicalViewName;
	}

}
