package kr.or.ddit.generation.website.main.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SchLogoVO;

/**
 * 작성자 : 최현우
 * 기능 : generation 메인 홈으로 들어갔을때 해당 아이디의 해당하는 모든 옵션 uri 가져오기
 * @author PC-04
 *
 */

public interface GeneratingMainService {
	
	/**
	 * 작성자 : 최현우
	 * KEY : 옵션 이름
	 * VALUE : 옵션 링크
	 * @return
	 */
	public List<GeneratingMainVO> getOptionsURL( String schId );
	
	/**
	 * 작성자 : 최현우
	 * 모든 유저의 메뉴정보 반환
	 * @return
	 */
	public List<GeneratingMainVO> selectAll();
	
	public GeneratingMainVO selectSchoolByUri( String address );
	
	
	/**
	 * 작성자 : 최현우
	 * brdNum정보로 회원정보 가져옴
	 * @param brdNum
	 * @return
	 */
	public GeneratingMainVO selectSchoolByBrdNum( String brdNum );
	
	/**
	 * 작성자 : 최현우
	 * @param id ( 학교아이디 )
	 * @return ProjectVO ( 학교아이디, 프로젝트아이디, 탬플릿아이디 )
	 */
	public ProjectVO selectProjectInfo( String id );
	
	
	/**
	 * 작성자 : 최현우
	 * @param schId
	 * @return List<GenMainImgVO> ( 메인 이미지들을 리스트로 가져옴 )
	 */
	public List<GenMainImgVO> getMainImages( String schId );
	
	/**
	 * 작성자 : 최현우
	 * @param schId
	 * @return SchLogoVO ( 메인 로고 이미지 )
	 */
	public SchLogoVO getLogoImage( String schId );
	
}
