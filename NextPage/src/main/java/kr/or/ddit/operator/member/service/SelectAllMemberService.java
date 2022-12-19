package kr.or.ddit.operator.member.service;

import java.util.List;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchoolVO;

/**
 * 작성자 : 최현우
 * @author PC-04
 *
 */

public interface SelectAllMemberService {

	/**
	 * 작성자 : 최현우
	 * 기능 : 회원목록 조회
	 * @return
	 */
	public List<SchoolVO> selectAllmember(PagingVO<SchoolVO>pagingVO);


	/**
	 * 작성자 : 최현우
	 * 기능 : 회원 상세조회
	 * @param id
	 * @return
	 */
	public SchoolVO selectDetailSchool( String id );


	/**
	 * 작성자 : 최현우
	 * 기능 : 회원정보 수정
	 * @param school
	 * @return
	 */
	public int updateDetailSchool( SchoolVO school );

}
