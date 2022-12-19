package kr.or.ddit.nextpage.member.center.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.NoticeBoardVO;
import kr.or.ddit.vo.PagingVO;

/**
 * 넥스트페이지 공지사항 CRUD
 * 페이징처리
 * 구지현
 * @author PC-06
 *
 */


@Mapper
public interface NextPageMemberCenterDAO {


	/**
	 * 페이징처리 된 공지사항 리스트 조회
	 * @param pagingVO
	 * @return
	 */
	public List<NoticeBoardVO> selectNotiBoardList(PagingVO<NoticeBoardVO> pagingVO);

	/**
	 * 페이징 처리를 위한 totalRecord 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO pagingVO);


	/**
	 * 공지사항 작성
	 * @param notiBoard
	 * @return
	 */
	public Integer insertNotiBoard(NoticeBoardVO notiBoard);
	/**
	 * 공지사항 파일 삽입
	 * @param notiBoard
	 * @return
	 */
	public Integer insertNotiBoardFile(NoticeBoardVO notiBoard);
	/**
	 * 공지사항 상세페이지조회
	 * @param notisNum 공지사항 글번호
	 * @return 존재하지 않는다면, null 반환
	 */
	public NoticeBoardVO selectNotiBoard(int notisNum);


	/**
	 * 공지사항 수정
	 * @param
	 * @return 성공 : 1 실패 : 0
	 */
	public int updateNotiBoard(NoticeBoardVO noti);
	/**
	 * 공지사항 삭제
	 * @param
	 * @return 성공 : 1 실패 : 0
	 */
	public int deleteNotiBoard(@Param("notisNum") Integer notisNum);



}
