package kr.or.ddit.school.manager.manage.index.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.nextpage.faq.service.NextPageFAQService;
import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.school.manager.service.SchoolServiceImpl;
import kr.or.ddit.vo.FaqVO;
import kr.or.ddit.vo.NoticeBoardVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("school/manager/school/manage")
public class SchoolManageIndexController {
	//FAQ조회
	@Inject
	private NextPageFAQService service;

	//공지사항 조회
	@Inject
	private NextPageMemberCenterService memberService;
	
	@Inject
	public SchoolServiceImpl schService;

	@RequestMapping("/index")
	public String schoolManageIndex(@RequestParam(name="page", required=true, defaultValue="1") int currentPage
			, Model model) {

		PagingVO<FaqVO> pagingVO = new PagingVO<>(5,5);
		pagingVO.setCurrentPage(currentPage);

		List<FaqVO> faqList = service.retrieveFaqList(pagingVO);
		pagingVO.setDataList(faqList);

		model.addAttribute("pagingVO",pagingVO);



		PagingVO<NoticeBoardVO> pagingVO2 = new PagingVO<>(5,5);
		pagingVO2.setCurrentPage(currentPage);

		List<NoticeBoardVO> notiBoardList = memberService.selectNotiBoardList(pagingVO2);
		pagingVO2.setDataList(notiBoardList);

		model.addAttribute("memberCenter",pagingVO2 );


		return "schoolManager/64_schoolManageIndex/schoolManageIndex";
	}
	
	
	@ResponseBody
	@RequestMapping("/authValidate")
	public String auth(
			HttpSession session
			){
		log.info("들어옴?");
		String result = null;
		String schId = (String) session.getAttribute("authSch");
		SchoolVO vo = schService.retrieveSchoolInfo(schId);
		
		String buyState = vo.getFstPchStat();
		log.info("buyState??? {} ",buyState);
		if(buyState.equals("YES")) {
			log.info("YES");
			result = "YES";
		}else {
			log.info("NO");
			result = "NO";
		} 
		return result;
	}
}

