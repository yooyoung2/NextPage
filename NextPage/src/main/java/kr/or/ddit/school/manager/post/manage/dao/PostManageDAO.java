package kr.or.ddit.school.manager.post.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.GenPostVO;
import kr.or.ddit.vo.PagingVO;




/**
 * 학교관리자 게시물관리 구지현
 * @author PC-06
 *
 */

@Mapper
public interface PostManageDAO {

	/**
	 * 전체리스트 조회
	 * @param pagingVO
	 * @return
	 */

	public List<GenPostVO> selectGenPostList(PagingVO<GenPostVO> pagingVO);
	public int selectTotalRecord(PagingVO<GenPostVO> pagingVO);


	/**
	 * 학교관리자 게시물삭제
	 * @param postNum
	 * @return
	 */
	public int deletePost(@Param("postNum")Integer postNum);


	/**
	 * 학교관리자 게시물댓글삭제
	 * @param postNum
	 * @return
	 */
	public int deleteCmnt(@Param("postNum")Integer postNum);


	/**
	 * 학교관리자 게시물첨부파일삭제
	 * @param postNum
	 * @return
	 */
	public int deleteAtch(@Param("postNum")Integer postNum);






}
