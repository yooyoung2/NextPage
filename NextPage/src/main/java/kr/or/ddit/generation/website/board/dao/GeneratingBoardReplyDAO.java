package kr.or.ddit.generation.website.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.GenCmntVO;

@Mapper
public interface GeneratingBoardReplyDAO {
	/*이유영-게시판 댓글 목록*/
	public List<GenCmntVO> generatingBoardReplyList(int postNum);
	/*이유영-게시판 댓글 추가*/
	public int insertReply(GenCmntVO genCmnt);
	/*이유영-게시판 댓글 삭제*/
	public int deleteReply(GenCmntVO genCmnt);
}
