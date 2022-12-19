package kr.or.ddit.generation.options.board.widget.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.GenBrdWdgtVO;
import kr.or.ddit.vo.GenLkLstVO;


/**
 * 제너레이팅 사이트 게시판위젯
 * 구지현
 * @author PC-06
 *
 */

@Mapper
public interface BoardWidgetDAO {

	/**
	 * 게시판 정보 불러오기 - 2개짜리 목록형 위젯 오른쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectRtBrdWgt(String schId);



	/**
	 * 게시판 정보 불러오기 - 2개짜리 목록형 위젯 왼쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectLtBrdWgt(String schId);


	/**
	 * 게시판 정보 불러오기 - 1개짜리 목록형 위젯
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectOnebrd(String schId);


	/**
	 * 게시판 정보 불러오기 - 1개짜리 이미지형 위젯
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectOneImg(String schId);


	/**
	 * 게시판 정보 불러오기 - 2개짜리 이미지형 위젯 오른쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectRtImgWgt(String schId);

	/**
	 * 게시판 정보 불러오기 - 2개짜리 이미지형 위젯 왼쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectLtImgWgt(String schId);



	/**
	 * 게시판 정보 불러오기 - 2개짜리 비디오형 위젯 왼쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectLtVdWgt(String schId);

	/**
	 * 게시판 정보 불러오기 - 2개짜리 비디오형 위젯 오른쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectRtVdWgt(String schId);




	/**
	 * 게시판 정보 불러오기 - 3개짜리 비디오형 위젯 왼쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> triLtVdWgt(String schId);

	/**
	 * 게시판 정보 불러오기 - 3개짜리 비디오형 위젯 중간
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> triMdVdWgt(String schId);
	/**
	 * 게시판 정보 불러오기 - 3개짜리 비디오형 위젯 오른쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> triRtVdWgt(String schId);


	/**
	 * 게시판 정보 불러오기 - 알림판
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> noticeBrd(String schId);


	/**
	 * 식단
	 * @param schId
	 * @return
	 */
	public GenBrdWdgtVO dietBrd(String schId);

	/**
	 * 하단배너
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO>underBanner(String schId);

	/**
	 * 링크리스트
	 * @param schId
	 * @return
	 */
	public List<GenLkLstVO> selectLinkList(String schId);

	/**
	 * 캘린더
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> selectCalendar(String schId);
}
