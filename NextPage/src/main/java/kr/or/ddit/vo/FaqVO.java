package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class FaqVO {
	
	
	@NotBlank
	private Integer faqId;

	@NotBlank
	private String adminId;

	@NotNull
	private String faqTitle;
	private String faqCntnt;
	private String faqAtchPath;
	
	
	//필요한거 (파일)
	
	private MultipartFile adaptee;
	
	public FaqVO() {}
	public FaqVO(MultipartFile adaptee) {
		super();
		this.adaptee = adaptee;
		this.fileName = adaptee.getOriginalFilename();
		this.saveName = UUID.randomUUID().toString();
		this.savePath = "/FAQ/";
	}
	
	
	private String fileName;
	private String saveName;
	private String savePath;
	

	@JsonIgnore
	private transient MultipartFile boFiles;
	public void setBoFiles(MultipartFile boFiles) {
		if(boFiles==null || boFiles.isEmpty()) return;
		this.boFiles = boFiles;
		this.attatchList = new ArrayList<>();
			attatchList.add(new FaqVO(boFiles));
		}
	@JsonIgnore
	private transient List<FaqVO> attatchList;
	//필요한거(여기까지)
}
