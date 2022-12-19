package kr.or.ddit.school.manager.content.manage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.school.manager.board.manage.controller.BoardManageController;
import kr.or.ddit.school.manager.content.manage.dao.ContentManageDAO;
import kr.or.ddit.vo.ContentVO;
import kr.or.ddit.vo.Criteria;
import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.GenCntntVO;
import kr.or.ddit.vo.GeneratingMainVO;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Log4j2
@Service
public class ContentManageServiceImpl implements ContentManageService {

	@Inject
	public ContentManageDAO contentMangeDAO;
	
	@Override
	public List<GenCntntVO> retrieveGenCntntOptionList(String schId) {
		
		return contentMangeDAO.selectGenCntntOptionList(schId);
	}

	@Override
	public Integer insertContent(ContentVO content) {
		int rowcnt = contentMangeDAO.insertContent( content );
		//log.info("시퀀스 값 :  {}", content.getCntntsId());
		return rowcnt > 0 ? content.getCntntsId() : 0 ;
	}
	
	@Override
	public List<ContentVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return contentMangeDAO.getList( cri );
	}

	@Override
	public int getTotal( String schId ) {
		// TODO Auto-generated method stub
		return contentMangeDAO.getTotal( schId );
	}

	@Override
	public List<GeneratingMainVO> getMenuList( String schId ) {
		// TODO Auto-generated method stub
		return contentMangeDAO.getMenuList( schId );
	}

	@Override
	public ContentVO getContent(String cntntId) {
		// TODO Auto-generated method stub
		return contentMangeDAO.getContent( cntntId );
	}

	@Override
	public int updateContent(ContentVO content) {
		// TODO Auto-generated method stub
		return contentMangeDAO.updateContent( content );
	}

	@Override
	public int delContent(String cntntId) {
		
		return contentMangeDAO.delContent(cntntId);
	}



}
