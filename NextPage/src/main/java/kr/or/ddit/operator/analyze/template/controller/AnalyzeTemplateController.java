package kr.or.ddit.operator.analyze.template.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.operator.analyze.template.service.AnalyzeTemplateService;
import kr.or.ddit.vo.AnalyzeTemplateVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/통계분석/탬플릿분석
 * @return
 */

@Slf4j
@Controller
public class AnalyzeTemplateController {
	
	@Inject
	AnalyzeTemplateService service;
	
	@RequestMapping( "operator/analysisTemplate" )
	public String analysisTemplate( Model model ) {
		
		
		List<AnalyzeTemplateVO> data = service.sellectAmount();
		
		for( AnalyzeTemplateVO vo : data ) {
			log.info( "============================" );
			log.info( "탬플릿 : " + vo.getTmpltNm() );
			log.info( "사용수 : " + vo.getAmount() );
			log.info( "============================" );
		}
		
		model.addAttribute( "data", data ); // 탬플릿 이름, 탬플릿 사용자 수를 담은 vo값 리스트 반환
		
		return "operator/08_analyzeTemplate/analystTeamplate";

	}

}
