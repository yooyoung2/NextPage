package kr.or.ddit.school.manager.post.manage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.post.manage.dao.PostManageDAO;
import kr.or.ddit.vo.GenPostVO;
import kr.or.ddit.vo.PagingVO;


@Service
public class PostManageServiceImpl implements PostManageService{

	@Inject
	private PostManageDAO dao;

	@Override
	public List<GenPostVO> selectGenPostList(PagingVO<GenPostVO> pagingVO) {
		int totalRecord = dao.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecord);

		return dao.selectGenPostList(pagingVO);
	}

	@Override
	@Transactional
	public ServiceResult removeGenPost(Integer postNum) {

		//첨부파일삭제
		int rowcnt2 = dao.deleteAtch(postNum);

		//댓글삭제
		int rowcnt3 = dao.deleteCmnt(postNum);

		//게시물삭제
		int rowcnt = dao.deletePost(postNum);

		if(rowcnt >0 && rowcnt2>0 && rowcnt3 >0) {
			return ServiceResult.OK;
		}else {
			return ServiceResult.FAIL;
		}

	}



}
