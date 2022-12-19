/*package kr.or.ddit.school.manager.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.SchoolVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequiredArgsConstructor // final 필드의 초기값을 지정
@Controller
public class SchoolController {

	@Inject
	private SchoolService service;

	@Inject
	private WebApplicationContext context;

	@ModelAttribute( "school" )
	public SchoolVO school() {
		log.info( "@ModelAttribute 메소드 실행" );
		return new SchoolVO();
	}

	@RequestMapping( value = "school/member/signup.do", method = RequestMethod.POST )
	public String createSchool(
			@Validated() @ModelAttribute( "school" ) SchoolVO school,
			Errors errors,
			Model model
			) {
		log.info( "SchoolController : createSchool 실행" );
		String viewName = null;
		if( !errors.hasErrors() ) {
			ServiceResult result = service.createSchool(school);
			if( ServiceResult.OK.equals( result ) ) {
				log.info( "가입성공" );
				viewName = "nextpage/02_nextPageMain/nextPageMain"; // 메인페이지 이동
			}else {
				log.info( "가입실패" );
				viewName = "nextpage/02_nextPageMain/nextPageMain";
			}
		}else {
			log.info( "치명적 오류 발생" );
			viewName = "nextpage/02_nextPageMain/nextPageMain";
		}

		return viewName;
	}


}
*/