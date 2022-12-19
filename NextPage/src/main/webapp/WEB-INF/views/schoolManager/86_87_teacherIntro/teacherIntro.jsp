<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<title>업무분장</title>

<div class="content">
<h2>업무분장</h2>
    <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-info" style="float: right; margin-right: 35%;">일괄등록</button>
	<br>
	<br>
	<table class="table table-bordered " style="width: 65%;">
    <thead>
      <tr>
        <th>부서</th>
        <th>직위</th>
        <th>성명</th>
        <th>담임</th>
        <th>담당업무</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </tbody>
  </table>
    <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title"></h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <div class="modal-body">
          <div class="container">
			  <table class="table table-borderless" style="width: 48%;">
			    <thead>
			      <tr>
			        <th>양식<br>다운로드 </th>
			        <th><button class="btn btn-info">다운로드</button></th>

			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>일괄등록<br>양식 첨부</td>
			        <td><input type="file" name="file" id="file" class="upload-box upload-plus" accept="image/*"></td>
			    </tbody>
			  </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Upload</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  </div>
