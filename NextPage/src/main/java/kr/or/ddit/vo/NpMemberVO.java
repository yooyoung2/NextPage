package kr.or.ddit.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode( of="npMemId" )
public class NpMemberVO {
	@NotNull( message="아이디를 입력하세요" )
	private String npMemId;

	@NotNull( message="비밀번호를 입력하세요" )
	private String memPw;
	private String memAuth;


	//권한조회 학교, 관리자 이름
	private String schNm;
	private String adminNm;


}
