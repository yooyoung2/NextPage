package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(of="otoBrdNum")
@Data
@ToString(exclude= {"otoBrdCntnt"})
public class MyQuestionVO{
	@NotNull(groups= {UpdateGroup.class, DeleteGroup.class}) 
	private Integer otoBrdNum;
	
	private String schId;
	
	private String otoBrdTitle;
	
	private String otoBrdCntnt;
	
	private String prgrsCndtn;
	
	private String wrteDate;
}
