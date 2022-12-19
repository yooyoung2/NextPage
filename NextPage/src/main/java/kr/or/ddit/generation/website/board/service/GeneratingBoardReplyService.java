package kr.or.ddit.generation.website.board.service;

import java.util.List;

import kr.or.ddit.vo.GenCmntVO;

public interface GeneratingBoardReplyService {
	/*이유영-게시판 댓글 목록*/
	public List<GenCmntVO> generatingBoardReplyList(int postNum);
	/*이유영-게시판 댓글 추가*/
	public int createReply(GenCmntVO genCmnt);
	/*이유영-게시판 댓글 삭제*/
	public int removeReply(GenCmntVO genCmnt);
}
