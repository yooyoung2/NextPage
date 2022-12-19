package kr.or.ddit.school.manager.teacher.classes.service;

import kr.or.ddit.vo.SchMemberFileVO;

/**
 * 게시판 관리용 Business Logic Layer
 *
 */
public interface TeacherClassFileDownService {
	public SchMemberFileVO retrieveBoard(int boNo);
	/**
	 * 게시글 수정(인증 필요)
	 * @param board
	 * @return RuntimeException, INVALIDPASSWORD, OK, FAIL
	 */
	/**
	 * 게시글 삭제(인증 필요)
	 * @param board
	 * @return RuntimeException, INVALIDPASSWORD, OK, FAIL
	 */
	
	/**
	 * @param boNo
	 * @return 갱신된 추천수
	 */
	
	/**
	 * 
	 * @param attNo
	 * @return 존재 여부에 따라 RuntiomeException 발생
	 */
	public SchMemberFileVO retrieveAttatch(int attNo); 
}




















