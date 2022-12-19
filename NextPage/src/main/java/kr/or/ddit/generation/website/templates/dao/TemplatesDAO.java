package kr.or.ddit.generation.website.templates.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.TemplatesVO;

@Mapper
public interface TemplatesDAO {

	/**
	 * footer만 가지고 오는 테스트용 메소드
	 * @return
	 */
	public TemplatesVO getFooter( String tmpltId );
	
}
