package kr.or.ddit.school.manager.board.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.generation.options.board.vo.BoardVO;
import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.PagingVO;
/**
 * 게시판 관리(CRUD) 용 Persistence Layer
 *
 */
@Mapper
public interface BoardManageDAO {
	/* 이유영- 게시판 리스트 */
	public List<GenBoardVO> selectGenBoardList(PagingVO<GenBoardVO> pagingVO);
	public int selectTotalRecord(PagingVO pagingVO);
	
	/* 이유영- 게시판 추가 */
	public Integer insertGenBoard(GenBoardVO genBoard);
	
	/* 이유영 - 게시판 삭제 */
	public int deleteGenBoard(int brdNum);
	
	/* 이유영 - 게시판 수정 전 게시판 상태 조회 */
	public GenBoardVO selectGenBoard(int brdNum);
	
	/* 이유영 - 게시판 수정 */
	public int updateGenBoard(GenBoardVO genBoard);
	
	/** 작성자 : 방형준(22.11.14)
	 *  
	 *  메뉴관리(셀렉터 - 옵션)에서 사용할  데이터 출력
	 * @param schId
	 * @return
	 */
	public List<GenBoardVO> selectGenBoardOptionList(String schId);
	
	/** 작성자 : 방형준(22.12.01)
	 * 
	 *  현재 홈페이지에서 사용중인 게시판 정보 취득 
	 *  -> 슬롯에서 링크정보를 연결시켜주기위한 자료
	 * 
	 * @param genBoard
	 * @return
	 */
	public List<GenBoardVO> selectUseBoardList(GenBoardVO genBoard);
}
