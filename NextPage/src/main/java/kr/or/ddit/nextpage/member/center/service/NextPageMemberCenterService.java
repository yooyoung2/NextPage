package kr.or.ddit.nextpage.member.center.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.NoticeBoardVO;
import kr.or.ddit.vo.PagingVO;

public interface NextPageMemberCenterService {
	/**
	 * 넥스트페이지 공지사항리스트 조회
	 * 페이징처리
	 * 구지현
	 * @param pagingVO
	 * @return
	 */
	public List<NoticeBoardVO> selectNotiBoardList(PagingVO<NoticeBoardVO> pagingVO);
//	public int retrieveGenBoardCount(PagingVO pagingVO); //페이징처리

	/**
	 * 넥스트페이지 공지사항 글작성
	 * @param notiBoard
	 * @return
	 */
	public ServiceResult insertNotiBoard(NoticeBoardVO notiBoard);
	/**
	 * 공지사항 파일 삽입
	 * @param notiBoard
	 * @return
	 */
	public Integer insertNotiBoardFile(NoticeBoardVO notiBoard);
	/**
	 * 공지사항 상세보기
	 * @param notisNum
	 * @return
	 */

	public NoticeBoardVO retrieveNotiboard(Integer notisNum);

	/**
	 * 공지사항 수정
	 * @param noti
	 * @return
	 */
	public ServiceResult modifyNotiBoard(NoticeBoardVO noti);

	/**
	 * 공지사항 삭제
	 * @return
	 */
	public ServiceResult removeNotiBoard(Integer notisNum);


}
