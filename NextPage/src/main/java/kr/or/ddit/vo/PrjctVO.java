package kr.or.ddit.vo;

import lombok.Data;

@Data
public class PrjctVO {
	private String prjctId;
	private String schId;
	private String layoutId;

	//제너레이팅 메인페이지 레이아웃
	private String tmpltId ;
	private	String	divNum ;
	private	String	divValue;
	private	String	layoutSc;


}
