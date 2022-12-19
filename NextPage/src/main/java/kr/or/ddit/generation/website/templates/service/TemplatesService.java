package kr.or.ddit.generation.website.templates.service;

import kr.or.ddit.vo.TemplatesVO;

public interface TemplatesService {

	/**
	 * footer만 가지고 오는 테스트용 메소드
	 * @return
	 */
	public TemplatesVO getFooter( String tmpltId );
	
}
