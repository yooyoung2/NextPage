package kr.or.ddit.operator.detail.payment.status.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.operator.Index.dao.DealStatusDAO;
import kr.or.ddit.vo.DealStatusVO;

@Controller
public class DetailPaymentStatusController {
	
	
	
	@RequestMapping( "operator/detailPaymentStatus" )
	public String detailPaymentStatus( Model model ) {
		
		
		
		return "operator/13_detailPaymentStatus/detailPaymentStatus";
		
	}

}
