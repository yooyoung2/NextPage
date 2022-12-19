package kr.or.ddit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchVO {
	private String searchType;
	private String searchWord;

	//날짜 검색위함 구지현
	private String searchStartDate;
	private String searchEndDate;
}
