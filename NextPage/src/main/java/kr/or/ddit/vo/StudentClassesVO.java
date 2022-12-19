package kr.or.ddit.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StudentClassesVO {
	
	
	private String classes;
	private String memNm;
	private String studNum;

}
