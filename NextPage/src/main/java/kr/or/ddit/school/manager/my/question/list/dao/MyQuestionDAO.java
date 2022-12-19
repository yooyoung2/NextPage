package kr.or.ddit.school.manager.my.question.list.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.PagingVO;

/**
 *	 1:1 게시판(CRUD) 용 Persistence Layer
 *
 */
@Mapper
public interface MyQuestionDAO {
	/*이유영- 1:1 게시판 리스트*/
	public List<MyQuestionVO> selectMyQuestionList(PagingVO<MyQuestionVO> pagingVO);
	public int selectTotalRecord(PagingVO<MyQuestionVO> pagingVO);
	/*이유영- 1:1 게시물 상세보기 */
	public MyQuestionVO selectMyQuestionDetail(int otoBrdNum);
	/*이유영- 1:1 게시물 추가 */
	public int insertMyQuestion(MyQuestionVO myQuestionVO);
	/*이유영- 1:1 게시물 수정*/
	public int updateMyQuestion(MyQuestionVO myQuestionVO);
	/*이유영- 1:1 게시물 삭제 */
	public int deleteMyQuestion(Integer otoBrdNum);

	// 구지현 관리자용 문의 전체목록조회
	public List<MyQuestionVO> selectOtoList(PagingVO<MyQuestionVO> pagingVO);
	public int selectTotalRecordForOp(PagingVO<MyQuestionVO> pagingVO);

	//진행상태변경
	public int updateStatus(MyQuestionVO myQuestionVO);

}
