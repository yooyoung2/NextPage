package kr.or.ddit.school.manager.homepage.manage.service;

import java.util.List;

import kr.or.ddit.vo.GenSiteVO;
import kr.or.ddit.vo.LayoutVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SlotOptVO;
import kr.or.ddit.vo.SlotVO;
import kr.or.ddit.vo.genTemplateVO;

public interface HomePageManageService {
	
	/**	작성자 : 방형준 (22.11.21)
	 * 	학교아이디를 입력받아 현재 내프로젝트 목록을 조회한다.
	 * 
	 * @param schId
	 * @return
	 */ 
	public List<GenSiteVO> retrieveGenSiteList(String schId);
	
	/** 작성자 : 방형준(22.12.12)
	 * 
	 *  학교아이디를 입력받아 현재 내가 갖고 있는 유로템플릿 목록을 가져온다.
	 * 
	 * @return
	 */
	public List<genTemplateVO> retrieveCostTemplateLists(String schId);
	
	/** 작성자 : 방형준(22.11.22)
	 * 	유료템플릿 목록을 가져온다.
	 * 
	 * @return
	 */
	public List<genTemplateVO> retrieveCostTemplateList();
	
	/** 작성자 : 방형준(22.11.22)
	 * 	무료템플릿 목록을 가져온다.
	 * 
	 * @return
	 */
	public List<genTemplateVO> retrieveFreeTemplateList();
	
	/** 작성자 : 방형준(22.11.22)
	 * 
	 * 	템플릿 ID를 입력받아 템플릿1개의 데이터를 출력한다.
	 * @param tmpltId
	 * @return
	 */
	public genTemplateVO retrieveTemplate(String tmpltId);
	
	
	/** 작성자 : 방형준(22.11.22)
	 * 	레이아웃목록 전체 출력.
	 * 
	 * @return
	 */
	public List<LayoutVO> retrieveLayoutList();
	
	/** 작성자 : 방형준(22.11.22)
	 * 
	 * 	비어있는 슬롯에 데이터 삽입(템플릿정보, 레이아웃정보)
	 * @param genSite
	 * @return
	 */
	public int updateGenSite(GenSiteVO genSite);
	
	/** 작성자 : 방형준 (22.11.22)
	 * 
	 * 	작성중인 프로젝트 내용 삭제. 
	 * 	코멘트는 삭제이지만 실데이터는 update로 null 값을 셋팅함.
	 * 
	 * @param prjctId
	 * @return
	 */
	public int clearGenSite(String prjctId);
	
	/** 작성자 : 방형준(22.11.24)
	 * 
	 * 	학교아이디가 가지고 있는 모든 homeSelect 컬럼을 전부 NO로 변경한다.
	 * 	이후 업데이트가 성공했다면 jsp에서 올라온 prjctId의 값의 homeSelect를 YES로 바꾼다.
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteHomeSelect(String schId);
	
	/**	작성자 : 방형준(22.11.24) 
	 * 
	 * 입력받은 prjctId의 homeSelect 컬럼값을 YES로 변경한다.
	 * 
	 * @param prjctId
	 * @return
	 */
	public int updateHomeSelect(String prjctId);
	
	/** 작성자 : 방형준(22.11.25)
	 * 	프로젝트 아이디를 입력받아서 현재 프로젝트의 레이아웃 정보를 가져옴.
	 * 
	 * @param prjctId
	 * @return
	 */ 
	public LayoutVO retrieveLayout(String prjctId);
	
	/** 작성자 : 방형준(22.11.25) 	
	 * 
	 * 	슬롯아이템 목록 출력 (레이아웃에 들어가지못한 데이터들)
	 * 
	 * @return
	 */
	public List<SlotOptVO> retrieveSlotOptList(String prjctId);
	
	/** 작성자 : 방형준(22.11.25)
	 * 
	 * 	슬롯아이템 목록 출력 (레이아웃에 들어간 데이터들)
	 * 
	 * @param prjctId
	 * @return
	 */
	public List<SlotOptVO> retrieveDivInSlotOptList(String prjctId);
	
	/**	데이터를 업데이트 하기위한 선작업
	 * 	프로젝트 아이디를 받아 해당 프로젝트의 슬롯정보를 모두 삭제한다.
	 * 	성공여부에 따라 새로운 데이터를 insert 하거나, 취소된다.
	 * 
	 * @param prjctId
	 * @return
	 */
	public int deleteSlot(String prjctId);
	
	/** 작성자 : 방형준(22.11.26)
	 * 	새로운 슬롯정보를 insert
	 * 
	 * @param slot
	 * @return
	 */
	public int InsertSlot(SlotVO slot);
	
	/** 작성자 : 방형준(22.11.26)
	 * 	현재 프로젝트의 슬롯개수를 가져온다.
	 * 	첫 슬롯 등록할때 삭제 성공여부에 따라서 구분을 지을수가 없음.
	 * 	삭제성공 or 현재 프로젝트의 슬롯의 정보가 없으면 insert 시도를 하기위함. 
	 * 
	 * @param prjctId
	 * @return
	 */
	public int countSlotNum(String prjctId);
	
	/** 작성자 : 방형준(22.11.30)
	 * 	프로젝트정보 수정
	 * 
	 * @param prjct
	 * @return
	 */
	public int updatePrjct(PrjctVO prjct);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 *  프로젝트 아이디를 가지고 템플릿 정보를 획득한다.	
	 * 
	 * @param prjctId
	 * @return
	 */
	public genTemplateVO selectGenTmpThmnl(String prjctId);
}
