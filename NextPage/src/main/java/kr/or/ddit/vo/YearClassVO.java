package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class YearClassVO {
	
	@NotBlank
	private String year;
	@NotBlank
	private String classes;
	@NotBlank
	private String edupsnId;
	
}
