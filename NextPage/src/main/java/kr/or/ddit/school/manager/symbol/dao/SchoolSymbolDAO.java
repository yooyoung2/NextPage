package kr.or.ddit.school.manager.symbol.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.SchSymbVO;
/**
 * 학교 상징
 * @author PC-06
 *
 */

@Mapper
public interface SchoolSymbolDAO {

	/**
	 * 상징 등록
	 * @param symbVO
	 * @return
	 */
	public int insertSymbol(SchSymbVO symbVO);

	/**
	 * 상징조회
	 * @param schId
	 * @return
	 */
	public SchSymbVO selectSymbol(String schId);

	/**
	 * 상징수정
	 * @param symbVO
	 * @return
	 */
	public int updateSymbol(SchSymbVO symbVO);

}
