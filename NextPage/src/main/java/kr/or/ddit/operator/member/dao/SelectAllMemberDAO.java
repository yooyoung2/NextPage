package kr.or.ddit.operator.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchoolVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/회원관리/
 * @author PC-04
 *
 */

@Mapper
public interface SelectAllMemberDAO {

	/**
	 * 작성자 : 최현우
	 * 기능 : 회원목록 조회
	 * 1123페이징 검색 기능 추가 구지현
	 * @return
	 */
	public List<SchoolVO> selectAllmember(PagingVO<SchoolVO>pagingVO);
	public int selectTotalRecord (PagingVO pagingVO);

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
