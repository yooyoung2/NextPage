package kr.or.ddit.school.manager.teacher.Insert.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.vo.FTP_Module;
import kr.or.ddit.vo.SchMemberFileVO;

public class DownloadView3 extends AbstractView {
	
	@Value("#{appInfo.attatchFolder}")
	private File saveFolder;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, 
			HttpServletResponse resp) throws Exception {
		SchMemberFileVO attatch = (SchMemberFileVO) model.get("attatch");
		
		FTP_Module ftp=new FTP_Module();
		ftp.FileDownload(attatch.getAttFilename(), attatch.getAttSavename(), "/aaa/bbb/", request, resp);
		
		
	}
	



}
