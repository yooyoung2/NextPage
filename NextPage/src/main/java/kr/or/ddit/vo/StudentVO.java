package kr.or.ddit.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StudentVO {
	
	@NotNull
	private String studId;
}
