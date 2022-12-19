package kr.or.ddit.vo;

import lombok.Data;

@Data
public class DealStatusVO {

	private String day; // 날짜
	private String payId; // 결제아이디
	private String tmpltId; // 탬플릿아이디
	private String tmpltNm; // 탬플릿명
	private String schNm; // 학교이름
	private String prodPrice; // 상품가격
	private String payStat; // 결제여부
	
	
}
