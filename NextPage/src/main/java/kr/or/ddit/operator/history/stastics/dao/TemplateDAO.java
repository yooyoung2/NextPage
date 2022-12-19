package kr.or.ddit.operator.history.stastics.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.TemplateStasticsVO;

/**
 * 작성자 : 최현우
 * 탬플릿별 판매현황, 탬플릿별 사용현황
 * @author PC-04
 *
 */
@Mapper
public interface TemplateDAO {

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
