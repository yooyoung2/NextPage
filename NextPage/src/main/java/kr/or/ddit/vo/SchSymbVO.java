package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
/**
 * 학교상징 구지현
 * @author PC-06
 *
 */
@Data
public class SchSymbVO {
	@NotBlank
	private String schId;
	private String schmtt;
	private String schTree;
	private String treeFileName;
	private String treeSaveName;
	private String schFlower;
	private String flowerFileName;
	private String flowerSaveName;
	private String schBird;
	private String birdFileName;
	private String birdSaveName;
	private String schSymbol;
	private String symbolFileName;
	private String symbolSaveName;
	private String savePath;
	private String treeInfo;
	private String flowerInfo;
	private String birdInfo;
	private String symbolInfo;

}
