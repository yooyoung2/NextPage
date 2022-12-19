package kr.or.ddit.school.manager.board.manage.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.PagingVO;

public interface BoardManageService {
	/* 학교관리자-게시판관리-게시판 목록 (이유영)*/
	public List<GenBoardVO> selectGenBoardtList(PagingVO<GenBoardVO> pagingVO ); 
	public int retrieveGenBoardCount(PagingVO pagingVO); //페이징처리
	/* 학교관리자-게시판관리-게시판 추가(이유영)*/
	public Integer insertGenBoard(GenBoardVO genBoard);
	/* 학교관리자-게시판관리-게시판 삭제(이유영)*/
	public ServiceResult deleteGenBoard(int brdNum);
	/* 이유영 - 게시판 수정 전 게시판 상태 조회 */
	public GenBoardVO selectGenBoard(int brdNum);
	/* 이유영 - 게시판 수정 */
	public ServiceResult updateGenboard(GenBoardVO genBoard);
	
	/** 작성자 : 방형준 (22.11.14)
	 * 
	 *  메뉴관리(셀렉터 - 옵션)에서 사용할  데이터 출력
	 * 
	 * @param schId
	 * @return
	 */
	public List<GenBoardVO> retrieveGenBoardOptionList(String schId);
	
	/** 작성자 : 방형준(22.12.01)
	 * 
	 *  현재 홈페이지에서 사용중인 게시판 정보 취득 
	 *  -> 슬롯에서 링크정보를 연결시켜주기위한 자료
	 * 
	 * @param genBoard
	 * @return
	 */
	public List<GenBoardVO> retrieveUseBoardList(GenBoardVO genBoard);
}
