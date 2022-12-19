<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
   function login_fail(){
	      alert('아이디 또는 비밀번호가 다릅니다.');
	      location.href="<%=request.getContextPath() %>/startbootstrap-agency-gh-pages/login/login.jsp";
	   }
   
   function center_login_fail(){
	      alert('아이디 또는 비밀번호가 다릅니다.');
	      location.href="<%=request.getContextPath() %>/startbootstrap-agency-gh-pages/login/login.jsp";
	   }
   
   function admin_login_fail(){
	      alert('아이디 또는 비밀번호가 다릅니다.');
	      location.href="<%=request.getContextPath() %>/startbootstrap-agency-gh-pages/login/login_mng.jsp";
	   }
</script>
123
<%
String loginfail=(String)request.getAttribute("loginfail");
System.out.println("로그인실패"+loginfail);
if("로그인실패".equals(loginfail))
{
	System.out.println("로그인실패"+loginfail);
	%>
	<body onload="login_fail()">
	<% 
	
}
String hsptl_login=(String)request.getAttribute("hsptl_login");
System.out.println("로그인실패"+loginfail);
if("로그인실패".equals(hsptl_login))
{
	

%>
<body onload="center_login_fail()">
<%
}

String admin_login_fail=(String)request.getAttribute("admin_login_fail");
System.out.println("로그인실패"+admin_login_fail);
if("로그인실패".equals(admin_login_fail))
{

%>
<body onload="admin_login_fail()">
<%
}
%>
</body>
</html>