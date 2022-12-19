package kr.or.ddit.generation.website.board.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.website.board.dao.GeneratingBoardDAO;
import kr.or.ddit.vo.FTP_Module;
import kr.or.ddit.vo.GenPostVO;
import kr.or.ddit.vo.PagingVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class GeneratingBoardServiceImpl implements GeneratingBoardService {
	@Inject
	private GeneratingBoardDAO genPostDAO;
	
	/*이유영-제너레이팅-게시물리스트*/
	@Override
	public List<GenPostVO> schoolGenPostList(PagingVO<GenPostVO> pagingVO) {
		return genPostDAO.schoolGenPostList(pagingVO);
	}

	@Override
	public int selectTotalRecord(PagingVO pagingVO) {
		return genPostDAO.selectTotalRecord(pagingVO);
	}
	
	/*이유영-제너레이팅-게시물추가*/
	@Override
	public ServiceResult insertGenPost(GenPostVO genPost) {
		int rowcnt = genPostDAO.insertGenPost(genPost);
		
		
		System.out.println("도대체왜?"+genPost.getSavePath());
		String savePath=genPost.getSavePath();
		List<GenPostVO> attatchList = genPost.getAttatchList();
		if(attatchList!=null && !attatchList.isEmpty()) {
//			if(1==1) throw new RuntimeException("트랜잭션 관리 여부 확인용 강제 예외 발생");
			// 메타데이터 저장
			
			
			// 2진 데이터 저장
			for(GenPostVO attatch : attatchList) {
				
				FTP_Module ftp=new FTP_Module();
				ftp.FileUpload(attatch.getFileName(), attatch.getSaveName(), genPost.getSavePath(), attatch.getAdaptee());
			}
			System.out.println("진짜뭐길래"+genPost.getSavePath());
			for(int i=0;i<attatchList.size();i++)
			{
				attatchList.get(i).setSavePath(genPost.getSavePath());
			}
			rowcnt = genPostDAO.insertGenPostFile(genPost);
		}
		
		
		
		
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public GenPostVO selectGenPost(int postNum) {
		GenPostVO genPost = genPostDAO.selectGenPost(postNum);
		return genPost;
	}

	@Override
	public ServiceResult modifyGenPost(GenPostVO genPost) {
		int rowcnt = genPostDAO.updateGenPost(genPost);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult deleteGenPost(GenPostVO genPost) {
		int rowcnt = genPostDAO.deleteGenPost(genPost);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public Integer insertGenPostFile(GenPostVO genpost) {
		return 1;
	}

	@Override
	public int getAttatchNum(int num) {
		return genPostDAO.getAttatchNum(num);
		
				
	}

	@Override
	public List<GenPostVO> getAttatchFile(int postNum) {
		return genPostDAO.getAttatchFile(postNum);
	}

	@Override
	public GenPostVO getAttatchFileDetail(String saveName) {
		return genPostDAO.getAttatchFileDetail(saveName);
	}

	@Override
	public int deleteGenPostFile(int genPost) {
		
		
		
		
		
		return genPostDAO.deleteGenPostFile(genPost);
	}

	@Override
	public GenPostVO getAttatchFileDetailNum(int FileId) {
		return genPostDAO.getAttatchFileDetailNum(FileId);
	}





}
