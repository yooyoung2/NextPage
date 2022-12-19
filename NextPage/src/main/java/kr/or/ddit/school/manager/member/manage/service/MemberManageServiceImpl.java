package kr.or.ddit.school.manager.member.manage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.school.manager.member.manage.dao.MemberManageDAO;
import kr.or.ddit.vo.Criteria;

import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberManageServiceImpl implements MemberManageService {

	@Inject
	MemberManageDAO dao;
	
	/**
	 * 작성자 : 최현우
	 * 
	 * 회원 한명 DB에 저장
	 * 
	 * @param schMember
	 * @return
	 */
	public Integer insertContent( SchMemberVO schMember ) {
		return dao.insertContent( schMember );
	}
	
	/**
	 * 페이징 정보가 반영된 리스트 구하기
	 * @param cri
	 * @return
	 */
	public List<SchMemberVO> getList( Criteria cri ) {
		return dao.getList( cri );
	}
	
	/**
	 * 특정 학교의 회원 수 구하기
	 * @param schId
	 * @return
	 */
	public int getTotal( String schId ) { // 어떤 학교의 회원 수 구하기
		return dao.getTotal( schId );
	} 
	
	/**
	 * 작성자 : 최현우
	 * 학교의 회원 객체 하나 가져옴
	 * @param memId
	 * @return
	 */
	public SchMemberVO getSchMember( String memId ) {
		return dao.getSchMember( memId );
	}
	
	/**
	 * 회원 수정
	 * @param schMember
	 * @return
	 */
	public int updateSchMember( SchMemberVO schMember ) {
		return dao.updateSchMember( schMember );
	}
	
	/**
	 * 회원 삭제
	 * @param memId
	 * @return
	 */
	public int delSchMember( String memId ) {
		return dao.delSchMember( memId );
	}
	
}
