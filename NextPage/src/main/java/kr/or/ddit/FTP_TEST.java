package kr.or.ddit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTP_TEST {
	static String REMOTE_DIR = "//bbb//"; //복사대상
	static String LOCAL_DIR = "c://test2"; //복사될 위치
	static String HOST = "192.168.143.12"; //서버아이피
	static String USER = "test"; //서버계정정보
	static String PASSWD = "java"; //비번

	public static void FTP() {
		FTPClient client = new FTPClient();
		try {
			client.setControlEncoding("UTF-8");
			client.connect(HOST, 21);//포트번호
			client.enterLocalPassiveMode();
			int resultCode = client.getReplyCode();
			if (!FTPReply.isPositiveCompletion(resultCode)) {
				System.out.println("FTP server refused connection.!");
				return;
			} else { //연결성공
				client.setSoTimeout(1000);
				if (!client.login(USER, PASSWD)) { //계정정보 확인
					System.out.println("Login Error!"); //계정정보 불일치
					return;
				}
				List<String> files = new ArrayList<>();
				List<String> directories = new ArrayList<>();

				// FTP경로 설정
				client.changeWorkingDirectory(REMOTE_DIR);
				
				System.out.println(client.printWorkingDirectory()+" <-워킹디렉토리");

				
				
				
				
				
				
				int success=0;
				
				if (client.changeWorkingDirectory(client.printWorkingDirectory())) {
					for (FTPFile file : client.listFiles()) {
						if (file.getName().equals(".") || file.getName().equals("..")) {
							continue;
						}
						if (file.isFile()) {
							files.add(client.printWorkingDirectory() + "/" + file.getName());
						} else {
							
						}
					}
					client.changeWorkingDirectory(REMOTE_DIR);
				}
				success=0;
				
				
				
				
				
				
				
				
				
				
				// **다운로드
				String root = LOCAL_DIR;
				if (success==0) {
					
					
					/*File file2=new File("c:\\test2\\a.txt");	
					try {
						FileOutputStream fout=new FileOutputStream(file2);
						
						for(char ch='A';ch<='Z';ch++)
						{
							fout.write(ch);
						}
						System.out.println("출력 작업 완료!!!");
						fout.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/

					//파일 전체 삭제
//					 File path = new File( "C:\\test2" );
//					 File[] fileList = path.listFiles();
//					 for(int i=0; i<fileList.length; i++){
//						 System.out.println(i + "번째파일 : ");
//						 if (fileList[i].delete() ){
//							 System.out.println("삭제성공");
//							 }else{
//								 System.out.println("삭제실패");
//								 }
//						 }
					
					Collections.reverse(directories);

					for (String directory : directories) {
						//File file = new File(root + directory);
						File file = new File(directory);
						file.mkdir(); 
					}
					for (String file : files) {
						// 파일의 OutputStream을 가져온다.
						//try (FileOutputStream fo = new FileOutputStream(root + "/" + file)) {
						String realPath=LOCAL_DIR+"/"+file;
						realPath=realPath.replaceFirst(client.printWorkingDirectory(), "");
						try (FileOutputStream fo = new FileOutputStream(realPath)) {
							client.setFileType(FTP.BINARY_FILE_TYPE);

							if (client.retrieveFile(file, fo)) {
								System.out.println("Download :: " + file);
							}
						}
					}
				} else {
					System.out.println("File search Error!");
					return;
				}
				
				
				client.logout();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				if (client.isConnected()) {
					client.disconnect();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		FTP();
	}
}