package kr.or.ddit.operator.select.authority.service;

import java.util.List;

import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PagingVO;

/**
 * 운영자 페이지 권한관리
 * 구지현
 */



public interface SelectAuthorityService {


	public List<NpMemberVO> selectAllMemAuth(PagingVO<NpMemberVO>pagingVO);

}
