package kr.or.ddit.school.manager.post.manage.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.GenPostVO;
import kr.or.ddit.vo.PagingVO;

/**
 * 학교관리자 게시물관리
 * @author PC-06
 *
 */


public interface PostManageService {

	/**
	 * 게시물관리 전체 리스트
	 * @param pagingVO
	 * @return
	 */
	public List<GenPostVO> selectGenPostList(PagingVO<GenPostVO> pagingVO);
	//public int selectTotalRecord(PagingVO pagingVO);

	/**
	 * 게시물삭제
	 * @param postNum
	 * @return
	 */

	public ServiceResult removeGenPost(Integer postNum);


}
