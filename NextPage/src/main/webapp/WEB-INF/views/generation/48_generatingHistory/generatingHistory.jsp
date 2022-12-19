<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>

</style>
		<div class="site-section">
			<div class="container">
				<h2 style="	margin-left : 30px;"><span style="border-bottom: 4px solid #51be78;">학교연혁</span></h2>
				<div class="row justify-content-center">
				<table class="table table-bordered" width="50%" height="200" cellspacing="5" style="margin:6%;">
   					 <thead class="thead-light">
						<tr class="bg-white">
							<th scope="col">연혁일</th>
							<th scope="col">연혁내용</th>
						</tr>
						
						<c:forEach var = "schHistory" items = "${schHistoryList }">
							<tr>
								<td>${schHistory.histCntnt} </td>
								<td>${schHistory.histDate} </td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
