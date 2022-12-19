package kr.or.ddit.nextpage.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NextPageLogOutController {

	@Inject
	private LogService logService;

	@Inject
	private SchoolService service;

	@PostMapping("/login/logout.do")
	public String logout(
			HttpSession session
			) {
		//로그아웃 로그체크 구지현
		String schId = (String) session.getAttribute("authSch");

		/**
		 * 작성자 : 최현우
		 * 넥스트페이지 메인에서 운영자로 로그인 했을 시에 운영자페이지로 이동하는 버튼이 따로 생긴다.
		 * 하지만 로그아웃을 하면 저 버튼도 없애줘야한다.
		 */
		log.debug( " ============= 로그아웃 버튼이 눌렸습니다. ============= " );
		session.removeAttribute( "auth" );
		if( session.getAttribute( "auth" ) == null ) {
			log.debug( "session.getAttribute(\"auth\") : null [삭제완료]" );
		}else {
			log.debug( "session.getAttribute(\"auth\") : null [삭제실패]" );
		}
		log.debug( "================================================" );
		// 최현우 작성 끝
		
		LogVO inputLog = new LogVO();
		inputLog.setLogHpnId(schId);
		inputLog.setLogTypeId(2);
		inputLog.setLogCntnt("로그아웃");

		if( schId != null ) {
			ServiceResult loginLog = logService.createLog(inputLog);			
			log.info("세션 {}, authSch {}, ",session,loginLog);
		}
		//session.setAttribute("log", log);
		//-----------로그 끝----------------------


		// 세션삭제
		session.removeAttribute("authSch");
		session.removeAttribute("nextAuth");

		log.info("세션 삭제?!!! {} ",session);
		String view="redirect:/nextpage/nextPageMain";

		return view;
	}
}
