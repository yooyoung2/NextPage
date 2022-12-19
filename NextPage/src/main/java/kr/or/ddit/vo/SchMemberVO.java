package kr.or.ddit.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SchMemberVO {
	
	
	private String memId;
	private String schId;
	private String memPw;
	@NotBlank
	private String memNm;
	
	private String memEmailId;
	private String memEmailAddr;

	@Email
	private String memEmail;
	
	@NotBlank
	private String telNum;
	private String addr1;
	private String addr2;
	
	private String authMem;	// 로그인했을시 권한. (학생, 교직원, 학부모)
	
	
	// 학부모 회원가입때문에 추가
	private String prntId;	// 학부모 id
	//private String fm;		// 부, 모
	
	private String studNm;	// 자녀 이름
	
	private String studId; //자녀 학번(아이디) 
	private String approvalOk;	// 학부모 승인 yes or no
	
	
}
