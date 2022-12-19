package kr.or.ddit.vo;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * 작성자 구지현
 * 유저의 행동에 대한 로그기록을 위한 vo
 * @author PC-06
 *
 */

@Data
public class LogVO {

	@NotNull
	private int logId      ;  //로그아이디

	@NotNull
	@Max(4)
    private int logTypeId  ; //로그종류아이디

    @NotNull
    private String logHpnId   ; //로그 발생아이디

    @NotNull
    private String logHpnTime ; //로그발생시각

    @NotNull
    private String logCntnt    ; //로그내용

    //학교이름
    private String schNm;



}
