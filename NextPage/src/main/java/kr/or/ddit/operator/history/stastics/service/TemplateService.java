package kr.or.ddit.operator.history.stastics.service;

import java.util.List;

import kr.or.ddit.vo.TemplateStasticsVO;



public interface TemplateService {

	/**
	 * 탬플릿별 판매현황
	 * @return
	 */
	public List<TemplateStasticsVO> templateSell();
	
	/**
	 * 탬플릿별 사용현황
	 * @return
	 */
	public List<TemplateStasticsVO> templateUse();
	
}
