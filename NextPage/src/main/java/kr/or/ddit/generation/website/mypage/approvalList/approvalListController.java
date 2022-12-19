package kr.or.ddit.generation.website.mypage.approvalList;

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
import kr.or.ddit.generation.website.mypage.myChildList.myChildListController;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.StudAndPrntVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("generation/{id}/generatingMyPage/approvalList")
public class approvalListController {

	@Inject
	private SchoolMemberService service;

	@GetMapping
	public String approvalList(@PathVariable("id") String schId, HttpSession session, Model model) {
		String memId = (String) session.getAttribute("authMem");

		SchMemberVO vo = new SchMemberVO();
		vo.setMemId(memId);
		vo.setSchId(schId);

		List<SchMemberVO> approvalList = service.selectAuthApproval(vo);

		log.info("approvalList : {}", approvalList);
		model.addAttribute("approvalList", approvalList);

		return "generation/template01/mypage/45_generatingMyPage/approvalList";
	}
	
	@PostMapping (consumes=MediaType.APPLICATION_JSON_VALUE, produces="application/json;charset=utf-8")
	@ResponseBody
	public String approval(
			@RequestBody StudAndPrntVO data
			, HttpSession session
			, Model model
			) {
		log.info("data : {}",data);

		ServiceResult result = null;
		String message = null;
		
		result = service.approvalAuth(data);
		log.info("result? : {}",result);
		
		switch (result) {
		case OK:
			log.info("승인");
			message = "승인되었습니다."; 
			break;
		default:
			log.info("실패");
			message = "승인실패";
			break;
		}
		return message;
	}
	
	
	
	
	@PostMapping (value = "/delete", consumes=MediaType.APPLICATION_JSON_VALUE, produces="application/json;charset=utf-8")
	@ResponseBody
	public String approvalDelete(
			@RequestBody StudAndPrntVO data
			, HttpSession session
			, Model model
			) {
		log.info("data : {}",data);

		ServiceResult result = null;
		String message = null;
		
		result = service.returnEnroll(data);
		log.info("result? : {}",result);
		
		switch (result) {
		case OK:
			log.info("반려");
			message = "신청이 반려되었습니다."; 
			break;
		default:
			log.info("실패");
			message = "반려실패";
			break;
		}
		return message;
	}
}
