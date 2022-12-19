package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="brdNum")
@ToString(exclude= {"postCntnt"})
public class GenPostVO {
	private Integer attatchNum;
	private Integer startNo;
	private Integer fileId;
	private String fileName;
	private String saveName;
	private String savePath;
	private String realName;

	private MultipartFile adaptee;
		
		public GenPostVO() {}
		public GenPostVO(MultipartFile adaptee) {
			super();
			this.adaptee = adaptee;
			this.fileName = adaptee.getOriginalFilename();
			this.saveName = UUID.randomUUID().toString();
		}
		
		
	/*이유영-제너레이팅 게시판*/
	@NotNull(groups= {UpdateGroup.class, DeleteGroup.class})
	private Integer postNum;

	@NotNull
	private Integer brdNum;

	@NotBlank
	private String postWrtId;

	@NotBlank
	private String postTitle;

	private String postCntnt;

	private String postPrgrsPrsntCndtn;

	@NotBlank
	private String postWriteDate;
	@NotBlank
	private String postNotisWhether;
	@NotBlank
	private String postScrtWhether;

	private String memNm;
	private String typeNm;
	private String memId;

	//학교구분
	private String schId;
	



	/*
	 * 나중에 첨부파일, 댓글
	private List<PostAtchVO> postAtchList;

	*/
	
	@JsonIgnore
	private transient List<MultipartFile> boFiles;
	public void setBoFiles(List<MultipartFile> boFiles) {
		if(boFiles==null || boFiles.isEmpty()) return;
		this.boFiles = boFiles;
		this.attatchList = new ArrayList<>();
		for(MultipartFile file  : boFiles) {
			if(file.isEmpty()) continue;
			attatchList.add(new GenPostVO(file));
			System.out.println("리스트에 들어감: "+file);
		}
	}
	@JsonIgnore
	private transient List<GenPostVO> attatchList;
	private transient GenPostVO image;


}
