package kr.or.ddit.school.manager.my.question.list.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.my.question.list.dao.MyQuestionDAO;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.PagingVO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MyQuestionServiceImpl implements MyQuestionService {

	@Inject
	private MyQuestionDAO myQuestionDAO;

	@Override
	public List<MyQuestionVO> selectMyQuestionList(PagingVO<MyQuestionVO> pagingVO) {

		return myQuestionDAO.selectMyQuestionList(pagingVO);
	}

	@Override
	public int retrieveMyQuestionCount(PagingVO<MyQuestionVO> pagingVO) {

		return myQuestionDAO.selectTotalRecord(pagingVO);
	}

	@Override
	public MyQuestionVO selectMyQuestionDetail(int otoBrdNum) {
		MyQuestionVO myQuestion = myQuestionDAO.selectMyQuestionDetail(otoBrdNum);
		return myQuestion;
	}

	@Override
	public ServiceResult insertMyQuestion(MyQuestionVO myQuestionVO) {
		int rowcnt = myQuestionDAO.insertMyQuestion(myQuestionVO);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult updateMyQuestion(MyQuestionVO myQuestionVO) {
		int rowcnt = myQuestionDAO.updateMyQuestion(myQuestionVO);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult deleteMyQuestion(Integer otoBrdNum) {
		int rowcnt = myQuestionDAO.deleteMyQuestion(otoBrdNum);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public List<MyQuestionVO> selectOtoList(PagingVO<MyQuestionVO> pagingVO) {
		int totalRecord = myQuestionDAO.selectTotalRecordForOp(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		return myQuestionDAO.selectOtoList(pagingVO);
	}

	@Override
	public ServiceResult updateStatus(MyQuestionVO myQuestionVO) {
		int rowcnt = myQuestionDAO.updateStatus(myQuestionVO);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}



}
