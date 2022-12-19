package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class NoticeBoardVO {
	private MultipartFile adaptee;
	
	public NoticeBoardVO() {}
	public NoticeBoardVO(MultipartFile adaptee) {
		super();
		this.adaptee = adaptee;
		this.fileName = adaptee.getOriginalFilename();
		this.saveName = UUID.randomUUID().toString();
		this.savePath = "/NOTICE_BOARD/";
	}

	private Integer notisNum;

	@NotBlank
	private String adminId;

	@NotNull
	private String notisTitle;

	@NotNull
	private String notisCntnt;

	@NotNull
	private String notisWrteDate;
	
	private String fileName;
	private String saveName;
	private String savePath;
	

	@JsonIgnore
	private transient MultipartFile boFiles;
	public void setBoFiles(MultipartFile boFiles) {
		if(boFiles==null || boFiles.isEmpty()) return;
		this.boFiles = boFiles;
		this.attatchList = new ArrayList<>();
			attatchList.add(new NoticeBoardVO(boFiles));
		}
	@JsonIgnore
	private transient List<NoticeBoardVO> attatchList;
	
	
	



}
