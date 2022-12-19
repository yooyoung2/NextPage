package kr.or.ddit.school.manager.menu.hello.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.menu.hello.service.MenuHelloService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchGretngVO;
import kr.or.ddit.vo.StudAndPrntVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("school/manager")
public class MenuHelloController {

	@Inject
	private MenuHelloService service;

	@Inject
	private LogService logService;


	@GetMapping("/menu/hello")
	public String doget(Model model, HttpSession session) {

		String schId = (String)session.getAttribute("authSch");

		SchGretngVO hello = service.selectHello(schId);

		model.addAttribute("hello",hello);

		return "schoolManager/80_menuHello/menuHello";
	}

	/*@PostMapping(value="/menu/hello", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)*/
	/*@ResponseBody*/
	@PostMapping("/menu/hello")
	public String doPost(
			/*@RequestBody SchGretngVO schVO*/
			@RequestParam String cntnt
			, @RequestParam(required=true,defaultValue="1") String fileName
			, HttpSession session) {
		String schId=(String) session.getAttribute("authSch");

		
		SchGretngVO schVO = new SchGretngVO();
		
		schVO.setCntnt(cntnt);
		schVO.setFileName(fileName);
		schVO.setSchId(schId);
		
		log.info("올라온데이터 : {} ", schVO);
		
		 //게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("학교장인사말등록");

        schVO.setSchId(schId);

        
        
        ServiceResult result = service.createHello(schVO);

        if(result.OK.equals(result)) {
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);

		}else {
			String message = "등록 실패";
			log.info(message);
		}

		return "schoolManager/80_menuHello/menuHello";

	}

	/*@PostMapping(value="/hello/modify", produces="application/json; charset=utf-8")*/
	@PostMapping("/hello/modify")
	public String modifyHello(
			@RequestParam String cntnt
			, @RequestParam String fileName
			, HttpSession session
			/*, @RequestBody SchGretngVO data*/) {

		SchGretngVO data = new SchGretngVO();
		data.setFileName(fileName);
		data.setCntnt(cntnt);
		
		String schId=(String) session.getAttribute("authSch");
		data.setSchId(schId);

		ServiceResult result = service.modifyHello(data);
		log.info("data : {}",data);



		//게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(4);
        inputLog.setLogCntnt("학교장인사말수정");

        if(result.OK.equals(result)) {
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);

			return "schoolManager/80_menuHello/menuHello";
		}else {
			String message = "등록 실패";
			log.info(message);

			return "ng";
		}


	}

}
