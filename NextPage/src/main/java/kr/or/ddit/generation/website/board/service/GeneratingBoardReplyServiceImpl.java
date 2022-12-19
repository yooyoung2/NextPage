package kr.or.ddit.generation.website.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.generation.website.board.dao.GeneratingBoardReplyDAO;
import kr.or.ddit.vo.GenCmntVO;

@Service
public class GeneratingBoardReplyServiceImpl implements GeneratingBoardReplyService{
	
	@Inject
	private GeneratingBoardReplyDAO replyDAO;

	@Override
	public List<GenCmntVO> generatingBoardReplyList(int postNum) {
		return replyDAO.generatingBoardReplyList(postNum);
	}

	@Override
	public int createReply(GenCmntVO genCmnt) {
		return replyDAO.insertReply(genCmnt);
	}

	@Override
	public int removeReply(GenCmntVO genCmnt) {
		return replyDAO.deleteReply(genCmnt);
	}
}
