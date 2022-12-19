package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 작성자 : 최현우
 *
 * GeneratingMain에서 사용자가 어떤 template을 사용하는지 알아야하기 때문에
 * template id를 가져와야한다.
 *
 * @author PC-04
 *
 */

@Data
public class ProjectVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String schId;	// 학교아이디
	private String prjctId;	// 프로젝트아이디
	private String tmpltId;	// 탬플릿아이디

	//제너레이팅 메인페이지 레이아웃 구지현
	private String layoutId ;
	private	String	divNum ;
	private	String	divValue;
	private	String	layoutSc;

}
