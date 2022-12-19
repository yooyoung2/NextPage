package kr.or.ddit.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @author : 최현우
 *
 */

@Data
@ToString(exclude= {"cntntsCntnt"})
public class ContentVO {
	private Integer cntntsId; // 컨텐츠 아이디
	private String schId; // 학교아이디
	private String cntntsTitle; // 컨텐츠 제목
	private String cntntsCntnt; // 컨텐츠 내용
	private String fileName; //파일명
	
}
