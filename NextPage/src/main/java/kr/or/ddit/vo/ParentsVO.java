package kr.or.ddit.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ParentsVO {
	
	@NotNull
	private String prntId;
	@NotNull
	private String fm;
	
	private String birthMonDay;
	
	@NotNull
	private String[] studId; 
}
