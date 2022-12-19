package kr.or.ddit.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@EqualsAndHashCode(of="attNo")
@ToString(exclude="adaptee")
@NoArgsConstructor
@Slf4j
public class SchMemberFileVO {
	private MultipartFile adaptee;
	
	public SchMemberFileVO(MultipartFile adaptee) {
		super();
		this.adaptee = adaptee;
		this.attFilename = adaptee.getOriginalFilename();
		this.attSavename = UUID.randomUUID().toString();
		this.attMime = adaptee.getContentType();
		this.attFilesize = adaptee.getSize();
		this.attFancysize = FileUtils.byteCountToDisplaySize(attFilesize);
	}
	
	@NotNull
	private Integer attNo;
	private Integer boNo;
	@NotBlank
	private String attFilename;
	@NotBlank
	private String attSavename;
	private String attMime;
	@NotNull
	private Long attFilesize;
	@NotBlank
	private String attFancysize;
	private Integer attDownload;
	
	//saveFolder는 저장될 경로 즉, c:\test인 appInfo에 있는 내용이고
	//attSavename은 이진파일 이다.
	public void saveTo(File saveFolder) throws IOException {
		
		
		FTP_Module ftp=new FTP_Module();
		ftp.FileUpload(attFilename, attSavename, "/POI/학년-반/", adaptee);
	}
	
	
	
}











