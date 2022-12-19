package kr.or.ddit.vo;

import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SchoolVO {

	@NotNull
	private String schId; // 학교아이디

	@NotNull
	private String schNm; // 학교이름

	private String schPw;	// 비밀번호	- 강은비 다시만듦
	private String schEmail; // 학교이메일
	private String schEmailId;
	private String schEmailAddr;
	private String schTelNum; // 학교전화번호
	private String schPostNum; // 학교우편번호
	@NotNull
	private String schAddr1; // 학교 시,도
	private String schAddr2; // 학교주소
	private String schApntd; // 학교분류
	private String srvcWhthr; // 서비스여부
	private String hpLink; // 홈페이지링크
	private String fstPchDate; // 최초구매일( Date타입 )
	private String fstPchStat; // 최초구매 여부
	private String schWithdwral; // 학교탈퇴


	/* 이유영 */
	//private Set<GenBoardVO> GenboardList;

	// 최현우
	private String tmpltNm; // 탬플릿이름

	//구지현 푸터
	private String addr;
	private String email;
	private String schFaxNum;

}
