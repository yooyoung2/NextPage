package kr.or.ddit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;

public class FTP_TEST2
{
    public static void main( String[] args )
    {
    	String uri = "192.168.143.12";
    	String id = "test";
    	String pw = "java";
    	String localFile="logo.jpg";
    	String ftpFile = "logo.jpg";
    	String directoryLocation ="\\";
    	
//    	ftpFileDownload(uri,id,pw,localFile,ftpFile,directoryLocation);
      ftpFileUpload(uri,id,pw,localFile,ftpFile,directoryLocation);
    	
    	
    	
    	
 //   	ftpFileReadFiles(uri,id,pw,directoryLocation);
    }

public static void ftpFileUpload(String uri, String id, String pw, String localFile, String ftpFile, String directoryLocation){
	FTPClient ftp = null;
	try {
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		ftp.connect(uri);
		ftp.login(id, pw);
		ftp.changeWorkingDirectory(directoryLocation);//파일을 업로드할 ftp서버의 디렉토리(폴더)위치
		ftp.setFileType(FTP.BINARY_FILE_TYPE);//파일 타입 설정 기본적으로 파일을 전송할떄는 BINARY타입을 사용합니다.
		

		File uploadFile = new File("C:\\test2",localFile);//업로드할 로컬 파일
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(uploadFile);
			boolean isSuccess = ftp.storeFile(ftpFile, fis);//ftp서버에 존재하는 해당명의 파일을 다운로드 하여 fos에 데이터를 넣습니다.
			if (isSuccess) {
				System.out.println("업로드를 성공 하였습니다.");
			} else {
				System.out.println("업로드 실패하여습니다.");
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}
		ftp.logout();
	} catch (SocketException e) {
		System.out.println("Socket:" + e.getMessage());
	} catch (IOException e) {
		System.out.println("IO:" + e.getMessage());
	} finally {
		if (ftp != null && ftp.isConnected()) {
			try {
				ftp.disconnect();//ftp연결 끊기
			} catch (IOException e) {
			}
		}
	}
	
	 File path = new File( "C:\\test2" );
	 File[] fileList = path.listFiles();
	 for(int i=0; i<fileList.length; i++){
		 System.out.println(i + "번째파일 : ");
		 if (fileList[i].delete() ){
			 System.out.println("삭제성공");
			 }else{
				 System.out.println("삭제실패");
				 }
		 }
}





public static void ftpFileDownload(String uri, String id, String pw, String localFile, String ftpFile, String directoryLocation){
	FTPClient ftp = null;
	try {
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8"); 
		ftp.connect(uri); //"192.168.0.35"
		ftp.login(id, pw); //"MeongDdi", "1234"
		ftp.changeWorkingDirectory(directoryLocation);//파일 가져올 디렉터리 위치

		File f = new File("C:\\test2", localFile);//로컬에 다운받아 설정할 이름
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			boolean isSuccess = ftp.retrieveFile(ftpFile, fos);//ftp서버에 존재하는 해당명의 파일을 다운로드 하여 fos에 데이터를 넣습니다.
			if (isSuccess) {
				System.out.println("다운로드를 성공 하였습니다.");
			} else {
				System.out.println("다운로드 실패하여습니다.");
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException ex) {
				}
		}
		ftp.logout();
	} catch (SocketException e) {
		System.out.println("Socket:" + e.getMessage());
	} catch (IOException e) {
		System.out.println("IO:" + e.getMessage());
	} finally {
		if (ftp != null && ftp.isConnected()) {
			try {
				ftp.disconnect();//ftp연결 끊기
			} catch (IOException e) {
			}
		}
	}
}





//선택된 디렉토리(폴더)에 존재하는 파일이름을 모두 불러옵니다.
public static void ftpFileReadFiles(String uri, String id, String pw,String directoryLocation){
	FTPClient ftp = null;
	try {
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		ftp.connect(uri);
		ftp.login(id, pw);
		ftp.changeWorkingDirectory(directoryLocation);//파일 가져올 디렉터리 위치
		ftp.setFileType(FTP.BINARY_FILE_TYPE);//파일 타입 설정 기본적으로 파일을 전송할떄는 BINARY타입을 사용합니다.
		System.out.println("바뀐후 디렉토리: "+ftp.printWorkingDirectory());
		
		
		
		
		
		
		List<String> files = new ArrayList<>();
		if (ftp.changeWorkingDirectory(ftp.printWorkingDirectory())) {
			for (FTPFile file : ftp.listFiles()) {
				if (file.getName().equals(".") || file.getName().equals("..")) {
					continue;
				}
				if (file.isFile()) {
					files.add(ftp.printWorkingDirectory() + "/" + file.getName());
				} else {
					
				}
			}
			ftp.changeWorkingDirectory("/");
		}
		
		
		
		
		for(String fileName :ftp.listNames()){
			System.out.println(fileName);
		}
		
		
		
		
		ftp.logout();
	} catch (SocketException e) {
		System.out.println("Socket:" + e.getMessage());
	} catch (IOException e) {
		System.out.println("IO:" + e.getMessage());
	} finally {
		if (ftp != null && ftp.isConnected()) {
			try {
				ftp.disconnect();//ftp연결 끊기
			} catch (IOException e) {
			}
		}
	}
}


}

