<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권한 변경</title>
</head>
<body>
<div class="content">
	<h1>권한 변경</h1>
	<table border="1px solid gray">
		<tr>
			<th>권한</th>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>

		</tr>

		<tr>
			<td><select>
					<option value="user">사용자</option>
					<option value="master">운영자</option>
			</select><br></td>
			<td>a002</td>
			<td>구지현</td>
			<td>010-1111-1111</td>
			<td>gujagod@naver.com</td>

		</tr>
	</table>

	<input type="button" value="뒤로">
	<input type="button" value="적용">
</div>