package kr.or.ddit.generation.website.join;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.generation.school.schoolMember.service.SchoolMemberService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping( "generation/" )
public class generatingJoinController {

	//templateId
	String templateId = "";

	@Inject
	private SchoolMemberService service;

	//푸터적용
	@Inject
	private FooterService footerService;

	@GetMapping( "{id}/join" )
	public String generatingJoinForm(
			@PathVariable("id") String id,
			HttpSession session,
			Model model
			) {

		templateId = (String) session.getAttribute( "templateId" );

		//======================footer 시작==================================
				SchoolVO footer = footerService.selectGenFooter(id);
				model.addAttribute("footer",footer);

		//======================footer 끝==================================



		String viewName = "";

		if( templateId != null ) {
			if( templateId.equals( "TMPLT001" ) ) {
				templateId = "template01";
			}else if( templateId.equals( "TMPLT002" ) ) {
				templateId = "template02";
			}else if( templateId.equals( "TMPLT003" ) ) {
				templateId = "template03";
			}
			viewName = "generation/" + templateId + "/nomenu/37_generatingJoin/generatingJoin";
		}else {
			log.debug( "templateId is NULL" );
		}

		log.info("회원가입 폼 입성 두둥");
		return viewName;

	}

	@PostMapping( "{id}/join" )
	public String generatingJoin(
			HttpSession session
			, @Validated(InsertGroup.class) SchMemberVO inputData
			, Errors errors
			, Model model
			, @PathVariable("id") String id
			) {

		log.info("회원가입 버튼 따당쓰");
		String view = null;
		String schId = (String) session.getAttribute("id");

		// 이메일 아이디랑 주소 따로따로 가져온거 합쳐서 memEmail에 넣음
		String memEmailId = inputData.getMemEmailId();
		String memEmailAddr = inputData.getMemEmailAddr();
		String memEmail = memEmailId+"@"+memEmailAddr;
		inputData.setMemEmail(memEmail);

		if(!errors.hasErrors()) {
			log.info("에러 없을 무");
			ServiceResult result = null;


			// 세션에서 꺼내온 학교 아이디 세팅해줌
			inputData.setSchId(schId);
			log.info("학교 아이디이ㅣㅣ{}",schId);
			// 학교아이디를 포함해서 createMember하기
			result = service.createMember(inputData);

			log.info("create result????????? : {}", result);

			switch(result) {
			case PKDUPLICATED:
				log.info("아이디 중복쓰~!");
				model.addAttribute("message", "아이디 중복");
				view = "redirect:/generation/"+schId+"/join";
				break;
			case OK:
				log.info("{}쓰 회원가입!!!!!",inputData.getMemId());
				log.info("OK");
				model.addAttribute("message", "환영합니다");
				view = "redirect:/generation/"+schId+"/main";
					break;
			default:
				log.info("서버오륭");
				model.addAttribute("message", "서버오류. 다시 시도해주세요.");
				view = "redirect:/generation/"+schId+"/join";
				break;
			}
		}else {
			log.info("에러가 있다");
			log.info("에러??{}",errors);
			view = "redirect:/generation/"+schId+"/join";
		}
		return view;
	}


	// 아이디 중복체크!!!!!
	@PostMapping("{id}/idCheck")
	@ResponseBody
	public int idDupleCheck(
		HttpSession session
		, @RequestParam("memId") String memId
			) {
		log.info("중복체크 제이슨 들어오십니까?");
		SchMemberVO vo = new SchMemberVO();

		String schId = (String) session.getAttribute("id");

		vo.setMemId(memId);
		vo.setSchId(schId);

		int row = service.checkMem(vo);
		log.info("row:????{}",row);
		return row;
	}
}
