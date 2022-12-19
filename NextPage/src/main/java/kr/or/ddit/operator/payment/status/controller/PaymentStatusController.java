package kr.or.ddit.operator.payment.status.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.operator.Index.dao.DealStatusDAO;
import kr.or.ddit.operator.payment.status.service.PaymentStatusService;
import kr.or.ddit.vo.DealStatusVO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class PaymentStatusController {
	
	@Inject
	DealStatusDAO dao;
	
	@Inject
	PaymentStatusService service;
	
	
	@RequestMapping( "operator/paymentStatus" )
	public String paymentStatus( 
				Model model,
				@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
				@ModelAttribute("simpleCondition") SearchVO simpleCondition
			) {
		
		PagingVO<LogVO>pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);
		
		//전체로그리스트
		List<LogVO> logList = service.selectAllLog(pagingVO);
		pagingVO.setDataList(logList);
		model.addAttribute("pagingVO",pagingVO );

		
		
		List<DealStatusVO> dealList = dao.selectAllDeal();
		if( dealList != null && !dealList.isEmpty() ) {
			model.addAttribute( "dealList", dealList );
		}
		
		return "operator/10-12_paymentStatus/paymentStatus";
		
	}

}
