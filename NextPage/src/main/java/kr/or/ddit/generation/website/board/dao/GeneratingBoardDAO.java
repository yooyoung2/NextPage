package kr.or.ddit.generation.website.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.GenMenuVO;
import kr.or.ddit.vo.GenPostVO;
import kr.or.ddit.vo.PagingVO;

@Mapper
public interface GeneratingBoardDAO {

	/*이유영-제너레이팅 게시판 게시물리스트*/
	public List<GenPostVO> schoolGenPostList(PagingVO<GenPostVO> pagingVO);
	public int selectTotalRecord(PagingVO pagingVO);
	
	/*이유영-제너레이팅 게시판 추가*/
	public Integer insertGenPost(GenPostVO genpost);
	/*김건호-제너레이팅 게시판 파일 추가*/
	public Integer insertGenPostFile(GenPostVO genpost);
	/*이유영-제너레이팅 게시판 조회*/
	public GenPostVO selectGenPost(@Param("postNum") int postNum);
	/*김건호-제너레이팅 게시판 첨부파일 개수 받아오기*/
	public int getAttatchNum(int num);
	/*김건호-제너레이팅 게시판 첨부파일 데이터리스트 받아오기*/
	public List<GenPostVO> getAttatchFile(int postNum);
	/*김건호-제너레이팅 게시판 첨부파일 데이터 상세 받아오기*/
	public GenPostVO getAttatchFileDetail(String saveName);
	/*김건호-제너레이팅 게시판 첨부파일 데이터 상세 받아오기*/
	public GenPostVO getAttatchFileDetailNum(int FileId);
	
	/*이유영-제너레이팅 게시판 수정*/
	public int updateGenPost(GenPostVO genPost);
	/*이유영-제너레이팅 게시판 삭제*/
	public int deleteGenPost(GenPostVO genPost);
	/*김건호-게시판 게시물 파일 삭제*/
	public int deleteGenPostFile(int genPost);
}
