package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 게시판 관리를 위한 Domain Layer
 *
 */
@Data
@EqualsAndHashCode(of="boNo")
@ToString(exclude= {"boPass", "boContent"})
public class SchMemberFileListVO implements Serializable{
	
	/*private String memId;
	private String schId;
	private String memPw;
	@NotBlank
	private String memNm;
	@Email
	@NotBlank
	private String memEmail;
	@NotBlank
	private String telNum;
	@NotBlank
	private String addr1;
	@NotBlank
	private String addr2;
	*/
	
	@JsonIgnore
	private transient MultipartFile boFiles;
	public void setBoFiles(MultipartFile boFiles) {
		if(boFiles==null || boFiles.isEmpty()) return;
		this.boFiles = boFiles;
		this.attatchList = new ArrayList<>();
			attatchList.add(new SchMemberFileVO(boFiles));
		}
	@JsonIgnore
	private transient List<SchMemberFileVO> attatchList;
	
	/*
	@JsonIgnore
	private transient int startNo;
	
	@JsonIgnore
	private transient int[] delAttNos;*/
}



