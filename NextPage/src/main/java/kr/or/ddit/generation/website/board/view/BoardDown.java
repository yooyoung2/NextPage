package kr.or.ddit.generation.website.board.view;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.vo.FTP_Module;
import kr.or.ddit.vo.FaqVO;
import kr.or.ddit.vo.GenPostVO;

public class BoardDown extends AbstractView {
	
	@Value("#{appInfo.attatchFolder}")
	private File saveFolder;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse resp) throws Exception {
		
		GenPostVO attatch = (GenPostVO) model.get("attatch");
		
		attatch.setSavePath(attatch.getSavePath());
		FTP_Module ftp=new FTP_Module();
		ftp.FileDownload(attatch.getFileName(), attatch.getSaveName(), attatch.getSavePath(), request, resp);
	}

}
