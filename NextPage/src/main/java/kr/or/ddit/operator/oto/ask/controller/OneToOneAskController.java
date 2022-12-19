package kr.or.ddit.operator.oto.ask.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.my.question.cmmt.service.CmntService;
import kr.or.ddit.school.manager.my.question.list.service.MyQuestionService;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.OtoCmntVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping( "operator" )
public class OneToOneAskController {
	@Inject
	private MyQuestionService service;

	@Inject
	private CmntService cmntService;

	@ModelAttribute("oto")
	public MyQuestionVO oto() {
		return new MyQuestionVO();
	}


	@RequestMapping( value="/onetoOneAsk" )
	public String onetoOneAsk(
			@RequestParam(name="page", required=true, defaultValue="1") int currentPage
			, Model model
			) {

				PagingVO<MyQuestionVO> pagingVO = new PagingVO<>();
				pagingVO.setCurrentPage(currentPage);

				List<MyQuestionVO> otoList = service.selectOtoList(pagingVO);
				pagingVO.setDataList(otoList);

				model.addAttribute("pagingVO",pagingVO);

		return "operator/17_onetoOneAsk/onetoOneAsk";

	}

	//상세페이지조회
	@GetMapping( value="/onetoOneAskDetail" )
	public String onetoOneAskDetail(
		@RequestParam(name="oto" , required=true) int otoBrdNum
		,Model model
	) {

		MyQuestionVO myQuestion = service.selectMyQuestionDetail(otoBrdNum);


		log.info("myQuestion이 넘어가는지???"+myQuestion);

		model.addAttribute("oto",myQuestion);

		String prgrsCndtn = myQuestion.getPrgrsCndtn();

		//답변상세조회
		List<OtoCmntVO> cmnt = cmntService.retrieveCmntList(otoBrdNum);
		model.addAttribute("cmnt",cmnt);

		//진행상태변경
		if("대기".equals(prgrsCndtn)) {
			myQuestion.setPrgrsCndtn("진행");
			ServiceResult result = service.updateStatus(myQuestion);
			return "operator/18_detailOnetoOneAsk/detailOnetoOneAsk";
		}

		return "operator/18_detailOnetoOneAsk/detailOnetoOneAsk";
	}

//완료로 진행상태변경
	@GetMapping("clear")
	public String changeStatus(
		@ModelAttribute("oto") MyQuestionVO myQuestion
	) {
		Integer otoBrdNum = myQuestion.getOtoBrdNum();
		String prgrsCndtn = myQuestion.getPrgrsCndtn();

		log.info("진행상황을 보고해주세요!!!!!!!!"+prgrsCndtn);
		//진행상태변경
		if("진행".equals(prgrsCndtn)) {
			myQuestion.setPrgrsCndtn("완료");
			}else if("완료".equals(prgrsCndtn)) {
				myQuestion.setPrgrsCndtn("진행");
			};
		ServiceResult result = service.updateStatus(myQuestion);

		return "redirect:/operator/onetoOneAskDetail?oto=" + otoBrdNum;
	}


}
