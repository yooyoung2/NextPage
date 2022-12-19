package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Join_Year_SCH_VO {
	
	String studId;
	String year;
	String classes;
	String memNm;
	String edupsnId;
	
}
