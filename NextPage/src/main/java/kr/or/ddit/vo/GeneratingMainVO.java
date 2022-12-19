package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 작성자 : 최현우
 * Generation 메인 홈페이지에 있는 메뉴이름, 메뉴링크 저장
 * @author PC-04
 *
 */

@Data
public class GeneratingMainVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String schId; // 회원 아이디
	private String topMenuId; // 1차메뉴 아이디
	private String menuId; // 하위 메뉴 아이디
	private String menuNm; // 하위 메뉴 이름
	private String menuLink; // 하위 메뉴 링크
	private String top; // 
	private String menuType;
	
	/** 
	 * 작성자 : 최현우
	 */
	private String rtrnJsp; // 뷰 랜더링 주소 저장
	
	/**
	 * 2022.11.26 추가
	 */
	private String brdNum; // 보드넘
}
