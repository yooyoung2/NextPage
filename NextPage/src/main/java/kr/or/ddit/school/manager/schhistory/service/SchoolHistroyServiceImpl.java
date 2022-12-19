package kr.or.ddit.school.manager.schhistory.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.common.exception.UserNotFoundException;
import kr.or.ddit.school.manager.schhistory.dao.SchoolHistoryDAO;
import kr.or.ddit.vo.SchMemberFileListVO;
import kr.or.ddit.vo.SchMemberFileVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolHistoryVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SchoolHistroyServiceImpl implements SchoolHistroyService  {
	@Inject
	private SchoolHistoryDAO dao;

	
	
	
	@Override
	public List<SchoolHistoryVO> selectHistList(String schId) {
		return dao.selectHistList(schId);
		
		
	}
	
	
	@Override
	public ServiceResult insertHist(SchoolHistoryVO member) {
		ServiceResult result = null;
		
			int rowcnt = dao.insertHist(member);
			
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		
		return result;
	}


	@Override
	public int deleteHist(String schId) {
		return dao.deleteHist(schId);
	}


	@Override
	public List<SchoolHistoryVO> selectSchHistoryList(String schId) {
		
		return dao.selectSchHistoryList(schId);
	}
	

	

}
