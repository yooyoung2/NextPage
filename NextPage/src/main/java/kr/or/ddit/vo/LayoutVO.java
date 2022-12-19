package kr.or.ddit.vo;

import lombok.Data;
import lombok.ToString;

@ToString(exclude= {"layoutSc"}) 
@Data
public class LayoutVO {
	private String layoutFile;
	private String layoutId;
	private String layoutXPstn;
	private String layoutYPstn;
	private String layoutWdth;
	private String layoutHght;
	private String layoutSc;
}
