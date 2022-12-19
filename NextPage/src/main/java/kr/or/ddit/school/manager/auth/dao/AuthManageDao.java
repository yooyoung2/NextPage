package kr.or.ddit.school.manager.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AuthCnctVO;

@Mapper
public interface AuthManageDao {

	/** 작성자 : 방형준(22.11.16)
	 * 
	 * 	메뉴, 게시판 접근 권한 설정 데이터 insert
	 * @param authCnct
	 * @return
	 */
	public int insertAuth(AuthCnctVO authCnct);
	
	/** 작성자 : 방형준(22.11.16)
	 * 
	 *  학교관리자아이디, 글번호, 권한명을 입력받아 해당 글번호의 권한조회
	 * 
	 * @param authCnct
	 * @return
	 */
	public String[] selectAuthCnctList(AuthCnctVO authCnct);
	
	/** 작성자 : 방형준(22.11.17)
	 * 	 학교관리자아이디, 글번호, 권한명을 입력받아 해당 글번호의 권한삭제
	 * 
	 * @param authCnct
	 * @return
	 */
	public int deleteAuth(AuthCnctVO authCnct);
	/**
	 * 작성자 : 이유영
	 * 게시판 수정시 게시판 기존 권한 삭제 
	*/
	public int updateAuth(AuthCnctVO authCnct);
	
	/**	작성자 : 이유영  11.23
	 * 메뉴정보를 제외한 나머지 권한정보 검색(글번호만 가지고감)
	 *  
	 * @return
	 */
	public List<AuthCnctVO> selectAuthList(int num);
	
	/** 작성자 : 방형준(22.11.29)
	 * 	num(menuId)를 입력받아 메뉴에 대한 권한 정보를 모두 가져온다.
	 * 
	 * 
	 * @param num
	 * @return
	 */
	public List<AuthCnctVO> selectMenuAuthList(int num);
}
