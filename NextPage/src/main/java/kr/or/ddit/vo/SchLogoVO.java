package kr.or.ddit.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class SchLogoVO {
	private String schId;
	
	private String fileName;
	private String saveName;
	private String savePath;
	
	
}
