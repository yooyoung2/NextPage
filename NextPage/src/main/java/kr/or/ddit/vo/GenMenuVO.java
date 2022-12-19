package kr.or.ddit.vo;

import java.util.List;

import javax.validation.constraints.Null;

import lombok.Data;

@Data
public class GenMenuVO {

	
	private String level;
	private String schId;
	private Integer topMenuId;
	private String menuNm;
	private String menuLink;
	private Integer menuId;
	private String top;
	private String MenuUseOk;
	
	/** 작성자 : 방형준 (22.11.15)
	 * 	현재 메뉴의 상위 메뉴이름을 가져오기위함.
	 */
	private String topMenuNm;

	/** 작성자 : 방형준 (22.11.15)
	 *	링크 정보 생성할때, 타입(타입없음, 게시판+컨텐츠, 링크타입)에따라서 모양이 달라서 타입값을
	 *  jsp에서 받아서 그에따른 처리를 하기위한 변수 
	 */
	private String menuType;
	
	/** 작성자 : 방형준(22.11.23)
	 * 	1,2차메뉴 등 데이터를 미리만들고 마지막에 갈 jsp정보를 db에 저장함
	 * 
	 */
	private String rtrnJsp;
	
}
