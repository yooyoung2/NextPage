package kr.or.ddit.nextpage.buyticket.controller;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("nextpage/mypage/ticket")
public class NextPageBuyTicketController {

	@Inject
	private SchoolService service;

	//로그체크 구지현
	@Inject
		private LogService logService;

	@GetMapping("/buy")
	public String nextPageBuyTicket(
			HttpSession session
			, Model model
			, Model toDayPrice
			) {
		String schId = (String) session.getAttribute("authSch");
		int price = 0;

        LocalDate now = LocalDate.now();	// 가격계산하기 위해서

		SchoolVO schInfo = service.retrieveSchoolInfo(schId);





		int day = now.getDayOfMonth();
		log.info("day : "+day);

		if(day<=9) {
			price = service.beforeSaleDate();
		}else {
			price = service.afterSaleDate();
		}

		model.addAttribute("schInfo", schInfo);
		toDayPrice.addAttribute("price", price);

		return "nextpage/mypage/31_nextPageBuyTicket/nextPageBuyTicket";
	}

	@ResponseBody
	@PostMapping(value = "/buyTicket",produces = "text/plain;charset=utf-8")
	public String buyTicket(
			@RequestParam String schId
			,@RequestParam String payId
			) {
		log.info("schId 잘 와쪄용? : {}",schId);
		log.info("payId 잘 와쪄용? : {}",payId);
		ServiceResult result = null;
		String message = null;

		 //로그체크 구지현
		        LogVO inputLog = new LogVO();
		        inputLog.setLogHpnId(schId);
		        inputLog.setLogTypeId(6);
		        inputLog.setLogCntnt("결제");

		        log.info("결제 로그 : "+ inputLog);

		PayVO payvo = new PayVO();
		payvo.setSchId(schId);
		payvo.setPayId(payId);

		message = service.firstSale(payvo);

		if("결제 성공하였습니다. 지금부터 이용 가능합니다.".equals(message)) {
			ServiceResult loginLog = logService.createLog(inputLog);
		}

		return message;
	}

}
