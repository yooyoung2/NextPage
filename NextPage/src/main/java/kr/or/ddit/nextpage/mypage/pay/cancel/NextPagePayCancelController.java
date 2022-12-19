package kr.or.ddit.nextpage.mypage.pay.cancel;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("nextpage/mypage/payCancel")
public class NextPagePayCancelController {

	@Inject
	private SchoolService service;

	//로그체크 구지현
	@Inject
		private LogService logService;


	@GetMapping
	public String nextPageCancel(
			HttpSession session
			, Model model
			) {
		String schId = (String) session.getAttribute("authSch");
		SchoolVO schInfo = service.retrieveSchoolInfo(schId);
		model.addAttribute("schInfo", schInfo);

		return "nextpage/mypage/32_nextPagePayCancel/nextPagePayCancel";
	}

	@ResponseBody
	@PostMapping(produces = "text/plain;charset=utf-8")
	public String cancel(
			@RequestParam String schId
			) {

		log.info("schId : {}", schId);
		ServiceResult result = null;
		String message =null;


		 //로그체크 구지현
		        LogVO inputLog = new LogVO();
		        inputLog.setLogHpnId(schId);
		        inputLog.setLogTypeId(7);
		        inputLog.setLogCntnt("결제취소");

		        log.info("답변 등록 로그 : "+ inputLog);
		result = service.cancelPay(schId);
		switch (result) {
		case OK:
			log.info("되나요~!");
			ServiceResult loginLog = logService.createLog(inputLog);
			message = "이용권이 취소되었습니다.";
			break;

		default:
			log.info("안되나요~!");
			message = "이용권 취소 실패";
			break;
		}
		return message;
	}

}
