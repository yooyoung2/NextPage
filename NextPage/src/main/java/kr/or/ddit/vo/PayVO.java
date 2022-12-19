package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( of="payId" )
public class PayVO {
	
	private int rnum;
	
	private String payId;
	private int cartId;
	private String payMthdId;
	private String payDate;
	private String nextPayDuedate;
	private String payStat;
	private String etc;
	
	private String schId;
	
	//cartvo
	private String prodId;
	private String prodNm;
	private String prodPrice;
}
