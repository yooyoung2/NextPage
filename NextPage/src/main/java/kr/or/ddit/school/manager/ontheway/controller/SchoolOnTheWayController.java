package kr.or.ddit.school.manager.ontheway.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.ontheway.service.SchoolOnTheWayService;
import kr.or.ddit.vo.GenDrctnVO;
import kr.or.ddit.vo.LogVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/school/manager")
public class SchoolOnTheWayController {

	@Inject
	private SchoolOnTheWayService service;

	@Inject
	private LogService logService;

	@GetMapping("/on/the/way")
	public String mapView(Model model, HttpSession session) {
		String schId=(String) session.getAttribute("authSch");
		GenDrctnVO map = service.retrieveMap(schId);

		model.addAttribute("map",map);
		log.info("model에 담긴 값은? : {}",model );
		return "schoolManager/85_schoolOnTheWay/schoolOnTheWay";
	}


	//오시는길 등록
	@PostMapping(value="/on/the/way",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String schoolOnTheWay(GenDrctnVO map, HttpSession session) throws ServletException, IOException{

		log.info("오시는길 등록	하는길!!!");
		log.info("값을 가져가나여? :{} " + map);

		String logicalViewName = null;
		String schId=(String) session.getAttribute("authSch");

        //게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("오시는길등록");

        log.info("답변 등록 로그 : "+ inputLog);


		map.setSchId(schId);

		ServiceResult result = service.createMap(map);

		if(ServiceResult.OK.equals(result)) {
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);
			logicalViewName = "schoolManager/85_schoolOnTheWay/schoolOnTheWay";

		}else {
			String message = "등록 실패";
			log.info(message);
			logicalViewName = "schoolManager/85_schoolOnTheWay/schoolOnTheWay";
		}

		return "ok";

	}



	//오시는길 수정
	@PostMapping(value="/modiMap",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String modifyMap(@RequestBody GenDrctnVO modiMap, HttpSession session) {

		log.info("오시는길 수정 하는길!!! {}",modiMap);

		String logicalViewName = null;
		String schId=(String) session.getAttribute("authSch");


		//게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(4);
        inputLog.setLogCntnt("오시는길수정");

        log.info("답변 등록 로그 : "+ inputLog);
        modiMap.setSchId(schId);

		ServiceResult result = service.modifyMap(modiMap);

		log.info("result : {}",result);

		if(ServiceResult.OK.equals(result)) {
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);
			return "ok";

		}

		String message = "등록 실패";
		log.info(message);
		return "ng";

	}


}
