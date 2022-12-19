package kr.or.ddit.school.manager.ontheway.service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.GenDrctnVO;

/**
 * 학교관리자-기능관리 오시는길
 * 구지현
 */

public interface SchoolOnTheWayService {


	/**
	 * 오시는 길 등록
	 * @param gendrctnVO
	 * @return
	 */
	public ServiceResult createMap(GenDrctnVO gendrctnVO);


	/**
	 * 학교별 오시는 길 조회
	 * @param schId
	 * @return
	 */
	public GenDrctnVO retrieveMap(String schId);


	/**
	 * 오시는길 수정
	 * @param schId
	 * @return
	 */
	public ServiceResult modifyMap(GenDrctnVO gendrctnVO);

}
