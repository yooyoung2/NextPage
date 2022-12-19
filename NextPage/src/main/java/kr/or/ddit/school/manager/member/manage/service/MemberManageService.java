package kr.or.ddit.school.manager.member.manage.service;

import java.util.List;

import kr.or.ddit.vo.Criteria;

import kr.or.ddit.vo.SchMemberVO;

public interface MemberManageService {
	/**
	 * 작성자 : 최현우
	 * 
	 * 회원 한명 DB에 저장
	 * 
	 * @param schMember
	 * @return
	 */
	public Integer insertContent(SchMemberVO content);

	/**
	 * 페이징 정보가 반영된 리스트 구하기
	 * 
	 * @param cri
	 * @return
	 */
	public List<SchMemberVO> getList(Criteria cri);

	/**
	 * 특정 학교의 회원 수 구하기
	 * 
	 * @param schId
	 * @return
	 */
	public int getTotal(String schId); // 어떤 학교의 회원 수 구하기

	/**
	 * 작성자 : 최현우 학교의 회원 객체 하나 가져옴
	 * 
	 * @param memId
	 * @return
	 */
	public SchMemberVO getSchMember(String memId);

	/**
	 * 회원 수정
	 * 
	 * @param schMember
	 * @return
	 */
	public int updateSchMember(SchMemberVO schMember);

	/**
	 * 회원 삭제
	 * 
	 * @param memId
	 * @return
	 */
	public int delSchMember(String memId);
}
