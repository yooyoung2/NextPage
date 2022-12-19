package kr.or.ddit.school.manager.board.manage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.board.manage.dao.BoardManageDAO;
import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class BoardManageServiceImpl implements BoardManageService {
	
	@Inject
	private BoardManageDAO boardManageDAO;

	@Override
	public List<GenBoardVO> selectGenBoardtList(PagingVO<GenBoardVO> pagingVO) {
		
		return boardManageDAO.selectGenBoardList(pagingVO);
	}

	@Override
	public int retrieveGenBoardCount(PagingVO pagingVO) {
		
		return boardManageDAO.selectTotalRecord(pagingVO);
	}

	@Override
	public Integer insertGenBoard(GenBoardVO genBoard) {
		int rowcnt = boardManageDAO.insertGenBoard(genBoard); //성공여부만 체크함.
		return rowcnt > 0 ? genBoard.getBrdNum() : -1 ;
		//log.info("insert service 후 글번호 : {}", genBoard.getBrdNum()); //insert후 값
		//return genBoard.getBrdNum();
	}

	@Override
	public ServiceResult deleteGenBoard(int brdNum) {
		int rowcnt = boardManageDAO.deleteGenBoard(brdNum); //1
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public GenBoardVO selectGenBoard(int brdNum) {
		GenBoardVO genBoard = boardManageDAO.selectGenBoard(brdNum);
	
		return genBoard;
	}

	@Override
	public ServiceResult updateGenboard(GenBoardVO genBoard) {
		int rowcnt = boardManageDAO.updateGenBoard(genBoard); //1
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
 
	@Override
	public List<GenBoardVO> retrieveGenBoardOptionList(String schId) {
		
		return boardManageDAO.selectGenBoardOptionList(schId);
	}

	@Override
	public List<GenBoardVO> retrieveUseBoardList(GenBoardVO genBoard) {
		
		return boardManageDAO.selectUseBoardList(genBoard);
	}
	
	
}
