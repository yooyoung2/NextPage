package kr.or.ddit.school.manager.symbol.service;
/**
 * 학교관리자 학교상징
 * @author PC-06
 *
 */

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.SchSymbVO;

public interface SchoolSymbolService {

	/**
	 * 상징 등록
	 * @return
	 */
	ServiceResult createSymb(SchSymbVO symbVO);


	/**
	 * 상징조회
	 * @param schId
	 * @return
	 */
	public SchSymbVO retrieveSymbol(String schId);

	/**
	 * 상징수정
	 * @param symbVO
	 * @return
	 */
	ServiceResult modifySymb(SchSymbVO symbVO);

}
