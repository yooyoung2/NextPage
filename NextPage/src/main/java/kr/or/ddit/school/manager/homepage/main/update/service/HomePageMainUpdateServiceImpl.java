package kr.or.ddit.school.manager.homepage.main.update.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.school.manager.homepage.main.update.dao.HomePageMainUpdateDAO;
import kr.or.ddit.vo.BnrLkInfoVO;
import kr.or.ddit.vo.BoardWidgetVO;
import kr.or.ddit.vo.GenAlertBrdVO;
import kr.or.ddit.vo.GenBnrVO;
import kr.or.ddit.vo.GenCaldVO;
import kr.or.ddit.vo.GenFooterVO;
import kr.or.ddit.vo.GenLkLstVO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.LkLstIconVO;
import kr.or.ddit.vo.SchLogoVO;

@Service
public class HomePageMainUpdateServiceImpl implements HomePageMainUpdateService {

	@Inject
	public HomePageMainUpdateDAO homePageMainUpdateDAO;
	
	@Override
	public List<BoardWidgetVO> retrieveBrdWdgtList(String schId) {
		
		return homePageMainUpdateDAO.selectBrdWdgtList(schId);
	}

	@Override
	public int retrieveBrdWdId(String schId) {
		
		return homePageMainUpdateDAO.selectBrdWdId(schId);
	}

	@Override
	public int deleteListBrdDelete(String schId) {
		
		return homePageMainUpdateDAO.deleteListBrdDelete(schId);
	}



	@Override
	public int insertListBrd(BoardWidgetVO boardWidget) {
		
		return homePageMainUpdateDAO.insertListBrd(boardWidget);
	}



	@Override
	public BoardWidgetVO retrieveBrdWdgt(String schId) {
		
		return homePageMainUpdateDAO.selectBrdWdgt(schId);
	}



	@Override
	public int deleteBrdDelete(String schId) {
		
		return homePageMainUpdateDAO.deleteBrdDelete(schId);
	}



	@Override
	public BoardWidgetVO retrieveImgBrdWdgt(String schId) {
		
		return homePageMainUpdateDAO.selectImgBrdWdgt(schId);
	}



	@Override
	public List<BoardWidgetVO> retrieveImgBrdWdgtList(String schId) {
		
		return homePageMainUpdateDAO.selectImgBrdWdgtList(schId);
	}



	@Override
	public int deleteImgDelete(String schId) {
		
		return homePageMainUpdateDAO.deleteImgDelete(schId);
	}



	@Override
	public int deleteImgListDelete(String schId) {
		
		return homePageMainUpdateDAO.deleteImgListDelete(schId);
	}

	@Override
	public List<BoardWidgetVO> retrieveVideoBrdWdgt(String schId) {
		
		return homePageMainUpdateDAO.selectVideoBrdWdgt(schId) ;
	}

	@Override
	public List<BoardWidgetVO> retrieveVideoBrdWdgtList(String schId) {
		
		return homePageMainUpdateDAO.selectVideoBrdWdgtList(schId) ;
	}

	@Override
	public List<GenAlertBrdVO> retrieveGenAlertBrdList(String schId) {
		
		return homePageMainUpdateDAO.selectGenAlertBrdList(schId);
	}

	@Override
	public int deleteGenAlertBrd(String schId) {
		
		return homePageMainUpdateDAO.deleteGenAlertBrd(schId);
	}

	@Override
	public int insertGenAlertBrd(GenAlertBrdVO genAlertBrd) {
		
		return homePageMainUpdateDAO.insertGenAlertBrd(genAlertBrd);
	}

	@Override
	public GenFooterVO retrieveGenFooter(String schId) {
		
		return homePageMainUpdateDAO.selectGenFooter(schId);
	}

	@Override
	public int deleteGenFooter(String schId) {
		
		return homePageMainUpdateDAO.deleteGenFooter(schId) ;
	}

	@Override
	public int insertGenFooter(GenFooterVO genFooter) {
		
		return homePageMainUpdateDAO.insertGenFooter(genFooter) ;
	}

	@Override
	public List<BnrLkInfoVO> retrieveBnrLkInfoList() {

		return homePageMainUpdateDAO.selectBnrLkInfoList() ;
	}

	@Override
	public List<GenBnrVO> retrieveGenBnrList(String schId) {
		
		return homePageMainUpdateDAO.selectGenBnrList(schId);
	}

	@Override
	public int deleteGenBnr(String schId) {
		
		return homePageMainUpdateDAO.deleteGenBnr(schId) ;
	}
	
	@Override
	public int insertGenBnr(GenBnrVO genBnr) {
		
		return homePageMainUpdateDAO.insertGenBnr(genBnr);
	}

	@Override
	public List<GenMainImgVO> retrieveGenMainImgList(String schId) {
		
		return homePageMainUpdateDAO.selectGenMainImgList(schId);
	}

	@Override
	public List<LkLstIconVO> retrieveLkLstIconList() {
		
		return homePageMainUpdateDAO.selectLkLstIconList();
	}

	@Override
	public List<GenLkLstVO> retrieveGenLkLstList(String schId) {
		
		return homePageMainUpdateDAO.selectGenLkLstList(schId);
	}

	@Override
	public int deleteGenLkLst(String schId) {

		return homePageMainUpdateDAO.deleteGenLkLst(schId);
	}

	@Override
	public int insertGenLkLst(GenLkLstVO genLkLst) {
		
		return homePageMainUpdateDAO.insertGenLkLst(genLkLst);
	}

	@Override
	public List<GenCaldVO> retrieveGenCaldList(String schId) {
		
		return homePageMainUpdateDAO.selectGenCaldList(schId);
	}

	
	@Override
	public int deleteGenCald(String schId) {
		
		return homePageMainUpdateDAO.deleteGenCald(schId);
	}
	 
	
	
	@Override
	public int insertGenCald(GenCaldVO genCald) {
	
		return homePageMainUpdateDAO.insertGenCald(genCald);
	}

	@Override
	public int deleteVideoDelete(String schId) {
		
		return homePageMainUpdateDAO.deleteVideoDelete(schId);
	}

	@Override
	public int deleteVideoListDelete(String schId) {
	
		return homePageMainUpdateDAO.deleteVideoListDelete(schId);
	}

	@Override
	public SchLogoVO retrieveSchLogo(String schId) {

		return homePageMainUpdateDAO.selectSchLogo(schId);
	}

	@Override
	public int deleteSchLogo(String schId) {
		
		return homePageMainUpdateDAO.deleteSchLogo(schId);
	}

	@Override
	public int insertSchLogo(SchLogoVO schLogo) {
		
		return homePageMainUpdateDAO.insertSchLogo(schLogo);
	}

	@Override
	public int deleteMainImage(String schId) {

		return homePageMainUpdateDAO.deleteMainImage(schId);
	}

	@Override
	public int insertMainImage(GenMainImgVO genMainImg) {

		return homePageMainUpdateDAO.insertMainImage(genMainImg);
	}

	

	



}
