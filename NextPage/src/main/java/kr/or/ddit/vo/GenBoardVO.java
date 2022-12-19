package kr.or.ddit.vo;

import java.io.Serializable;
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
@ToString
public class GenBoardVO implements Serializable{
	
	
	
	
private MultipartFile adaptee;
	
	public GenBoardVO() {}
	public GenBoardVO(MultipartFile adaptee) {
		super();
		this.adaptee = adaptee;
		this.fileName = adaptee.getOriginalFilename();
		this.saveName = UUID.randomUUID().toString();
		this.savePath = "/GENERATION_BOARD/";
	}
	private String fileName;
	private String saveName;
	private String savePath;
	
	
	@NotNull(groups= {UpdateGroup.class, DeleteGroup.class})
	private Integer brdNum;

	private String schId;
	@NotBlank
	private String brdTypeId;
	@NotBlank
	private String brdTitle;
	@NotBlank
	private String anmtWhthr;
	@NotBlank
	private String cmmntWhthr;
	@NotBlank
	private String attachNum;
	@NotBlank
	private String notisWhthr;
	@NotBlank
	private String pagePostNum;
	@NotBlank
	private String scrtWriteWhthr;
	@NotBlank
	private String prgrsCndtn;
	
	private String notisBtnWhthr;

	private String[] BRWS;
	private String[] WRTE;
	private String[] SCRT;
	private String[] CMMNT;

	private List<GenPostVO> genPostList;
	private List<GenCntntVO> genCnctList;
	
	
	
	
	@JsonIgnore
	private transient List<MultipartFile> boFiles;
	public void setBoFiles(List<MultipartFile> boFiles) {
		if(boFiles==null || boFiles.isEmpty()) return;
		this.boFiles = boFiles;
		this.attatchList = new ArrayList<>();
		for(MultipartFile file  : boFiles) {
			if(file.isEmpty()) continue;
			attatchList.add(new GenBoardVO(file));
			System.out.println("리스트에 들어감: "+file);
		}
	}
	@JsonIgnore
	private transient List<GenBoardVO> attatchList;

	
	
	
	
	
}
