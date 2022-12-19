package kr.or.ddit.generation.website.mypage.myParentsList;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.generation.school.schoolMember.service.SchoolMemberService;
import kr.or.ddit.generation.website.mypage.approvalList.approvalListController;
import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("generation/{id}/generatingMyPage/parentsList")
public class myParentsListController {

	@Inject
	private SchoolMemberService service;

	@GetMapping
	public String parentsList(
			@PathVariable("id") String schId
			, HttpSession session
			, Model model
			) {
		String memId = (String) session.getAttribute("authMem");

		SchMemberVO vo = new SchMemberVO();
		vo.setMemId(memId);
		vo.setSchId(schId);

		List<SchMemberVO> parentsList = service.selectMyPrnt(vo);

		log.info("parentsList : {}", parentsList);
		model.addAttribute("parentsList", parentsList);

		return "generation/template01/mypage/45_generatingMyPage/myParentsList";
	}
	
}
