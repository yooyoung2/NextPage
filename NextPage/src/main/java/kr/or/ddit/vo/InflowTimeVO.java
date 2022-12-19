package kr.or.ddit.vo;

import lombok.Data;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/통계분석/유입시간대 분석
 * 설명 : 00시 ~ 23시의 방문자 수 통계
 * @author choim
 *
 */
@Data
public class InflowTimeVO {

	
	private String time; // 시간대
	private String visitors; // 방문자 수
	
	
}
