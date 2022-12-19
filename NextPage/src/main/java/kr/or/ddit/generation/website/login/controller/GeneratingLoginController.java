package kr.or.ddit.generation.website.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.generation.school.schoolMember.service.SchoolMemberService;
import kr.or.ddit.school.manager.history.service.GenLogService;
import kr.or.ddit.vo.GenRCRDVO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping( "generation/{id}")
public class GeneratingLoginController {

	//templateId
	String templateId = "";

	@Inject
	private SchoolMemberService service;

	//로그
	@Inject
	private GenLogService logService;

	//푸터적용
	@Inject
	private FooterService footerService;


	@GetMapping( "login" )
	public String generatingLoginForm(
			HttpSession session,@PathVariable("id") String id, Model model
			) {

		log.debug( "=================== GeneratingLoginController 시작(GET) ===================" );


	//======================footer 시작==================================
			SchoolVO footer = footerService.selectGenFooter(id);
			model.addAttribute("footer",footer);

	//======================footer 끝==================================

		templateId = (String) session.getAttribute( "templateId" );
		/*String viewName = (String) session.getAttribute( "rtrnJsp" ); // return jsp경로*/

		String viewName = "";


		if( templateId != null ) {
			if( templateId.equals( "TMPLT001" ) ) {
				templateId = "template01";
				viewName = "generation/"+ templateId + "/nomenu/36_generatingLogin/generatingLogin";
			}else if( templateId.equals( "TMPLT002" ) ) {
				templateId = "template02";
				viewName = "generation/"+ templateId + "/nomenu/36_generatingLogin/generatingLogin2";
			}else if( templateId.equals( "TMPLT003" ) ) {
				templateId = "template03";
				viewName = "generation/"+ templateId + "/nomenu/36_generatingLogin/generatingLogin";
			}
		}else {
			log.debug( "templateId is NULL" );
		}

		log.debug( "templateId : {}", templateId );
		log.debug( "viewName : {}", viewName );
		log.debug( "=================== GeneratingLoginController 끝 ===================" );

		return viewName;
	}

	@PostMapping( "login" ) // generation/template02/b001/login
	public String generatingLogin(
			SchMemberVO inputData
			, GenRCRDVO genLog
			, HttpSession session
			, RedirectAttributes redirectAttributes
			) {

		log.debug( "=================== GeneratingLoginController 시작(POST) ===================" );

		templateId = (String) session.getAttribute( "templateId" );

		log.info( "generating Login 진입" );

		String view = "";
		String message = "";

		String id = inputData.getMemId();
		log.info( "id : " + id );


		String pw = inputData.getMemPw();
		log.info( "pw : " + pw );

		String schId = (String) session.getAttribute("id");
		log.info( "schId : " + schId );

		//로그
		genLog = new GenRCRDVO();
		genLog.setRecrdType("1");
		genLog.setRecrdCndtn("로그인");
		genLog.setCndtnMdfr(id);
		genLog.setManuNm("로그인");

		if(org.apache.commons.lang3.StringUtils.isBlank(id)||org.apache.commons.lang3.StringUtils.isBlank(pw)) {
			log.info( "if로 들어옴" );
			message = "아이디나 비밀번호 누락";
			view="redirect:/generation/" + schId + "/login";
		}else {
			log.info( "else로 들어옴" );
			try {
				// 학교 아이디 넣기

				inputData.setSchId(schId);
				log.info( "inputData 세팅 완료 : " + inputData );


				// authenticate에서 where 조건으로 유저 아이디, 학교아이디 필요하므로 위에서 학교 아이디 셋팅한거
				SchMemberVO authMem = service.authenticate(inputData);
				log.info( "authMen : " + authMem);


				// 학생, 선생님, 학부모인지 알아보고 세션에 저장.
				service.checkAuth(authMem);
				log.info("권한? : {}", authMem.getAuthMem());

				// 로그인한 아이디 세션에 저장. 저장명 : authSch
				session.setAttribute("authMem", authMem.getMemId());

				System.out.println(authMem.getMemId()+"임돵");

				// 로그인한 아이디의 권한 저장. 저장명 : authVal
				session.setAttribute("authVal", authMem.getAuthMem());

				message="로그인 성공";
				log.debug( "로그인 성공" );
				view= "redirect:/generation/" + schId + "/main";

				ServiceResult loginLog = logService.createLog(genLog);
				log.info("로그인로그 등록 : "+loginLog);
				log.info("해당 아이디 권한은 ? : {}",session.getAttribute("authVal"));

				log.info("**************************로그인 성공!!!!!!!!!");

			} catch (UsernameNotFoundException | BadCredentialsException e) {
				if(e instanceof UsernameNotFoundException) {
					message = "해당정보가 없습니다.";
				}else {
					message = "비밀번호 오류";
				}
				log.debug( "로그인 실패" );
				view = "redirect:/generation/" + schId + "/login";
			}
		}

		redirectAttributes.addFlashAttribute("message", message);
		log.debug( "=================== GeneratingLoginController 끝 ===================" );

		return view;
	}
}
