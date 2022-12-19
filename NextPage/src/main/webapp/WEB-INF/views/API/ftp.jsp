<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
//apache에서 다운받아야 함!
package kr.or.ddit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class Bridge {
	static String REMOTE_DIR = "C:\\test\\cat1.jpg"; //복사대상
	static String LOCAL_DIR = "C:\\test"; //복사될 위치
	static String HOST = "192.168.143.12"; //서버아이피
	static String USER = "test"; //서버계정정보
	static String PASSWD = "java"; //비번

	// 시작 함수
	public static void main(String[] args) {
		FTPClient client = new FTPClient();
		try {
			client.setControlEncoding("UTF-8");
			client.connect(HOST, 21);
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
				
				System.out.println(client.printWorkingDirectory());

				// **다운로드
				String root = LOCAL_DIR;
				if (getFileList(client, client.printWorkingDirectory(), files, directories)) {

					Collections.reverse(directories);

					for (String directory : directories) {
						File file = new File(root + directory);
						file.mkdir();
					}
					for (String file : files) {
						// 파일의 OutputStream을 가져온다.
						try (FileOutputStream fo = new FileOutputStream(root + "/" + file)) {
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

	private static boolean getFileList(FTPClient client, String cw, List<String> files, List<String> directories)
			throws IOException {
		// FTP의 디렉토리 커서를 이동한다.

		if (client.changeWorkingDirectory(cw)) {
			for (FTPFile file : client.listFiles()) {
				if (file.getName().equals(".") || file.getName().equals("..")) {
					continue;
				}
				if (file.isFile()) {
					files.add(cw + "/" + file.getName());
				} else {
					if (!getFileList(client, cw + "/" + file.getName(), files, directories)) {
						return false;
					} else {
						directories.add(cw + "/" + file.getName());
					}
				}
			}
			return client.changeWorkingDirectory("/");
		}
		return false;
	}
}
</body>
</html>