package kr.or.ddit.nextpage.faq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.FaqVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchGretngVO;

/**
 * 네스트페이지 FAQ CRUD
 *
 * 구지현
 *
 */

@Mapper
public interface NextPageFAQDAO {

	/** FAQ 등록
	 * @param FaqVO
	 * @return 성공 : 1 실패 : 0
	 */
	public int insertFAQBoard(FaqVO faq);
	
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
	public FaqVO selectFaq(Integer faqId);

	/**
	 * 페이징 처리를 위한 totalRecord 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO pagingVO);

	/**
	 * FAQ 목록 조회
	 * @param pagingVO TODO
	 * @return size==0 테이블 empty
	 */
	public List<FaqVO> selectFAQList(PagingVO<FaqVO> pagingVO);

	/**
	 * FAQ 수정
	 * @param FaqVO
	 * @return 성공 : 1 실패 : 0
	 */
	public int updateFaq(FaqVO faq);

	/**
	 * FAQ 삭제
	 * @param faqId
	 * @return 성공 : 1 실패 : 0
	 */
	public int deleteFaq(@Param("faqId") Integer faqId);
	

	
}
