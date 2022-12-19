package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
/**
 * 학교관리자 학교장 인사말
 * @author PC-06
 *
 */

@Data
public class SchGretngVO {
	@NotBlank
	private String schId;
	private String cntnt;
	private String fileName;
	private String saveName;
	private String savePath;
	
	
	

	

}
