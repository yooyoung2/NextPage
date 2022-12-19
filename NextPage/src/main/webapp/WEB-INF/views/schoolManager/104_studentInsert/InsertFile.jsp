<%@page import="kr.or.ddit.vo.SchMemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  



  

	
	
	
	

<style>
.input-file-button{
  padding: 6px 25px;
  margin-left:20px;
  background-color:#FF6600;
  border-radius: 4px;
  color: white;
  cursor: pointer;
}
</style>
	
	
	
	
	
	첨부파일<input type="file" name="boFiles" id="file2" name="file2"  style="display:none" />
			<label class="input-file-button" for="file2" >
  					파일선택<br>
			</label>
		
		
	<table class="table table-bordered">
	
	 
	<%
List<SchMemberVO> list=(List)request.getAttribute("list");
String fileName=(String)request.getAttribute("fileName");


if(list!=null)
{
	List<SchMemberVO> poiList = new ArrayList<SchMemberVO>();
	SchMemberVO poi=new SchMemberVO();
	
	%>
	<tr>
		<th><h3><%=fileName %></h3></th>
		<td colspan="2">
			<form method="post" action="<%=request.getContextPath() %>/school/manager/studentRealInsert" >
			<input type="submit" class="btn btn-success" value="전송">
			<input type="button" class="btn btn-danger" value="취소" onclick="cancelBtn();">
			</form>
		</td>
	</tr>
	
	
	
	<br><br>
	<tr style="background-color:black; color:white">
	<td>이름</td>
	<td>전화번호</td>
	<td>이메일</td>
	<td>주소</td>
	<td>상세주소</td>
	</tr>
	<% 
	int j=0;
	for(SchMemberVO i:list)
	{
		%>
		<tr>
		<td><%=i.getMemNm() %></td>
		<td><%=i.getTelNum() %></td>
		<td><%=i.getMemEmail() %></td>
		<td><%=i.getAddr1() %></td>
		<td><%=i.getAddr2() %></td>
		
		</tr>
		
		<%
		
		}
	%>
	
	<%
	
}

%>

	
	
</table>



<script>
/* $('#file2').click(function(){
	setTimeout(function() {
		alert($('#file2').html());
		}, 5000);
}) */


function cancelBtn() {
	location.href="<%=request.getContextPath()%>/school/manager/student/insert"
}

const input = document.getElementById('file')
const output = document.getElementById('output')

document.getElementById('file2').addEventListener('input', (event) => {
  const files = event.target.files
  var fileName=Array.from(files).map(file => file.name).join('\n');
  
  var file = document.getElementById('file2');
	//파일 경로.
	
	
	var filePath = file.value;
	
	

  
  let f = document.createElement('form');
  
  let obj;
  obj = document.createElement('input');
  obj.setAttribute('type', 'hidden');
  obj.setAttribute('name', 'fileName');
  obj.setAttribute('value', fileName);
  
  f.appendChild(obj);
  f.setAttribute('method', 'get');
  f.setAttribute('action', '/NextPage/school/manager/student/poi/');
  document.body.appendChild(f);
  f.submit();
  
  
  
  
})
</script>











<%-- <form:form method="post" modelAttribute="board" enctype="multipart/form-data">  
<table class="table table-bordered">
	<tr>
		<th>첨부파일</th>
		<td>
			<input type="file" name="boFiles" id="file2"/>
<!-- 			<input type="file" name="boFiles" />
			<input type="file" name="boFiles" />
 -->		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<form:button type="submit" class="btn btn-success">전송</form:button>
			<form:button type="reset" class="btn btn-danger">취소</form:button>
		</td>
	</tr>
</table>
</form:form> --%>










