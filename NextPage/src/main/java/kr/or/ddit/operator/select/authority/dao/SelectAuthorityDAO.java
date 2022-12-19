package kr.or.ddit.operator.select.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PagingVO;

/**
 * 운영자 페이지 권한관리
 * 구지현
 */


@Mapper
public interface SelectAuthorityDAO {

	/**
	 * 권한조회
	 * @param pagingVO
	 * @return
	 */
	public List<NpMemberVO> selectAllmember(PagingVO<NpMemberVO>pagingVO);
	public int selectTotalRecord (PagingVO<NpMemberVO>pagingVO);

}
