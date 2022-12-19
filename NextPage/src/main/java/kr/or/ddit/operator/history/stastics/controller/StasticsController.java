package kr.or.ddit.operator.history.stastics.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.operator.history.stastics.dao.StasticsDAO;
import kr.or.ddit.vo.VisitCountVO;
import lombok.extern.slf4j.Slf4j;

/*
 * 통계분석 컨트롤러
 * 
 * 
 */

@Slf4j
@Controller
public class StasticsController {

	@Inject
	StasticsDAO dao;
	
	@RequestMapping( "operator/postHistoryLog" )
	public String postHistoryLog() {
		return "operator/15_postHistory_log/postHistoryLog";
		
	}
	
	@RequestMapping( "operator/visitor/amount" )
	public ModelAndView printVisitorsAmount( HttpServletRequest request ) {
		
		ModelAndView mva = new ModelAndView();
		
		return mva;
	}
	
	
	// 유입시간대 방문 ( 하루 24시간 : 00시, 01시, 02시 ... )
	public void inflowVisitTime() {
		
	}
	
	
	
	
	
	
	
	
	
}
