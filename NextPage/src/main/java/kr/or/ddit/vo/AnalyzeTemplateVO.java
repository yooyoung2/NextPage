package kr.or.ddit.vo;

import lombok.Data;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/통계분석/탬플릿분석
 * @author PC-04
 *
 */
@Data
public class AnalyzeTemplateVO {

	
	private String tmpltNm; // 탬플릿 이름
	private int amount; // 탬플릿 사용자 수
	
	
}
