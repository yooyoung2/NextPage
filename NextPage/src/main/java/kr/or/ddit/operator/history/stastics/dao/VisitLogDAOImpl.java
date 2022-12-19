package kr.or.ddit.operator.history.stastics.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.vo.VisitLogVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/통계분석 
 * @author PC-04
 *
 */
public class VisitLogDAOImpl implements VisitLogDAO {

	WebApplicationContext context = 
			ContextLoader.getCurrentWebApplicationContext();
	
	
	SqlSessionFactory sql = (SqlSessionFactory) context.getBean( "sqlSessionFactory" );
	
	@Override
	public int insertVisitor(VisitLogVO vo) {
		// TODO Auto-generated method stub
		
		try(
				SqlSession sqlSession = sql.openSession( true );  
			){
			VisitLogDAO mapper = sqlSession.getMapper( VisitLogDAO.class );
			return mapper.insertVisitor( vo );
		}
		
	}

}
