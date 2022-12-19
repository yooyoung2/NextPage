<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

<%-- <link href="<%=request.getContextPath()%>/resources/css/History.css" --%>
<!-- 	rel="stylesheet" /> -->







<title>교직원 개별 수정</title>
</head>

<!-- 우선 body 부분에 input tag를 하나 만들어준다. -->
<body>



		
		
		
		
		
		
<div class="content">
	<div id="all">
		<div id="historyNameArea">
			<h3>담임 학년-반 등록</h3>
		</div>
		
		
		
		
		
<%
	
	String getClasses=(String)session.getAttribute("getClasses");
	System.out.println("넘어왔니?"+getClasses);
	int idx = getClasses.indexOf("-"); 
	int Grade=Integer.parseInt(getClasses.substring(0,idx));
	System.out.println("넘어왔니?"+Grade);
	int room=Integer.parseInt(getClasses.substring(idx+1));
	System.out.println("넘어왔니?"+room);
	List<String> list=(List<String>)session.getAttribute("classesList");
	int index=0;
	%>
<!-- 	<table style="border: 1px solid red; float:left;" > -->
<%-- 	<%for(int i=0;i<Grade;i++){ %> --%>
<!-- 		<tr style="border: 1px solid red;"> -->
		
<%-- 		<%for(int j=0;j<room;j++){ %> --%>
<%-- 			<td style="border: 3px solid black; text-align : center; vertical-align : middle;" id="table<%=i %><%=j %>" > --%>
<%-- 			<pre style=" "><%=i+1 %>-<%=j+1 %></pre> --%>
<!-- 			</td> -->
<%-- 			<%} %> --%>
			
<!-- 		</tr> -->
<%-- 		<%} %> --%>
<!-- 		</table> -->
		
		<script>
		window.onload=function(){
			
			<%for(int i=0;i<list.size();i++){
				int idx2 = list.get(i).indexOf("-"); 
				String gradeList=list.get(i).substring(0,idx);
				int grade2=Integer.parseInt(gradeList)-1;
				String roomList=list.get(i).substring(idx+1);
				int room2=Integer.parseInt(roomList)-1;
			%>
			document.getElementById('table<%=grade2%><%=room2%>').style.background='black'; 
			
			
			
			
			<%}%>
			
			<%
			for(int i=0;i<Grade;i++){
				
				for(int j=0;j<room;j++)
					{%>
					document.getElementById('table<%=i%><%=j%>').innerHTML="<h5><%=i+1 %>-<%=j+1 %></h5>";		
					<%}
			}
			%>
			
		}
		</script>
		
		
		
		
		
		
		
		
		
		
		<div id="tableArea">										
			<form:form modelAttribute="member" method="post">
	<table class="table table-bordered">
		<tr>
			<th>사번</th>
			<td>
				<form:input path="edupsnId" class="form-control" required="true" readonly="true"/>
				<form:errors path="edupsnId" element="span" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th>연도</th>
			<td>
				<form:input path="year" class="form-control" required="true" readonly="true"/>
				<form:errors path="year" element="span" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<form:input path="memNm" class="form-control" required="true" readonly="true"/>
				<form:errors path="memNm" element="span" cssClass="error" />
			</td>
		</tr>
		<tr>
			<th>학년-반</th>
			<td>
				<form:input path="classes" class="form-control" required="true" />
				<form:errors path="classes" element="span" cssClass="error" />
			</td>
		</tr>
		
		
	
		<tr>
			<td id="inputTags">
				<input type="submit" class="btn btn-primary insert" value="수정" />
				<input type="button" class="btn btn-primary insert" value="취소" onclick="cancelBtn();"/>
			</td>
		</tr>
		
		
		</table>
	</form:form>
	
	
	
	
	
	
	
	
		</div>
	</div>
	
	
</div>
</body>
<script>

function cancelBtn() {
	location.href="<%=request.getContextPath()%>/school/manager/teacherClass/insert"
}
</script>


