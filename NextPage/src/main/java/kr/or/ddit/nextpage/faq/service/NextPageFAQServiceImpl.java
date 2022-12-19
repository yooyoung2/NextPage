package kr.or.ddit.nextpage.faq.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.faq.dao.NextPageFAQDAO;
import kr.or.ddit.vo.FTP_Module;
import kr.or.ddit.vo.FaqVO;
import kr.or.ddit.vo.PagingVO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NextPageFAQServiceImpl implements NextPageFAQService {

	@Inject
	private NextPageFAQDAO dao;


	@Override
	public ServiceResult createFaq(FaqVO faq) {
		ServiceResult result = null;
		int rowcnt = dao.insertFAQBoard(faq);
		
		
		//여기부터(파일)
		List<FaqVO> attatchList = faq.getAttatchList();
		if(attatchList!=null && !attatchList.isEmpty()) {
			System.out.println("파일에 뭔가 들어옴"+faq);
//			if(1==1) throw new RuntimeException("트랜잭션 관리 여부 확인용 강제 예외 발생");
			// 메타데이터 저장
			int rowcnt2 = dao.insertFAQBoardFile(faq);
			// 2진 데이터 저장
			for(FaqVO attatch : attatchList) {
				FTP_Module ftp=new FTP_Module();
				ftp.FileUpload(attatch.getFileName(), attatch.getSaveName(), attatch.getSavePath(), attatch.getAdaptee());
			}
		}
		else {
			System.out.println("파일에 어떤것도 들어오지 않음"+faq);
		}
		//여기까지 (파일)
		
		
		

		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public FaqVO retrieveFaq(Integer faqId) {
		FaqVO faq = dao.selectFaq(faqId);
		if(faqId ==null) {
			throw new RuntimeException();
		}

		return faq;
	}

	@Override
	public List<FaqVO> retrieveFaqList(PagingVO<FaqVO> pagingVO) {
		int totalRecode = dao.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecode);

		return dao.selectFAQList(pagingVO);
	}

	@Override
	public ServiceResult modifyFaq(FaqVO faq) {
		
		
		//파일업데이트 시작
		FaqVO deleteFaq=retrieveFaq(faq.getFaqId());
		
		
		
		
		
		
		
		FTP_Module ftp=new FTP_Module();
		ftp.ftpFileDelete(deleteFaq.getFileName(), deleteFaq.getSaveName(), deleteFaq.getSavePath());
		
		
		
		List<FaqVO> attatchList = faq.getAttatchList();
		if(attatchList!=null && !attatchList.isEmpty()) {
			System.out.println("파일에 뭔가 들어옴"+faq);
//			if(1==1) throw new RuntimeException("트랜잭션 관리 여부 확인용 강제 예외 발생");
			// 메타데이터 저장
			int rowcnt2 = dao.insertFAQBoardFile(faq);
			// 2진 데이터 저장
			for(FaqVO attatch : attatchList) {
				
				
				ftp.FileUpload(attatch.getFileName(), attatch.getSaveName(), attatch.getSavePath(), attatch.getAdaptee());
			}
		}
		else {
			System.out.println("파일에 어떤것도 들어오지 않음"+faq);
		}
		
		
		//파일업데이트 여기까지
		
		
		
		
		int rowcnt = dao.updateFaq(faq);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult deleteFaq(FaqVO faq) {
		
		
		//파일삭제
		FaqVO deleteFile = retrieveFaq(faq.getFaqId());
		
		FTP_Module ftp=new FTP_Module();
		ftp.ftpFileDelete(deleteFile.getFileName(), deleteFile.getSaveName(), deleteFile.getSavePath());
		//여기까지
		
		
		
		
		int rowcnt = dao.deleteFaq(faq.getFaqId());
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public int insertFAQBoardFile(FaqVO faq) {
		return 1;
	}

}
