package kr.or.ddit.operator.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.member.dao.SelectAllMemberDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchoolVO;


/**
 * 작성자 : 최현우
 * @author PC-04
 *
 */
@Service
public class SelectAllMemberServiceImpl implements SelectAllMemberService {

	@Inject
	SelectAllMemberDAO dao;

	@Override
	public List<SchoolVO> selectAllmember(PagingVO<SchoolVO>pagingVO) {

		int totalRecode = dao.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecode);

//		List<SchoolVO> schools = dao.selectAllmember(pagingVO);
//
//		if( schools != null && !schools.isEmpty() ) {
//			return schools;
//		}else {
//			return null;
//		}
		return dao.selectAllmember(pagingVO);

	}

	/**
	 * 작성자 : 최현우
	 * 기능 : 회원 상세조회
	 */
	@Override
	public SchoolVO selectDetailSchool(String id) {

		SchoolVO school = dao.selectDetailSchool( id );

		return school;

	}


	/**
	 * 작성자 : 최현우
	 * 기능 : 회원정보 수정
	 * @param school
	 * @return
	 */
	@Override
	public int updateDetailSchool(SchoolVO school) {
		// TODO Auto-generated method stub
		return dao.updateDetailSchool( school );
	}

}
