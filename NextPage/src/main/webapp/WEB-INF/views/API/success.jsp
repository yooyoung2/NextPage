<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script>
   function gogo(){
      alert('회원가입에 성공하였습니다!');
      location.href="<%=request.getContextPath() %>/startbootstrap-agency-gh-pages/login/login.jsp";
   }
   function reset(){
	      alert('비밀번호 변경이 성공하였습니다!');
	      location.href="<%=request.getContextPath() %>/startbootstrap-agency-gh-pages/login/login.jsp";
	   }
   function vac_res_success(){
	      alert('백신접종예약에 성공하였습니다!');
	      location.href="<%=request.getContextPath() %>/startbootstrap-agency-gh-pages/login/logonPage.jsp";
	   }
</script>
<%
String reset=(String)request.getAttribute("reset");
if("성공".equals(reset))
{
	%>
	<body onload="reset()">
	<% 
	
}
String vac_res_success=(String)request.getAttribute("vac_res_success");
if("백신 예약 성공".equals(vac_res_success))
{
	%>
	<body onload="vac_res_success()">
	<% 
}else if("백신 예약 실패".equals(vac_res_success)){
	%>
	<body onload="vac_res_success()">
	<% 
	
}
%>

<body onload="gogo()">
</body>
</html>