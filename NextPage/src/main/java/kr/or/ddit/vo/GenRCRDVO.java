package kr.or.ddit.vo;

import lombok.Data;



/**
 * 제너레이팅 사이트 로그관리 구지현
 */

@Data
public class GenRCRDVO {

	//이력아이디
	private String recrdId;

	//이력타입
	private String recrdType;

	//이력날짜
	private String recrdDate;

	//이력상태
	private String recrdCndtn;

	//상태변경자
	private String cndtnMdfr;

	//메뉴명
	private String manuNm;

	//회원이름추가
	private String memNm;

	//학교아이디
	private String schId;

}
