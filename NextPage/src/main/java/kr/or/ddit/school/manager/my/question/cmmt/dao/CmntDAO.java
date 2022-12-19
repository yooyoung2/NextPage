package kr.or.ddit.school.manager.my.question.cmmt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.OtoCmntVO;

/**
 * 넥스트페이지  문의답변
 * 구지현
 * @author PC-06
 *
 */


@Mapper
public interface CmntDAO {
	/** 답변 등록
	 * @param OtoCmntVO
	 * @return 성공 : 1 실패 : 0
	 */
	public int insertCmnt(OtoCmntVO cmnt);

	/**
	 * 답변 조회
	 * @param otoBrdNum
	 * @return 존재하지 않는다면, null 반환
	 */
	public List<OtoCmntVO> selectCmntList(Integer otoBrdNum);

	/**
	 * 답변 상세조회
	 * @param cmmntId
	 * @return
	 */
	public OtoCmntVO selectCmnt(Integer cmmntId);


	/**
	 * 답변 수정
	 * @param OtoCmntVO
	 * @return 성공 : 1 실패 : 0
	 */
	public int updateCmnt(OtoCmntVO cmnt);

	/**
	 * 답변 삭제
	 * @param otoBrdNum
	 * @return 성공 : 1 실패 : 0
	 */
	public int deleteCmnt(@Param("otoBrdNum") Integer otoBrdNum);

}
