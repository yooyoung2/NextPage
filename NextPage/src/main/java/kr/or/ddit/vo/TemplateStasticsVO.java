package kr.or.ddit.vo;

import lombok.Data;

/**
 * 작성자 : 최현우
 * 템플릿별 판매현황, 템플릿별 사용현황
 * @author PC-04
 *
 */

@Data
public class TemplateStasticsVO {

	private String templateNm; // 탬플릿 이름
	private int amount; // 수치
	
}
