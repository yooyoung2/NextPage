package kr.or.ddit.operator.analyze.template.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AnalyzeTemplateVO;

@Mapper
public interface AnalyzeTemplateDAO {

	/**
	 * 작성자 : 최현우
	 * 기능 : 운영자/통계분석/탬플릿분석
	 * 세부 : 탬플릿 이름과 해당되는 탬플릿의 사용자 수를 반환해서 어떤 탬플릿이 얼만큼 사용되는지 확인한다.
	 * @return
	 */
	public List<AnalyzeTemplateVO> sellectAmount();
	
}
