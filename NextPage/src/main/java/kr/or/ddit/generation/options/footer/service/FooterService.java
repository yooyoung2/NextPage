package kr.or.ddit.generation.options.footer.service;

import kr.or.ddit.vo.SchoolVO;

public interface FooterService {
	/**
	 * 제너레이팅 푸터
	 * @param schId
	 * @return
	 */
	public SchoolVO selectGenFooter(String schId);

}
