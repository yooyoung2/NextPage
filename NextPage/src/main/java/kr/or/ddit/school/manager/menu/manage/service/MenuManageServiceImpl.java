package kr.or.ddit.school.manager.menu.manage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.school.manager.menu.manage.dao.MenuManageDAO;
import kr.or.ddit.vo.GenAlertBrdVO;
import kr.or.ddit.vo.GenCaldVO;
import kr.or.ddit.vo.GenFooterVO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.GenMenuVO;
import kr.or.ddit.vo.GenSiteVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.SchLogoVO;

@Service
public class MenuManageServiceImpl implements MenuManageService {

	@Inject
	public MenuManageDAO menuManageDAO;
	
	/*
	@Override
	public List<GenMenuVO> retrieveGenMenuList(String schId) {
		List<GenMenuVO> menuList = menuManageDAO.selectGenMenuList(schId);
		return menuList;
	}
	*/
	
	@Override
	public String retrieveGenMenuList(String schId) {
		
		List<GenMenuVO> menuList = menuManageDAO.selectGenMenuList(schId);
		
		String returnVal = "";
		returnVal += "<div>\n\t<ul id='topul'>\n";
		for(GenMenuVO list : menuList) {
			if(list.getLevel().equals("1")) {
				if(!(list.getMenuId()==1)) {
					returnVal += "</ul></li>";
				}
				returnVal += "<li class='menu1 '>"
						+ "<input class='btn btn-sm btn-light' type='button' value='설정' data-bs-toggle='modal' data-bs-target='#exampleModal2'  data-menuid='"+list.getMenuId() +"' /> "
						+ "<input class='btn btn-sm btn-light' type='button' value='하위메뉴추가'  data-bs-toggle='modal' data-bs-target='#exampleModal' data-menuid='"+list.getMenuId() + "' />"
						+ "<a style='color: white;font-size: 1.1em;font-family: system-ui;font-weight: 550;'> &nbsp;&nbsp;"+list.getMenuNm() +"</a>"
						//+ "<a class='btn ' data-bs-toggle='modal' data-bs-target='#exampleModal' data-menuid='"+list.getMenuId() + "'" +">하위메뉴추가</a>"
						+ " <ul class='hide' id='subli"+ list.getMenuId()+"'>";
			}
			if(list.getLevel().equals("2")) {
				returnVal += "<li class='menu2'> <input data-bs-target='#exampleModal2' data-bs-toggle='modal' class='btn btn-sm btn-secondary' type='button' value='설정' data-menuid='"  + list.getMenuId()+"' /> &nbsp;&nbsp; "+list.getMenuNm() +"</li>";
			}
		}
		returnVal += "</ul></li> </ul> </div>";
		return returnVal;
	}
	
	@Override
	public GenMenuVO retrieveGenMenu(GenMenuVO genMenu) {
		
		return menuManageDAO.selectGenMenu(genMenu);
	}

	@Override
	public int retrieveTopMaxMenuId(String schId) {
		
		return menuManageDAO.selectTopMaxMenuId(schId);
	}
	
	@Override
	public Integer retrieveSubMaxMenuId(GenMenuVO genMenu) {
		
		return menuManageDAO.selectSubMaxMenuId(genMenu);
	}

	@Override
	public Integer insertGenMenu(GenMenuVO genMenu) {
		
		return menuManageDAO.insertGenMenu(genMenu);
	}

	@Override
	public GenMenuVO retrieveSetGenMenu(GenMenuVO genMenu) {
		
		return menuManageDAO.selectSetGenMenu(genMenu);
	}

	@Override
	public int updateGenMenu(GenMenuVO genMenu) {
		
		return menuManageDAO.updateGenMenu(genMenu);
	}

	@Override
	public Integer retrieveTopMenuId(GenMenuVO genMenu) {
		 
		return menuManageDAO.selectTopMenuId(genMenu);
	}

	@Override
	public int deleteMenuId(GenMenuVO genMenu) {

		return menuManageDAO.deleteMenuId(genMenu) ;
	}

	@Override
	public int deleteTopMenuId(GenMenuVO genMenu) {
		
		return menuManageDAO.deleteTopMenuId(genMenu);
	}

	@Override
	public Integer[] retrieveMenuId(GenMenuVO genMenu) {
		return menuManageDAO.selectMenuId(genMenu);
	}

	@Override
	public String retrieveRtrnJSP(String rtrnType) {
		
		return menuManageDAO.selectRtrnJSP(rtrnType);
	}

	@Override
	public int insertMenuSignUp(GenMenuVO genMenu) {
		
		return menuManageDAO.insertMenuSignUp(genMenu);
	}

	@Override
	public int insertPrjctSignUp(PrjctVO prjct) {
		
		return menuManageDAO.insertPrjctSignUp(prjct);
	}

	@Override
	public List<PrjctVO> retrievePrjctList(String schId) {
		
		return menuManageDAO.selectPrjctList(schId);
	}

	@Override
	public int insertGenSite(GenSiteVO genSite) {
		
		return menuManageDAO.insertGenSite(genSite);
	}

	@Override
	public int insertSchLogo(SchLogoVO schLogo) {
		
		return menuManageDAO.insertSchLogo(schLogo);
	}

	@Override
	public int insertGenMainImg(GenMainImgVO genMainImg) {
		
		return menuManageDAO.insertGenMainImg(genMainImg);
	}

	@Override
	public int insertGenAlertBrd(GenAlertBrdVO genAlertBrd) {
		
		return menuManageDAO.insertGenAlertBrd(genAlertBrd);
	}

	@Override
	public int insertGenFooter(GenFooterVO genFooter) {
		
		return menuManageDAO.insertGenFooter(genFooter);
	}

	@Override
	public int insertGenCald(GenCaldVO genCald) {
		
		return menuManageDAO.insertGenCald(genCald);
	}

	
	

}
