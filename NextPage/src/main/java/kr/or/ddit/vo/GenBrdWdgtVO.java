package kr.or.ddit.vo;

import lombok.Data;

/**
 * 제너레이팅 게시판 위젯
 * 구지현
 * @author PC-06
 *
 */

@Data
public class GenBrdWdgtVO {

	private Integer brdNum;
	private String schId;
	private String brdTypeId;
	private String brdTitle;
	private Integer postNum;
	private String postTitle;
	private String postCntnt;
	private String postWriteDate;
	private String brdWidgetId;
	private String saveName;
	private Integer ordNum;
	private String fileName;
	private String urlInfo;
	private String savePath;
	private String dietDate;
	private String lunch;
	private String dinner;
	private Integer bnnrOrd;
	private String bnrLkNm;
	private String bnrLkImg;
	private String bnrLkUrl;
	private String realName;

	private String caldStartDate;
	private String caldEndDate;
	private String schedule;

}
