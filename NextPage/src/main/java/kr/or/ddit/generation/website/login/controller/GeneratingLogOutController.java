package kr.or.ddit.generation.website.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.history.service.GenLogService;
import kr.or.ddit.vo.GenRCRDVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping( "generation/{id}")
public class GeneratingLogOutController {

	//로그
	@Inject
	private GenLogService logService;

	@PostMapping ("logout") // generation/template01/{id}/logout
	public String logout(
			HttpSession session
			, @PathVariable("id") String id
			, GenRCRDVO genLog
			) {

		String memId = (String) session.getAttribute("authMem");
		log.info( "memId : " + memId );

		//로그
			genLog = new GenRCRDVO();
			genLog.setRecrdType("2");
			genLog.setRecrdCndtn("로그아웃");
			genLog.setCndtnMdfr(memId);
			genLog.setManuNm("로그아웃");
			
			if( memId != null ) {
				ServiceResult loginLog = logService.createLog(genLog);				
				log.info("로그아웃로그 등록 : "+loginLog);
			}
		
		// 세션에 저장된 아이디만 삭제
		session.removeAttribute("authMem");
		
		// 로그아웃하면서 NORMAL로 권한 재설정
		session.setAttribute("authVal", "NONE");
		log.info("당신은 로그아웃 되었다!!");
		String view = "redirect:/generation/"+id+"/main";
		return view;
	}
}