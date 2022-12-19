package kr.or.ddit.vo;


import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class CartVO {

	private String schId;
	private int cartId;
	private String prodId;
	private String buyOk;
	
	//private ProdItemsVO prod;
	
	private String prodNm;
	private String prodPrice;
	private String payId;
	
}
