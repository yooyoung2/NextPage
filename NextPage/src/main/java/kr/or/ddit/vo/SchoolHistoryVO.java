package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
/**
 * 학교관리자 교가
 * @author PC-06
 *
 */

@Data
public class SchoolHistoryVO {
	private String schId;
	private String histCntnt;
	private String histDate;
}
