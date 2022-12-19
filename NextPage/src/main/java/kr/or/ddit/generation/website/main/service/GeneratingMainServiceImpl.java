package kr.or.ddit.generation.website.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.generation.website.main.dao.GeneratingMainDAO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SchLogoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GeneratingMainServiceImpl implements GeneratingMainService {

	@Inject
	GeneratingMainDAO dao;
	
	@Override
	public List<GeneratingMainVO> getOptionsURL( String schId ) {
		// TODO Auto-generated method stub
		
		List<GeneratingMainVO> data = dao.getOptionsURL( schId );
		
		if( !data.isEmpty() && data != null ) {
			log.info( "======options의 url 매핑정보들 가져오기 성공======" );
			for( GeneratingMainVO vo : data ) {
				log.info( "MENU NAME : " + vo.getMenuNm() );
				log.info( "LINK : " + vo.getMenuLink() );
			}
			return data;
		}else {
			return null;
		}
		
	}

	@Override
	public List<GeneratingMainVO> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public GeneratingMainVO selectSchoolByUri( String address ) {
		// TODO Auto-generated method stub
		return dao.selectSchoolByUri  ( address );
	}

	@Override
	public ProjectVO selectProjectInfo(String id) {
		
		ProjectVO pVo = dao.selectProjectInfo( id );
		
		if( pVo == null ) {
			log.info( "ProjectVO pVo is NULL" );
		}else {
			log.info( "ProjectVO pVo NOT NULL" );
		}
		
		return pVo;
	}

	@Override
	public GeneratingMainVO selectSchoolByBrdNum(String brdNum) {
		// TODO Auto-generated method stub
		return dao.selectSchoolByBrdNum( brdNum ); 
	}

	/**
	 * 작성자 : 최현우
	 * DB에 저장되어있는 GENERATING MAIN 이미지들을 가져옴
	 */
	@Override
	public List<GenMainImgVO> getMainImages(String schId) {
		// TODO Auto-generated method stub
		return dao.getMainImages( schId );
	}

	/**
	 * 작성자 : 최현우
	 * @param schId
	 * @return SchLogoVO ( 메인 로고 이미지 )
	 */
	@Override
	public SchLogoVO getLogoImage(String schId) {
		// TODO Auto-generated method stub
		if( dao.getLogoImage( schId ) == null ) {
			log.debug( "dao.getLogImage( schId ) : null"); 
			return null;
		}else {
			return dao.getLogoImage( schId );			
		}
	}

}
