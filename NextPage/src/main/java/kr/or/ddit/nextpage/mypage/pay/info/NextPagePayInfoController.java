package kr.or.ddit.nextpage.mypage.pay.info;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PayVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NextPagePayInfoController {

	@Inject
	private SchoolService service;
	
	@RequestMapping( value = "nextpage/payment/info", method = RequestMethod.GET )
	public String nextPageInfo(
			HttpSession session
			, @RequestParam(name="page", required=true, defaultValue="1") int currentPage
			, Model model 
			) {
		
		// 페이징처리 vo
		PagingVO<PayVO> pagingVO = new PagingVO<>(5,3);
		pagingVO.setCurrentPage(currentPage);
		
		// 세션아이디 vo에 저장
		String schId = (String) session.getAttribute("authSch");
		pagingVO.setSchId(schId);
		
		// 결제 리스트 불러오기. 서비스에서 set함
		service.retrievePayList(pagingVO);
		model.addAttribute("pagingVO", pagingVO);

		return "nextpage/mypage/30_nextPagePayInfo/nextPagePayInfo";
	}
	
}
