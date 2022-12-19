package kr.or.ddit.vo;

import lombok.Data;
import lombok.ToString;

@Data    
@ToString(exclude= {"tmpltHead", "tmpltLeft", "tmpltFooter", "tmpltPre", "tmpltPost"})
public class genTemplateVO {
	private String tmpltId;
	private String tmpltNm;
	private String tmpltBkgrd;
	private String tmpltInfo;
	private String tmpltThmnl;
	private String tmpltPayOk;
	private String tmpltHead;
	private String tmpltLeft;
	private String tmpltFooter;
	private String tmpltPre;
	private String tmpltPost;
	private String tmpltMain;
	private String tmpltBanner;
	private String tmpltFoot;
}
