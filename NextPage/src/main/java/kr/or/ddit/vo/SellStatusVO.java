package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/매출현황
 * @author PC-04
 *
 */

@Slf4j
@Data
public class SellStatusVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sellDate; // 판매 년/월
	private int sellAmount; // 판매 수익
	
	private int totalAmount; // 총 판매 금액
	
}
