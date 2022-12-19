package kr.or.ddit.nextpage.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.NpMemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NextPageLoginController {

	@Inject
	private SchoolService service;

	@Inject
	private LogService loginService;

	//로그인 폼 불러오기
	@GetMapping("nextpage/user/login.do")
	public String nextPageLoginForm() {
		return "nextpage/nomenu/04_nextPageLogIn/nextPageLogIn";
	}

	@PostMapping("nextpage/user/loginProcess.do")
	public String doPost(
			NpMemberVO vo
			,int logTypeId, String logCntnt,

			HttpSession session,
			RedirectAttributes redirectAttributes
			) {
		String view ="";
		String message = "";

		String id = vo.getNpMemId();	// 입력받은 아이디를 담은 변수
		String pass = vo.getMemPw();	// 입력받은 비번을 담은 변수



		log.info("id : {}", id);

		if(org.apache.commons.lang3.StringUtils.isBlank(id)||org.apache.commons.lang3.StringUtils.isBlank(pass)) {
			message = "아이디나 비밀번호 누락";
			view="redirect:/nextpage/user/login.do";
		}else {

			log.info("로그인 시작");

			// ID비밀번호 입력받은거
			NpMemberVO inputData = new NpMemberVO();
			inputData.setNpMemId(id);
			inputData.setMemPw(pass);

			log.info("inputdata ID : {}", inputData.getNpMemId());


			//로그
			LogVO inputLog = new LogVO();
			inputLog.setLogHpnId(id);
			inputLog.setLogTypeId(logTypeId);
			inputLog.setLogCntnt(logCntnt);

			try {

				NpMemberVO authSch = service.authenticate(inputData);


				// 최현우 작성
				session.setAttribute( "auth" , authSch ); // 로그인한 회원객체 정보 저장
				log.debug( "================= NextPageLoginController =================" );
				
				if( session.getAttribute( "auth" ) != null ) {
					NpMemberVO mem = (NpMemberVO) session.getAttribute( "auth" );
					log.debug( "session.setAttribute(\"auth\") : 성공" );
					log.debug( "getMemAuth : " + mem.getMemAuth() );
				}else {
					log.debug( "session.setAttribute(\"auth\") : 실패" );
				}
				
				log.debug( "===========================================================" );
				// 최현우 작성 끝
				
				session.setAttribute("npMember", authSch);	// 로그인한 모든정보 객체로 세션에 저장. 저장명 : npMember
				
				
				session.setAttribute("authSch", authSch.getNpMemId());	// 로그인한 아이디 세션에 저장. 저장명 : authSch
				session.setAttribute("nextAuth", authSch.getMemAuth());	// 로그인한 아이디의 권한 저장. 저장명 : nextAuth

				message="로그인 성공";
				view="redirect:/nextpage/nextPageMain";

				ServiceResult loginLog = loginService.createLog(inputLog);

			} catch (UsernameNotFoundException | BadCredentialsException e) {
				if(e instanceof UsernameNotFoundException) {
					message = "해당정보가 없습니다.";
				}else {
					message = "비밀번호 오류";
				}
				view = "redirect:/nextpage/user/login.do";
			}
		}
		redirectAttributes.addFlashAttribute("message", message);

		return view;
	}

}
