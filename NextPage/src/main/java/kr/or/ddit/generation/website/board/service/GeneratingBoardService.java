package kr.or.ddit.generation.website.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.GenPostVO;
import kr.or.ddit.vo.PagingVO;

@Mapper
public interface GeneratingBoardService {
	
	/*이유영-게시판 게시물리스트*/
	public List<GenPostVO> schoolGenPostList(PagingVO<GenPostVO> pagingVO);
	public int selectTotalRecord(PagingVO<GenPostVO> pagingVO);
	
	/*이유영-게시판 게시물추가*/
	public ServiceResult insertGenPost(GenPostVO genPost);
	/*김건호-제너레이팅 게시판 파일 추가*/
	public Integer insertGenPostFile(GenPostVO genpost);
	/*이유영-게시판 게시물조회*/
	public GenPostVO selectGenPost(int postNum);
	/*김건호-제너레이팅 게시판 첨부파일 개수 받아오기*/
	public int getAttatchNum(int num);
	/*김건호-제너레이팅 게시판 첨부파일 데이터리스트 받아오기*/
	public List<GenPostVO> getAttatchFile(int postNum);
	/*김건호-제너레이팅 게시판 첨부파일 데이터 상세 받아오기*/
	public GenPostVO getAttatchFileDetail(String saveName);
	/*김건호-제너레이팅 게시판 첨부파일 데이터 상세 받아오기*/
	public GenPostVO getAttatchFileDetailNum(int FileId);
	
	
	/*이유영-게시판 게시물수정*/
	public ServiceResult modifyGenPost(GenPostVO genPost);
	/*이유영-게시판 게시물삭제*/
	public ServiceResult deleteGenPost(GenPostVO genPost);
	/*김건호-게시판 게시물 파일 삭제*/
	public int deleteGenPostFile(int genPost);
	
}
