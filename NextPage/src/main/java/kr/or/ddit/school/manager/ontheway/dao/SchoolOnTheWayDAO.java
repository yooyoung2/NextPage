package kr.or.ddit.school.manager.ontheway.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.GenDrctnVO;

/**
 * 학교관리자-기능관리 오시는길
 * 구지현
 */

@Mapper
public interface SchoolOnTheWayDAO {
	/**
	 * 오시는길 등록
	 * @param gendrctnVO
	 * @return
	 */
	public int insertMap(GenDrctnVO gendrctnVO);

	/**
	 * 학교별 오시는 길 조회
	 * @param schId
	 * @return
	 */
	public GenDrctnVO selectMap(String schId);

	/**
	 * 오시는길 수정
	 * @param schId
	 * @return
	 */
	public int updateMap(GenDrctnVO gendrctnVO);
}
