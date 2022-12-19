package kr.or.ddit.nextpage.member.center.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.NoticeBoardVO;
import lombok.extern.slf4j.Slf4j;
/**
 *공지사항등록
 */
@Slf4j
@Controller
@RequestMapping("nextpage/PostingInsert.do")
public class NotiBoardFormController {

	@Inject
	private NextPageMemberCenterService service;

	@Inject
	private LogService logService;


	@ModelAttribute("notiBoard")
	public NoticeBoardVO notiBoard() {
		return new NoticeBoardVO();
	}

	@GetMapping
	public String notiBoardForm() {
		return "nextpage/customerService/22_nextPageMemberCenter/PostingInsert";
	}

	@PostMapping
	public String notiBoardInsert(
		NoticeBoardVO notiBoard

		, Errors errors
		, Model model
		, HttpSession session
		,String notisTitle
		,String notisCntnt
		,MultipartFile boFiles
	) {
		System.out.println(boFiles+"보파일");
		System.out.println("notiBoard : " + notiBoard);

		String adminId = ( String )session.getAttribute( "authSch" );


        //게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(adminId);
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("공지사항등록");

		String viewName = null;

		if(!errors.hasErrors()) {

			notiBoard = new NoticeBoardVO();
			notiBoard.setNotisTitle(notisTitle);
			notiBoard.setNotisCntnt(notisCntnt);
			notiBoard.setAdminId(adminId);
			notiBoard.setBoFiles(boFiles);
			System.out.println(notiBoard+"읊어봐");

			System.out.println("아이디 : "+notiBoard.getAdminId());
			log.info("Post 메소드 핸들러 boardInsert 실행");

			ServiceResult result = service.insertNotiBoard(notiBoard); // DB에 넣는 부분

			if(ServiceResult.OK.equals(result)) {
				model.addAttribute("result",result);
				ServiceResult loginLog = logService.createLog(inputLog);
				viewName = "redirect:/nextpage/service/memcenter.do";

			}else {
				String message = "등록 실패";
				log.info(message);
				model.addAttribute("message", message);
				viewName = "nextpage/customerService/22_nextPageMemberCenter/PostingInsert";
			}
		}else {
			String message = "등록 실패2";
			log.info(message);
			System.out.println(errors);
			viewName = "nextpage/customerService/22_nextPageMemberCenter/PostingInsert";
		}

		return viewName;
	}
}