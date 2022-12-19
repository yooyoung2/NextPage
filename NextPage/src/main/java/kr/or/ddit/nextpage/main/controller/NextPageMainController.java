package kr.or.ddit.nextpage.main.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.NpMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping( "nextpage/" )
@Controller
public class NextPageMainController {

	@RequestMapping( value = "nextPageMain", method = RequestMethod.GET )
	public String nextPageMain(
				Model mode,
				HttpSession session
			) {
		
		
		//c드라이브에 test2 폴더를 만들어준다.
		 File test2 = new File("c://test2");
		    if (test2.mkdir()){
		      System.out.println("디렉토리 생성 성공");
		    }else{
		      System.out.println("디렉토리 생성 실패");
		    }
		log.debug( "===================== NextPageMainController begins =====================" );
		
	
		// 로그인한 회원 객체 정보
		NpMemberVO authSch = (NpMemberVO) session.getAttribute( "auth" );
	
		if( authSch != null ) {
			/*
			 * -- 로그인 상태 --
			 * 
			 * authSch가 null이 아니라면 로그인이 된 상태
			 */
			String memAuth = authSch.getMemAuth(); 
			log.debug( "NextPageMainController - memAuth : " + memAuth );
			
		}else {
			/**
			 * -- 로그인 아닌 상태 --
			 */
			log.debug( "NpMemberVO authSch is NULL" );
		}
		
		log.debug( "========================================================================" );
		return "nextpage/nomenu/02_nextPageMain/nextPageMain";
	}
	
}
