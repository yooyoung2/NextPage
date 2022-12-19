package kr.or.ddit.generation.website.mypage.insertChild;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.school.schoolMember.service.SchoolMemberService;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.StudAndPrntVO;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * 학부모 권한 신청
 * (학생 등록)
 */
@Slf4j
@Controller
@RequestMapping("generation/{id}/generatingMyPage/enrollPrnt")
public class GetPrntAuthController {
	
	@Inject
	private SchoolMemberService service;
	
	@GetMapping
	public String insertForm(
			@PathVariable("id") String schId
			, HttpSession session
			, Model model
			) {
		return "generation/template01/mypage/45_generatingMyPage/enrollPrntAuth";
	}

	
	
	
	
	@PostMapping (value="/insert",consumes=MediaType.APPLICATION_JSON_VALUE, produces="text/plain;charset=utf-8")
	@ResponseBody
	public String insert(
			@RequestBody List<SchMemberVO> dataList
			, HttpSession session
			, Model model
			) {
		log.debug("inputList : {}",dataList);
		
		ServiceResult result = null;
		String view = null;
		String message = null;
		
		// 학생 아이디와 학부모의 아이디를 담는 vo
		StudAndPrntVO sapvo = new StudAndPrntVO();
		// 입력한 학생의 정보가 있는지 확인할 용도의 vo
		SchMemberVO memvo = new SchMemberVO();
		
		// 해당학교 아이디
		String schId = (String) session.getAttribute("id");
		// 신청한 유저의 아이디
		String memId = (String) session.getAttribute("authMem");
		

		
		// 에이젝스로 받은 dataList
		for(int i=0; i<dataList.size(); i++) {
			// dataList에 있는 학생 이름,학번 셋팅
			memvo = dataList.get(i);
			// 학생있는지 없는지 확인용 값 셋팅
			memvo.setSchId(schId);
			// 학부모 아이디도 셋팅하기
			memvo.setMemId(memId);
			log.info("dataList : {} ",dataList.get(i));
			// 위에서 셋팅한 학생 정보로 찾아보기. 있으면 1이상 없으면 0
			int row = service.checkStudent(memvo);
			if(row > 0) {	// 학생 정보가 있다면
				log.info("학생정보가 있음, 학부모 신청 진행");
				result = service.enrollParents(memvo);	// 신청하면 일단 학부모 no로 인서트 하기
				switch (result) {
				case OK:
					log.info("신청 됨");
					model.addAttribute("sapvo", sapvo);
					message = "신청되었습니다. 신청현황에서 승인확인을 할 수 있습니다.";
					break;
				default:
					log.info("이미 신청한듯?");
					message = "이미 신청하셨습니다. 승인까지 기다려 주십시요";
					break;
				}
			}else {
				message="학생정보가 없습니다.";
			}
		}
		return message;
	}
}
