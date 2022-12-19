package kr.or.ddit.generation.website.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.operator.history.stastics.dao.VisitLogDAO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SchLogoVO;

public class GeneratingMainDAOImpl implements GeneratingMainDAO {

	WebApplicationContext context = 
			ContextLoader.getCurrentWebApplicationContext();
	
	
	SqlSessionFactory sql = (SqlSessionFactory) context.getBean( "sqlSessionFactory" );
	
	@Override
	public List<GeneratingMainVO> getOptionsURL(String schId) {
		
		try(
				SqlSession sqlSession = sql.openSession( true );  
			){
			GeneratingMainDAO mapper = sqlSession.getMapper( GeneratingMainDAO.class );
			return mapper.getOptionsURL( schId );
		}
		
		
	}

	@Override
	public List<GeneratingMainVO> selectAll() {
		
		try(
				SqlSession sqlSession = sql.openSession( true );  
			){
			GeneratingMainDAO mapper = sqlSession.getMapper( GeneratingMainDAO.class );
			return mapper.selectAll();
		}
	}

	@Override
	public GeneratingMainVO selectSchoolByUri( String address ) {
		try(
				SqlSession sqlSession = sql.openSession( true );  
			){
			GeneratingMainDAO mapper = sqlSession.getMapper( GeneratingMainDAO.class );
			return mapper.selectSchoolByUri( address );
		}
	}

	@Override
	public ProjectVO selectProjectInfo(String id) {
		try(
				SqlSession sqlSession = sql.openSession( true );  
			){
			GeneratingMainDAO mapper = sqlSession.getMapper( GeneratingMainDAO.class );
			return mapper.selectProjectInfo( id );
		}
	}

	@Override
	public GeneratingMainVO selectSchoolByBrdNum(String brdNum) {
		try(
				SqlSession sqlSession = sql.openSession( true );  
			){
			GeneratingMainDAO mapper = sqlSession.getMapper( GeneratingMainDAO.class );
			return mapper.selectSchoolByBrdNum( brdNum );
		}
	}

	@Override
	public List<GenMainImgVO> getMainImages(String schId) {
		try(
				SqlSession sqlSession = sql.openSession( true );  
			){
			GeneratingMainDAO mapper = sqlSession.getMapper( GeneratingMainDAO.class );
			return mapper.getMainImages( schId );
		}
	}

	@Override
	public SchLogoVO getLogoImage(String schId) {
		try(
				SqlSession sqlSession = sql.openSession( true );  
			){
			GeneratingMainDAO mapper = sqlSession.getMapper( GeneratingMainDAO.class );
			return mapper.getLogoImage( schId );
		}
	}

}
