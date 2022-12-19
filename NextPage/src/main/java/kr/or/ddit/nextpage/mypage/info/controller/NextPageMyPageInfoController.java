package kr.or.ddit.nextpage.mypage.info.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;


/**
 * 마이페이지 가는길
 *
 */
@Controller
@Slf4j
public class NextPageMyPageInfoController {

	@Inject
	private SchoolService service;
	
	@RequestMapping( value = "nextpage/mypage/info", method = RequestMethod.GET )
	public String nextPageMyInfo(
			HttpSession session
			, String sessionId
			, SchoolVO schoolvo
			, Model model
			) {
		sessionId = (String) session.getAttribute("authSch"); 
		schoolvo = service.retrieveSchoolInfo(sessionId);
		model.addAttribute("schvo", schoolvo);
		log.info("model : {}",schoolvo);
		return "nextpage/mypage/24_nextPageMyPageInfo/nextPageMyPageInfo";
	}
	
}
