package kr.or.ddit.school.manager.homepage.main.update.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BnrLkInfoVO;
import kr.or.ddit.vo.BoardWidgetVO;
import kr.or.ddit.vo.BrdWdgtVO;
import kr.or.ddit.vo.GenAlertBrdVO;
import kr.or.ddit.vo.GenBnrVO;
import kr.or.ddit.vo.GenCaldVO;
import kr.or.ddit.vo.GenFooterVO;
import kr.or.ddit.vo.GenLkLstVO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.LkLstIconVO;
import kr.or.ddit.vo.SchLogoVO;

@Mapper
public interface HomePageMainUpdateDAO {
	
	/**	작성자 : 방형준(22.12.01) 
	 * 
	 * 입력한 아이디의 현재 위젯에 적용중인 일반게시판2의 목록조회 
	 * 
	 * @param schId
	 * @return
	 */
	public List<BoardWidgetVO> selectBrdWdgtList(String schId);
		
	/** 작성자 : 방형준(22.12.01)
	 * 	학교아이디를 입력받아 현재 학교의 위젯번호를 출력한다.
	 * 
	 * @param schId
	 * @return
	 */
	public int selectBrdWdId(String schId);
	
	/** 작성자 : 방형준(22.12.01)
	 *  위젯정보 수정을 위한 데이터 삭제(일반게시판 1x2)
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteListBrdDelete(String schId);
	
	/** 작성자 : 방형준(22.12.01)
	 * 	위젯리스트중 게시판위젯(1x2)데이터 insert
	 * 
	 * @param boardWidget
	 * @return
	 */
	public int insertListBrd(BoardWidgetVO boardWidget);
	
	/**	작성자 : 방형준(22.12.02) 
	 * 
	 * 입력한 아이디의 현재 위젯에 적용중인 일반게시판1의 목록조회 
	 * 
	 * @param schId
	 * @return
	 */
	public BoardWidgetVO selectBrdWdgt(String schId);
	
	/** 작성자 : 방형준(22.12.02)
	 * 	위젯정보 수정을 위한 데이터 삭제(일반게시판 1x1)
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteBrdDelete(String schId);
	
	/** 작성자 : 방형준(22.12.02)
	 * 	
	 * 	이미지 게시판(1x1)의 현재 적용중인 위젯정보 검색	
	 * 
	 * @param schId
	 * @return
	 */
	public BoardWidgetVO selectImgBrdWdgt(String schId);
	
	
	/** 작성자 : 방형준(22.12.02)
	 * 	
	 * 	이미지 게시판(1x2)의 현재 적용중인 위젯정보 검색	
	 * 
	 * @param schId
	 * @return
	 */
	public List<BoardWidgetVO> selectImgBrdWdgtList(String schId);
	
	/** 작성자 : 방형준(22.12.02)
	 * 	위젯정보 수정을 위한 데이터 삭제(이미지게시판 1x1)
	 * 
	 * @param schId
	 * @return
	 */ 
	public int deleteImgDelete(String schId); 
	
	/** 작성자 : 방형준(22.12.02)
	 * 	위젯정보 수정을 위한 데이터 삭제(이미지게시판 1x2)
	 * 
	 * @param schId
	 * @return
	 */ 
	public int deleteImgListDelete(String schId); 
	
	/** 작성자 : 방형준(22.12.02)
	 * 
	 * 	위젯정보 수정을 위한 데이터 삭제 (동영상게시판 1x2)
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteVideoDelete(String schId);
	
	/** 작성자 : 방형준(22.12.02)
	 * 
	 * 	위젯정보 수정을 위한 데이터 삭제 (동영상게시판 1x3)
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteVideoListDelete(String schId);
	
	/** 작성자 : 방형준(22.12.02)
	 * 
	 * 	현재 적용중인 위젯정보 취득(1x2동영상 게시판)
	 * 
	 * @param schId
	 * @return
	 */
	public List<BoardWidgetVO> selectVideoBrdWdgt(String schId);
	
	/** 작성자 : 방형준(22.12.02)
	 * 
	 * 	현재 적용중인 위젯정보 취득(1x3동영상 게시판)
	 * 
	 * @param schId
	 * @return
	 */
	public List<BoardWidgetVO> selectVideoBrdWdgtList(String schId);
	
	/**	작성자 : 방형준(22.12.02)
	 * 	
	 * 	현재 입력되어 있는 알림판 목록조회
	 * 
	 * @param schId
	 * @return
	 */
	public List<GenAlertBrdVO> selectGenAlertBrdList(String schId);
	
	/** 작성자 : 방형준(22.12.02)
	 * 	현재 입력되어 있는 알림판 정보 삭제(새로 넣기 전 작업)
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteGenAlertBrd(String schId);
	
	/** 작성자 : 방형준(22.12.02)
	 * 
	 * 	알림판정보 insert
	 * 
	 * @param genAlertBrd
	 * @return
	 */
	public int insertGenAlertBrd(GenAlertBrdVO genAlertBrd);
	
	/** 작성자 : 방형준(22.12.03)
	 * 
	 * 	학교아이디를 입력받아 Footer 정보 출력
	 * 
	 * @param schId
	 * @return
	 */
	public GenFooterVO selectGenFooter(String schId);
	
	/** 작성자 : 방형준(22.12.03)
	 * 
	 * 	학교아이디를 입력받아 Footer 정보 삭제
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteGenFooter(String schId);
	
	/** 작성자 : 방형준(22.12.03)
	 * 
	 *  학교 Footer 정보 입력
	 * 
	 * @param genFooter
	 * @return
	 */
	public int insertGenFooter(GenFooterVO genFooter);
	
	/** 작성자 : 방형준(22.12.04)
	 * 
	 * 	배너링크정보 모두 출력.
	 * 
	 * @return
	 */
	public List<BnrLkInfoVO> selectBnrLkInfoList();
	
	/** 작성자 : 방형준(22.12.04)
	 * 
	 * 	id를 입력받아 배너정보를 가져옴.
	 * 
	 * @param schId
	 * @return
	 */
	public List<GenBnrVO> selectGenBnrList(String schId);
	
	/** 작성자 : 방형준(22.12.05)
	 * 
	 * 	학교아이디를 입력받아 배너정보를 모두 삭제한다.
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteGenBnr(String schId);
	
	/** 작성자 : 방형준(22.12.05)
	 * 	
	 * 	배너정보입력
	 * 
	 * @param genBnr
	 * @return
	 */
	public int insertGenBnr(GenBnrVO genBnr);
	
	/** 작성자 : 방형준(22.12.05)
	 * 
	 * 	학교아이디를 입력받아 메인이미지 정보를 취득한다.
	 * 
	 * @param schId
	 * @return
	 */
	public List<GenMainImgVO> selectGenMainImgList(String schId);
	
	/** 작성자 : 방형준(22.12.05)
	 * 	링크위젯 아이콘 목록 출력용
	 * @return
	 */
	public List<LkLstIconVO> selectLkLstIconList();
	
	/** 작성자 : 방형준(22.12.05)
	 * 
	 * 	학교아이디를 입력받아 위젯정보를 취득한다.
	 * 
	 * @param schId
	 * @return
	 */
	public List<GenLkLstVO> selectGenLkLstList(String schId);
	
	/** 작성자 : 방형준(22.12.06)
	 * 
	 *  학교아이디를 입력받아 링크위젯의 정보를 삭제한다.
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteGenLkLst(String schId);
	
	/** 작성자 : 방형준(22.12.06)
	 * 
	 *  입력받은 링크위젯정보를 입력한다.
	 * 
	 * @param genLkLst
	 * @return
	 */
	public int insertGenLkLst(GenLkLstVO genLkLst);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 * 	입력받은 입력정보를 가져온다. 
	 * 
	 * @param schId
	 * @return
	 */
	public List<GenCaldVO> selectGenCaldList(String schId);
	
	/** 작성자 : 방형준(22.12.08)
	 * 
	 *  학교아이디를 입력받아 기존에 입력해놓은 달력정보를 삭제한다. (고민좀더 해봐야함)
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteGenCald(String schId);
	
	/** 작성자 : 방형준(22.12.08)
	 * 
	 *  달력정보 입력.
	 * 
	 * 
	 * @param genCald
	 * @return
	 */
	public int insertGenCald(GenCaldVO genCald);
	
	/** 작성자 : 방형준(22.12.10)
	 * 
	 * 	학교아이디를 입력받아 로고 정보를 가져온다.
	 * 
	 * @param schId
	 * @return
	 */
	public SchLogoVO selectSchLogo(String schId);
	
	/** 작성자 : 방형준(22.12.10)
	 * 
	 * 학교아이디를 입력 받아 로고정보를 삭제한다.
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteSchLogo(String schId);
	
	/** 작성자 : 방형준(22.12.10)
	 * 
	 * 	학교로고 정보를 받아 입력한다.
	 * 
	 * @param schLogo
	 * @return
	 */
	public int insertSchLogo(SchLogoVO schLogo);
	
	/**  작성자 : 방형준(22.12.10)
	 * 
	 * 	학교아이디를 입력받아 메인이미지 정보를 삭제한다.
	 * 
	 * @param schId
	 * @return
	 */
	public int deleteMainImage(String schId);
	
	/** 작성자 : 방형준(22.12.10)
	 * 
	 *  메인이미지 정보를 입력
	 * 
	 * @param genMainImg
	 * @return
	 */
	public int insertMainImage(GenMainImgVO genMainImg);
}
