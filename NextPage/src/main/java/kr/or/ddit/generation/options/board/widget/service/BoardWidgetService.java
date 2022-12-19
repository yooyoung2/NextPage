package kr.or.ddit.generation.options.board.widget.service;

import java.util.List;

import kr.or.ddit.vo.GenBrdWdgtVO;
import kr.or.ddit.vo.GenLkLstVO;

public interface BoardWidgetService {


	/**
	 * 게시판 정보 불러오기 - 2개짜리 목록형, 오른쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> brdWgtRtView(String schId);

	/**
	 * 게시판 정보 불러오기 - 2개짜리 목록형, 왼쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> brdWgtLtView(String schId);


	/**
	 * 게시판 정보 불러오기 - 1개짜리 목록형
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> brdWgtOneView(String schId);


	/**
	 * 게시판 정보 불러오기 - 1개짜리 이미지형
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> brdWgtOneImg(String schId);



	/**
	 * 게시판 정보 불러오기 - 2개짜리 이미지형, 오른쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> imgWgtRtView(String schId);

	/**
	 * 게시판 정보 불러오기 - 2개짜리 이미지형, 왼쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> imgWgtLtView(String schId);



	/**
	 * 게시판 정보 불러오기 - 2개짜리 비디오형, 왼쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> vdWgtLtView(String schId);

	/**
	 * 게시판 정보 불러오기 - 2개짜리 비디오형, 오른쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> vdWgtRtView(String schId);



	/**
	 * 게시판 정보 불러오기 - 3개짜리 비디오형, 왼쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> triVdWgtLt(String schId);

	/**
	 * 게시판 정보 불러오기 - 3개짜리 비디오형, 중간
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> triVdWgtMd(String schId);

	/**
	 * 게시판 정보 불러오기 - 3개짜리 비디오형, 오른쪽
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> triVdWgtRt(String schId);


	/**
	 * 게시판 정보 불러오기 - 알림판
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> noticeView(String schId);


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
	public List<GenBrdWdgtVO> underBannerList(String schId);

	/**
	 * 링크리스트
	 * @param schId
	 * @return
	 */
	public List<GenLkLstVO> linkListView(String schId);

	/**
	 * 캘린더
	 * @param schId
	 * @return
	 */
	public List<GenBrdWdgtVO> calendarView(String schId);


}
