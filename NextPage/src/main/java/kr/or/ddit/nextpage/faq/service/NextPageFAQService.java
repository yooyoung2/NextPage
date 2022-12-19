package kr.or.ddit.nextpage.faq.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.FaqVO;
import kr.or.ddit.vo.PagingVO;

/**
 * 네스트페이지 FAQ CRUD
 *
 * 구지현
 *
 */


public interface NextPageFAQService {

	/** FAQ 등록
	 * @param FaqVO
	 * @return
	 */
	public ServiceResult createFaq(FaqVO faq);

	/** FAQ 파일 등록
	 * @param FaqVO
	 * @return 성공 : 1 실패 : 0
	 */
	public int insertFAQBoardFile(FaqVO faq);
	
	/**
	 * FAQ 상세 조회
	 * @param faqId
	 * @return 존재하지 않는다면, null 반환
	 */
	public FaqVO retrieveFaq(Integer faqId);



	/**
	 * FAQ 목록 조회
	 * @param pagingVO TODO
	 * @return size==0 테이블 empty
	 */
	public List<FaqVO> retrieveFaqList(PagingVO<FaqVO> pagingVO);

	/**
	 * FAQ 수정
	 * @param FaqVO
	 * @return
	 */
	public ServiceResult modifyFaq(FaqVO faq);

	/**
	 * FAQ 삭제
	 * @param faqId
	 * @return
	 */
	public ServiceResult  deleteFaq(FaqVO faq);


}
