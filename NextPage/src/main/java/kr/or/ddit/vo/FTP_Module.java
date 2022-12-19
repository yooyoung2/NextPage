package kr.or.ddit.vo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FTP_Module {
	
	private File saveFolder;
	private static String uri="192.168.143.12";
	private static String id="test";
	private static String pw="java";
	
	
	
	
//	private String fileName;
//	private String saveName;
//	private String directoryLocation;
//	private MultipartFile adaptee;
	
	public FTP_Module()
	{
		uri="192.168.143.12";
		id="test";
		pw="java";
	}
	
	/**
	 * 파일이름, 세이브이름, 디렉토리 \\, MultipartFile 어뎁티
	 * @param fileName
	 * @param saveName
	 * @param directoryLocation
	 * @param adaptee
	 */
	public void FileUpload(String fileName, String saveName, String directoryLocation, MultipartFile adaptee){
		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect(uri);
			ftp.login(id, pw);
			
			ftp.setFileType(FTP.BINARY_FILE_TYPE);//파일 타입 설정 기본적으로 파일을 전송할떄는 BINARY타입을 사용합니다.
			
			
			
			//c드라이브에 test2 폴더를 만들어준다.
			 File test2 = new File("c://test2");
			    if (test2.mkdir()){
			      System.out.println("디렉토리 생성 성공");
			    }else{
			      System.out.println("디렉토리 생성 실패");
			    }
			  //폴더가 없다면 해당 폴더를 생성해준다.
			boolean dirExists = true;
			  String[] directories = directoryLocation.split("/");
			  for (String dir : directories ) {
			    if (!dir.isEmpty() ) {
			      if (dirExists) {
			        dirExists = ftp.changeWorkingDirectory(dir);
			      }
			      if (!dirExists) {
			        if (!ftp.makeDirectory(dir)) {
			          throw new IOException("Unable to create remote directory '" + dir + "'.  error='" + ftp.getReplyString()+"'");
			        }
			        if (!ftp.changeWorkingDirectory(dir)) {
			          throw new IOException("Unable to change into newly created remote directory '" + dir + "'.  error='" + ftp.getReplyString()+"'");
			        }
			      }
			    }
			  }     
			
			  ftp.changeWorkingDirectory(directoryLocation);//파일을 업로드할 ftp서버의 디렉토리(폴더)위치
			
			
			
			
			
			
			//1. 이진파일을 로컬에 저장한다.
			//saveFolder 들어갈 자리
			File saveFile= new File("c:\\test2", saveName);
			adaptee.transferTo(saveFile);
			
			//2. 이진파일을 원본파일로 변환 후 저장한다.
			try {
				FileInputStream fr= new FileInputStream("C:/test2/"+saveName);
				FileOutputStream fout = new FileOutputStream("C:/test2/"+fileName);
				
				int c;
				byte[] buffer = new byte[1024];
				while((c= fr.read(buffer, 0, buffer.length))!=-1) {
					fout.write(buffer, 0, c);
				}

				fr.close();
				fout.close();

			} catch (IOException e) {
				System.out.println("이진파일->원본파일 변환 실패");
			} 
			
			
			//3. 원본파일을 FTP에 업로드한다.
			//saveFolder 들어갈 자리
			File uploadFile = new File("C:\\test2",fileName);//업로드할 로컬 파일
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(uploadFile);
				boolean isSuccess = ftp.storeFile(fileName, fis);//ftp서버에 존재하는 해당명의 파일을 다운로드 하여 fos에 데이터를 넣습니다.
				if (isSuccess) {
					System.out.println("업로드를 성공하였습니다.");
				} else {
					System.out.println("업로드 실패하였습니다.");
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
			
			
			//4. 이진파일을 FTP에 업로드한다.
			File uploadFile2 = new File("C:\\test2",saveName);//업로드할 로컬 파일
			FileInputStream fis2 = null;
			try {
				fis2 = new FileInputStream(uploadFile2);
				boolean isSuccess = ftp.storeFile(saveName, fis2);//ftp서버에 존재하는 해당명의 파일을 다운로드 하여 fos에 데이터를 넣습니다.
				if (isSuccess) {
					System.out.println("업로드를 성공 하였습니다."+"C:\\test2"+fileName);
				} else {
					System.out.println("업로드 실패하여습니다.");
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} finally {
				if (fis2 != null)
					try {
						fis2.close();
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
		
		//임시저장된 파일을 모두 삭제한다.
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
	
	
	
	
	
	
	
	
	
	
	
	
/**
 * 세이브네임, 파일네임, 디렉토리경로 //aaa//, 리퀘스트, 리스폰스, 세이브폴더 
 * @param saveName
 * @param fileName
 * @param directoryLocation
 * @param request
 * @param resp
 * @param saveFolder
 */
public void FileDownload(String fileName, String saveName, String directoryLocation 
		,HttpServletRequest request, 
		HttpServletResponse resp
		){
	FTPClient ftp = null;
	try {
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8"); 
		ftp.connect(uri);
		ftp.login(id, pw);
		ftp.changeWorkingDirectory(directoryLocation);

	
		//FTP에 있는 이진파일을 로컬로 가져온다.
		//saveFolder 들어갈 자리
		File f = new File("C:\\test2", saveName);//로컬에 다운받아 설정할 이름
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			boolean isSuccess = ftp.retrieveFile(saveName, fos);//FTP에 다운받아 설정할 이름
			if (isSuccess) {
				System.out.println("다운로드를 성공 하였습니다.");
			} else {
				System.out.println("다운로드 실패하여습니다.");
			}
			
			
			
			
			
			
			
			
			
			//이진파일을 원본파일로 변환해서 저장한다.
			File file = new File("C:\\test2", saveName);
			System.out.println("C:\\test2"+"세이브폴더와 세이브네임"+saveName);
			fileName = URLEncoder.encode(fileName, "UTF-8");
			fileName = fileName.replaceAll("\\+", " ");
			resp.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
			resp.setHeader("Content-Disposition", "attatchment;filename=\""+fileName+"\"");
			try(
				OutputStream os = resp.getOutputStream();
			){
				FileUtils.copyFile(file, os);
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
	
	
	//임시저장된 파일을 모두 삭제한다.
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









public void FileReadList(String directoryLocation){
	FTPClient ftp = null;
	try {
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		ftp.connect(uri);
		ftp.login(id, pw);
		ftp.changeWorkingDirectory(directoryLocation);//파일 가져올 디렉터리 위치
		ftp.setFileType(FTP.BINARY_FILE_TYPE);//파일 타입 설정 기본적으로 파일을 전송할떄는 BINARY타입을 사용합니다.
		System.out.println("바뀐후 디렉토리: "+ftp.printWorkingDirectory());
		
		
		//해당 폴더의 모든 파일 이름을 불러온다.
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
		

	    
	
		
		//파일안에 있는 내용을 읽어오는 코드
//		for(String fileName :ftp.listNames()){
//			System.out.println(fileName);
//		}
//		
//		InputStream fin =ftp.retrieveFileStream("logo.jpg");
//		int c;
//		while((c=fin.read())!=-1)
//		{
//			System.out.print((char) c);
//			test+=c;
//		}
		
		
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











public String FileReadImage(String directoryLocation, String fileName){
	FTPClient ftp = null;
	String base64data = null;
	try {
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8");
		ftp.connect(uri);
		ftp.login(id, pw);
		ftp.changeWorkingDirectory(directoryLocation);//파일 가져올 디렉터리 위치
		ftp.setFileType(FTP.BINARY_FILE_TYPE);//파일 타입 설정 기본적으로 파일을 전송할떄는 BINARY타입을 사용합니다.
		System.out.println("바뀐후 디렉토리: "+ftp.printWorkingDirectory());
		
		

		//이미지를 64비트로 인코딩해준다.
		InputStream fin =ftp.retrieveFileStream(fileName);
		ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
		
		int c;
		byte[] buf=new byte[1024];
		try {
			while((c=fin.read(buf))!=-1){
				byteOutStream.write(buf,0,c);
			}			
		}
		catch(Exception e)
		{
			System.out.println("이미지가 아닌 파일이 있음");
		}
		
		 // base64의 라이브러리에서 encodeToString를 이용해서 byte[] 형식을 String 형식으로 변환합니다.
	    base64data = Base64.getEncoder().encodeToString(byteOutStream.toByteArray());
	    // 콘솔에 결과 출력
		//test=base64data;
	    

		
		
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
	return base64data;
}












public void ftpFileDelete(String fileName, String saveName, String directoryLocation){
	FTPClient ftp = null;
	try {
		ftp = new FTPClient();
		ftp.setControlEncoding("UTF-8"); 
		ftp.connect(uri); //"192.168.0.35"
		ftp.login(id, pw); //"MeongDdi", "1234"
		ftp.changeWorkingDirectory(directoryLocation);//파일 가져올 디렉터리 위치

		
		 boolean delflag2 = ftp.deleteFile(saveName);
		  if(delflag2 == false){
			     try {
					throw new Exception("이진파일 삭제에 실패 하였습니다.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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








}
