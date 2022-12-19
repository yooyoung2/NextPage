package kr.or.ddit.school.manager.menu.hello.service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.SchGretngVO;

/**
 * 학교장 인사말
 * @author PC-06
 *
 */
public interface MenuHelloService {

	/**
	 *학교장 인사말 등록
	 * @param schGretngVO
	 * @return
	 */
	ServiceResult createHello(SchGretngVO schGretngVO);

	/**
	 * 학교장 인사말 조회
	 * @param schId
	 * @return
	 */
	SchGretngVO selectHello(String schId);


	/**
	 * 학교장 인사말 수정
	 * @param schGretngVO
	 * @return
	 */
	ServiceResult modifyHello(SchGretngVO schGretngVO);

}
