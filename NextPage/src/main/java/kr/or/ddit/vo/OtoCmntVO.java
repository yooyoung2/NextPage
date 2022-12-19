package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 넥스트페이지
 * 1:1문의 운영자 답변댓글
 * @author PC-06
 *
 */

@Data
public class OtoCmntVO {

	//댓글아이디
	@NotBlank
	private Integer cmmntId;

	//게시판번호
	@NotBlank
	private Integer otoBrdNum;

	//댓글작성아이디
	@NotBlank
	private String cmntId;

	//댓글내용
	@NotNull
	private String cmmntCntnt;

	//댓글일자
	private String cmmntDate;


}
