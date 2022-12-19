<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	<h1>게시물별 조회수</h1>
	<table
				class="table text-start align-middle table-bordered table-hover mb-0">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>초등학교 조회수</th>
			<th>중학교 조회수</th>
			<th>고등학교 조회수</th>
			<th>총 조회수</th>
		</tr>

		<tr>
			<th>1</th>
			<th>a001</th>
			<th>템플릿 사용법</th>
			<th>72</th>
			<th>85</th>
			<th>96</th>
			<th>253</th>
		</tr>

		<tr>
			<th>2</th>
			<th>b001</th>
			<th>고등학교 관련문의</th>
			<th>3</th>
			<th>6</th>
			<th>95</th>
			<th>104</th>
		</tr>

		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>



	</table>
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item active"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</div>