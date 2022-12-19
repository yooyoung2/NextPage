package kr.or.ddit.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StudAndPrntVO {

	private String prntId;
	private String studId;
	private String approval;

}
