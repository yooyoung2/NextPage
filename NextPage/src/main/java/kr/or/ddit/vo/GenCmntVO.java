package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(of="cmmntId")
public class GenCmntVO {
	private Integer cmmntId;
	private Integer postNum;
	private String cmntId;
	private String cmmntCntnt;
	private String cmmntDate;
	private String memNm;
}
