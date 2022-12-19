package kr.or.ddit.operator.history.stastics.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.operator.Index.dao.VisitCountDAO;
import kr.or.ddit.operator.history.stastics.dao.TemplateDAO;
import kr.or.ddit.vo.TemplateStasticsVO;
import kr.or.ddit.vo.VisitCountVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/통계분석/방문현황
 * @author PC-04
 *
 */

@Slf4j
@Controller
public class VisitStatusController {

	@Inject
	VisitCountDAO dao; 
	
	@Inject
	TemplateDAO tdao;
	
	@RequestMapping( value = "operator/visit/status", method = RequestMethod.GET )
	public String visitStatus( Model model ) {
		
		log.debug( "=============== VisitStatusController - visitStatus() [ACTIVATED] ===============" );
		
		String viewName = "operator/06_selectVisitorAmount/selectVisitorAmount";
		
		List<TemplateStasticsVO> templateSell = tdao.templateSell();
		List<TemplateStasticsVO> templateUse = tdao.templateUse();
		
		if( templateSell != null && !templateSell.isEmpty() ) {
			log.debug( "============= templateSell =============" );
			for( TemplateStasticsVO vo : templateSell ) {
				log.debug( "==========================================" );
				log.debug( "TEMPLATE NAME : {}", vo.getTemplateNm() );
				log.debug( "TEMPLATE AMOUNT : {}", vo.getAmount() );
				log.debug( "==========================================" );
			}
			
			model.addAttribute( "templateSell", templateSell );
			
			log.debug( "=========================================" );
		}else {
			log.debug( "List<TemplateStasticsVO> templateSell = NULL" );
		}
		
		
		if( templateUse != null && !templateUse.isEmpty() ) {
			log.debug( "============= templateUse =============" );
			for( TemplateStasticsVO vo : templateUse ) {
				log.debug( "==========================================" );
				log.debug( "TEMPLATE NAME : {}", vo.getTemplateNm() );
				log.debug( "TEMPLATE AMOUNT : {}", vo.getAmount() );
				log.debug( "==========================================" );
			}
			
			model.addAttribute( "templateUse", templateUse );
			
		}else {
			log.debug( "List<TemplateStasticsVO> templateUse = NULL" );
		}
		
		
		
		List<VisitCountVO> monthly = dao.selectMonthlyVisitor(); // 월간
		List<VisitCountVO> weekly = dao.selectWeeklyVisitor();// 주간
		List<VisitCountVO> daily = dao.selectDailyVisitor(); // 일간
		
		log.debug( "[ VisitStatusController ] :  Controller activated " );
		
		// daily
		log.debug( "================== DAILY VISITORS ==================" );
		for( VisitCountVO data : daily ) {
			log.debug( "DATE : " + data.getDay() + " | VISITORS : " + data.getVisitorAmount() );
		}
		log.debug( "====================================================" );
		
		// weekly
		log.debug( "================== WEEKLY VISITORS ==================" );
		for( VisitCountVO data : weekly ) {
			log.debug( "DATE : " + data.getDay() + " | VISITORS : " + data.getVisitorAmount() );
		}
		log.debug( "====================================================" );
		
		// monthly
		log.debug( "================== MONTHLY VISITORS ==================" );
		for( VisitCountVO data : monthly ) {
			log.debug( "DATE : " + data.getDay() + " | VISITORS : " + data.getVisitorAmount() );
		}
		log.debug( "====================================================" );
	
		
		model.addAttribute( "monthly", monthly );
		model.addAttribute( "weekly", weekly );
		model.addAttribute( "daily", daily );
		
		log.debug( "=============== VisitStatusController - visitStatus() [DEACTIVATED] ===============" );
		
		return viewName;
		
	}
	
	
}
