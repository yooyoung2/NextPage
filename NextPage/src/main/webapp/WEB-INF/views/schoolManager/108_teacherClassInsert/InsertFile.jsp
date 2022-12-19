<%@page import="kr.or.ddit.vo.Join_Year_SCH_VO"%>
<%@page import="kr.or.ddit.vo.Join_Year_SCH_VO"%>
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
	int check=0;
List<Join_Year_SCH_VO> list=(List)request.getAttribute("list");
String fileName=(String)request.getAttribute("fileName");


if(list!=null)
{
	List<Join_Year_SCH_VO> poiList = new ArrayList<Join_Year_SCH_VO>();
	Join_Year_SCH_VO poi=new Join_Year_SCH_VO();
	
	%>
	<tr>
		<th><h3>파일이름: <%=fileName %></h3><br><h5>받아온 데이터 수: <%=list.size() %></h5></th>
		<td colspan="2">
			<form method="post" action="<%=request.getContextPath() %>/school/manager/teacherClassRealInsert" >
			<input type="submit" class="btn btn-success" value="전송" id="check">
			<input type="button" class="btn btn-danger" value="취소" onclick="cancelBtn();">
			</form>
		</td>
	</tr>
	
	
	
	<br><br>
	
	<tr style="background-color:black; color:white">
	<td>사번</td>
	<td>연도</td>
	<td>이름</td>
	<td>학년-반</td>
	</tr>
	
	
	<%
	
					String classesString=(String)session.getAttribute("getClasses");
					int idx = classesString.indexOf("-"); 
					System.out.println("너 getclasses"+classesString);
					String check1=classesString.substring(0,idx);
					String check3=classesString.substring(idx+1);
					System.out.println("건호일단 학년-반"+check1+check3);
					int checkInt1=Integer.parseInt(check1);
					int checkInt3=Integer.parseInt(check3);
					
					
					
					
					
					
					/* if(userCheck1>checkInt1||userCheck3>checkInt3||!"-".equals(userCheck2))
					{
						System.out.println("들어왔닝?");
						model.addAttribute("msg","해당하는 학년-반이 없습니다!");
			            model.addAttribute("url","/school/manager/teacherClass/insert");
						logicalViewName = "schoolManager/108_teacherClassInsert/success";
						return logicalViewName;
					} */
					
	%>
	
	
	
	
	<% 
	int j=0;
	int err=0;
	for(Join_Year_SCH_VO i:list)
	{
		try{
		String userClasses=i.getClasses();
		int idx2 = userClasses.indexOf("-"); 
		int userCheck1=Integer.parseInt(userClasses.substring(0,idx2));
		String userCheck2=userClasses.substring(idx2,idx2+1);
		int userCheck3=Integer.parseInt(userClasses.substring(idx2+1));
		System.out.println("최종: 내꺼, 제한\n"+userCheck1+", "+checkInt1+"\n"+userCheck3+", "+checkInt3+" 마지막"+userCheck2);
		%>
		
		<%if(userCheck1>checkInt1||userCheck3>checkInt3||!"-".equals(userCheck2)){
			check++;
		%>
		<tr class="errorRed">
		<td><%=i.getEdupsnId() %></td>
		<td><%=i.getYear() %></td>
		<td><%=i.getMemNm() %></td>
		<td><%=i.getClasses() %></td>
		</tr>
		
		<%
		} else{%>
		<tr>
		<td><%=i.getEdupsnId() %></td>
		<td><%=i.getYear() %></td>
		<td><%=i.getMemNm() %></td>
		<td><%=i.getClasses() %></td>
		</tr>
		<%}
		}catch(Exception e)
		{check++;%>
			<tr class="errorRed">
			<td><%=i.getEdupsnId() %></td>
			<td><%=i.getYear() %></td>
			<td><%=i.getMemNm() %></td>
			<td><%=i.getClasses() %></td>
			</tr>
			
		<%err++;}
	}
	if(err!=0)
	{
		%><script>
		Swal.fire({
			  icon: 'error',
			  title: 'Error',
			  text: '적절하지 않은 데이터가 들어있습니다! 오류개수: '+<%=check%>,
			})
			</script>
		<%
	}
	%>
	
	<%
	if(check!=0&&err==0)
	{
		%>
		<script>
		document.getElementById('check').disabled=true;
		alert("생성된 학년-반 범위를 초과하는 데이터가 있습니다! 오류개수: "+<%=check%>);
		</script>
		<%
	}
	
}

%>

	
	
</table>
<style>
.errorRed
{
	background-color:red;
}
</style>


<script>
/* $('#file2').click(function(){
	setTimeout(function() {
		alert($('#file2').html());
		}, 5000);
}) */



function cancelBtn() {
	location.href="<%=request.getContextPath()%>/school/manager/teacherClass/insert"
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
  f.setAttribute('action', '/NextPage/school/manager/teacherClass/poi/');
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










