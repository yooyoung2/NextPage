package kr.or.ddit.school.manager.menu.hello.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.SchGretngVO;

/**
 * 학교장인사말
 * @author PC-06
 *
 */
@Mapper
public interface MenuHelloDAO {

	/**
	 * 학교장인사말 등록
	 * @param schGretngVO
	 * @return
	 */
	public int insertHello(SchGretngVO schGretngVO);

	/**
	 * 학교장인사말 조회
	 * @param schId
	 * @return
	 */
	public SchGretngVO selectHello(String schId);

	/**
	 * 학교장 인사말 수정
	 * @param schGretngVO
	 * @return
	 */
	public int updateHello(SchGretngVO schGretngVO);
	
	/** 작성자 : 방형준(22.12.08)
	 * 
	 * 	파일업로드용 데이터
	 * 
	 * @param schGretng
	 * @return
	 */
	public int insertSchGretngBoardFile(SchGretngVO schGretng);

}
