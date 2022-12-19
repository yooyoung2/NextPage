package kr.or.ddit.school.manager.homepage.manage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.school.manager.homepage.manage.dao.HomePageManageDAO;
import kr.or.ddit.vo.GenSiteVO;
import kr.or.ddit.vo.LayoutVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SlotOptVO;
import kr.or.ddit.vo.SlotVO;
import kr.or.ddit.vo.genTemplateVO;

@Service
public class HomePageManageServiceImpl implements HomePageManageService {

	@Inject
	public HomePageManageDAO homePageManageDAO;

	@Override
	public List<GenSiteVO> retrieveGenSiteList(String schId) {
		
		return homePageManageDAO.selectGenSiteList(schId);
	}

	@Override
	public List<genTemplateVO> retrieveCostTemplateLists(String schId) {

		return homePageManageDAO.selectCostTemplateLists(schId);
	}
	
	@Override
	public List<genTemplateVO> retrieveCostTemplateList() {
		
		return homePageManageDAO.selectCostTemplateList();
	}

	@Override
	public List<genTemplateVO> retrieveFreeTemplateList() {
		
		return homePageManageDAO.selectFreeTemplateList();
	}

	@Override
	public genTemplateVO retrieveTemplate(String tmpltId) {
		
		return homePageManageDAO.selectTemplate(tmpltId);
	}

	@Override
	public List<LayoutVO> retrieveLayoutList() {
		
		return homePageManageDAO.selectLayoutList();
	}

	@Override
	public int updateGenSite(GenSiteVO genSite) {
		
		return homePageManageDAO.updateGenSite(genSite);
	}

	@Override
	public int clearGenSite(String prjctId) {

		return homePageManageDAO.clearGenSite(prjctId);
	}

	@Override
	public int deleteHomeSelect(String schId) {
	
		return homePageManageDAO.deleteHomeSelect(schId); 
	}

	@Override
	public int updateHomeSelect(String prjctId) {
		
		return homePageManageDAO.updateHomeSelect(prjctId);
	}

	@Override
	public LayoutVO retrieveLayout(String prjctId) {
		 
		return homePageManageDAO.selectLayout(prjctId) ;
	}

	@Override
	public List<SlotOptVO> retrieveSlotOptList(String prjctId) {
		
		return homePageManageDAO.selectSlotOptList(prjctId); 
	}

	@Override
	public List<SlotOptVO> retrieveDivInSlotOptList(String prjctId) {
		
		return homePageManageDAO.selectDivInSlotOptList(prjctId);
	}

	@Override
	public int deleteSlot(String prjctId) {
		
		return homePageManageDAO.deleteSlot(prjctId); 
	}

	@Override
	public int InsertSlot(SlotVO slot) {
		
		return homePageManageDAO.InsertSlot(slot);
	}

	@Override
	public int countSlotNum(String prjctId) {
		
		return homePageManageDAO.countSlotNum(prjctId);
	}

	@Override
	public int updatePrjct(PrjctVO prjct) {
		
		return homePageManageDAO.updatePrjct(prjct);
	}

	@Override
	public genTemplateVO selectGenTmpThmnl(String prjctId) {
		
		return homePageManageDAO.selectGenTmpThmnl(prjctId);
	}

	
	
	
}
