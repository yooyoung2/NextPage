package kr.or.ddit.nextpage.oto;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.my.question.cmmt.service.CmntService;
import kr.or.ddit.school.manager.my.question.list.service.MyQuestionService;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.OtoCmntVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class otoDetailController {

	@Inject
	private MyQuestionService service;

	// 답변댓글 조회
	@Inject
	private CmntService cmntService;
	
	
	@RequestMapping(value =  "nextpage/myOtoDetail" , method = RequestMethod.GET)
	public String otoDetail(
			@RequestParam(name = "what", required = true) int otoBrdNum,
			Model model
			) {
		MyQuestionVO myQuestion = service.selectMyQuestionDetail(otoBrdNum);
		myQuestion.setOtoBrdNum(otoBrdNum);
		model.addAttribute("myQuestion", myQuestion);

		// 답변상세조회
		List<OtoCmntVO> cmnt = cmntService.retrieveCmntList(otoBrdNum);
		model.addAttribute("cmnt", cmnt);
		return "nextpage/mypage/34_nextPageOTO/nextPageOTODetail";
	}
}
