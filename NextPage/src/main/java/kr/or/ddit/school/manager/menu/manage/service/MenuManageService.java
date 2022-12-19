package kr.or.ddit.school.manager.menu.manage.service;

import java.util.List;

import kr.or.ddit.vo.GenAlertBrdVO;
import kr.or.ddit.vo.GenCaldVO;
import kr.or.ddit.vo.GenFooterVO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.GenMenuVO;
import kr.or.ddit.vo.GenSiteVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.SchLogoVO;

public interface MenuManageService {
	
	/** 작성자 : 방형준(22.11.08)
	 * 
	 * 	로그인한 아이디의 정보를 받아 전체 메뉴정보를 출력
	 * 
	 * @param schId
	 * @return List<GenMenuVO>
	 */
	public String retrieveGenMenuList(String schId);
	
	
	/** 작성자 : 방형준(22.11.08)
	 * 
	 * 	메뉴아이디의 정보를 받아 메뉴정보 출력
	 * @param menuId
	 * @return
	 */ 
	public GenMenuVO retrieveGenMenu(GenMenuVO genMenu);
	
	/** 작성자 : 방형준(22.11.11)
	 *  최상위메뉴의 메뉴아이디 최대값 출력
	 *  
	 * @return 
	 */
	public int retrieveTopMaxMenuId(String schId);
	
	/** 작성자 : 방형준(22.11.11)
	 * 
	 *  상위메뉴 아이디를 가지고 현재 메뉴의 최대값을 출력함.
	 * 
	 * @param topMenuId 
	 * @return 
	 */
	public Integer retrieveSubMaxMenuId(GenMenuVO genMenu);
	
	/** 작성자 : 방형준(22.11.11)
	 * 
	 *  입력받은 메뉴정보 입력
	 *  
	 * @param genMenu
	 * @return
	 */
	public Integer insertGenMenu(GenMenuVO genMenu);
	
	/** 작성자 : 방형준
	 * 
	 * 	입력해놓은 데이터 수정, 삭제를 위한 데이터 검색
	 * @param genMenu(글번호, 아이디)
	 * @return 
	 */
	public GenMenuVO retrieveSetGenMenu(GenMenuVO genMenu);
	
	
	/** 작성자 : 방형준(22.11.17)
	 * 	수정버튼을 통한 데이터를 받아서 DB데이터 수정
	 * 
	 * @param genMenu
	 * @return
	 */
	public int updateGenMenu(GenMenuVO genMenu);
	
	
	/** 작성자 : 방형준(22.11.18)
	 * 	
	 * 입력받은 menuId가 최상위메뉴인지 아닌지 판별하기위한 검색
	 * 
	 * @param genMenu
	 * @return
	 */
	public Integer retrieveTopMenuId(GenMenuVO genMenu);
	
	/** 작성자 : 방형준(22.11.18)
	 * 
	 * 	입력받은 menuId와 schId를 입력받아 메뉴를 삭제함.
	 *  
	 *  
	 * @param genMenu
	 * @return
	 */
	public int deleteMenuId(GenMenuVO genMenu);
	
	/** 작성자 : 방형준(22.11.18)
	 * 	입력받은 topMenuId와 schId를 입력받아 메뉴를 삭제함.
	 * 	상위메뉴를 골랐을경우 하위메뉴를 전체 삭제하기위한 메소드
	 * @param genMenu
	 * @return
	 */
	public int deleteTopMenuId(GenMenuVO genMenu);
	
	/**	작성자 : 방형준(22.11.18)
	 * 	입력받은 menuId(상위)를 가지고 하위메뉴들의 번호들을 검색함
	 * 
	 * @param genMenu(menuId, schId)
	 * @return
	 */
	public Integer[] retrieveMenuId(GenMenuVO genMenu);
	
	/** 타입에따른 jsp리턴값 출력
	 * 
	 * @param rtrnType
	 * @return
	 */
	public String retrieveRtrnJSP(String rtrnType);
	
	/** 작성자 : 방형준(22.12.07)
	 * 	
	 * 	회원가입이후 최상위 메뉴1개 추가.
	 * 
	 * @param genMenu
	 * @return
	 */
	public int insertMenuSignUp(GenMenuVO genMenu);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 * 	회원가입이후 빈 프로젝트 추가(3개)
	 * 
	 * @param prjct
	 * @return
	 */
	public int insertPrjctSignUp(PrjctVO prjct);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 * 	아이디를 입력받아 프로젝트 정보를 가져옴
	 * 
	 * @param schId
	 * @return
	 */
	public List<PrjctVO> retrievePrjctList(String schId);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 *  회원가입이 완료된 후 비어있는 genSite정보 넣어줌.
	 * 
	 * @param genSite
	 * @return
	 */
	public int insertGenSite(GenSiteVO genSite);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 * 	회원가입이 완료된 후 비어있는 로고정보 넣어줌.
	 * 
	 * @param schLogo
	 * @return
	 */
	public int insertSchLogo(SchLogoVO schLogo);
	
	/** 작성자 : 방형준(22.12.07)
	 * 	
	 * 	회원가입이 완료된 후 비어있는 메인이미지
	 * 
	 * @param genMainImg
	 * @return
	 */
	public int insertGenMainImg(GenMainImgVO genMainImg);
	
	/** 작성자 : 방형준(22.12.07)
	 * 	
	 * 	회원가입이 완료된 후 비어 있는 알림판 정보 넣어줌.
	 * 
	 * @param genAlertBrd
	 * @return
	 */
	public int insertGenAlertBrd(GenAlertBrdVO genAlertBrd);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 * 	회원가입이 완료된 후 비어 있는 푸터 정보 넣어줌.
	 * 
	 * @param genFooter
	 * @return
	 */
	public int insertGenFooter(GenFooterVO genFooter);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 * 	회원가입이 완료된 후 비어 있는 달력정보 넣어줌.
	 * 
	 * @param genCald
	 * @return
	 */
	public int insertGenCald(GenCaldVO genCald);

}
