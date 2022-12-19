package kr.or.ddit.school.manager.my.question.list.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.PagingVO;

public interface MyQuestionService {
	/*이유영- 1:1 게시판 리스트*/
	public List<MyQuestionVO> selectMyQuestionList(PagingVO<MyQuestionVO> pagingVO);
	public int retrieveMyQuestionCount(PagingVO<MyQuestionVO> pagingVO);
	/*이유영- 1:1 게시물 상세보기 */
	public MyQuestionVO selectMyQuestionDetail(int otoBrdNum);
	/*이유영- 1:1 게시물 추가 */
	public ServiceResult insertMyQuestion(MyQuestionVO myQuestionVO);
	/*이유영- 1:1 게시물 수정*/
	public ServiceResult updateMyQuestion(MyQuestionVO myQuestionVO);
	/*이유영- 1:1 게시물 삭제 */
	public ServiceResult deleteMyQuestion(Integer otoBrdNum);

	// 구지현 관리자용 문의 전체목록조회
	public List<MyQuestionVO> selectOtoList(PagingVO<MyQuestionVO> pagingVO);

	//진행상황변경
	public ServiceResult updateStatus(MyQuestionVO myQuestionVO);
}
