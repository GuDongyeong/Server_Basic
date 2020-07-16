<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="container">
<h1>게시글 목록</h1>
<hr>

<table class="table table-striped table-hover table-condensed">
<tr class="success">
	<th style="width: 15%;">글번호</th>
	<th style="width: 45%;">제목</th>
	<th style="width: 15%;">아이디</th>
	<th style="width: 10%;">조회수</th>
	<th style="width: 15%;">작성일</th>
</tr>
<c:forEach var="iter" items="${list }">
<tr>
	<td>${iter.boardno }</td>
	<td><a href="/board/view?boardno=${iter.boardno }">${iter.title }</a></td>
	<td>${iter.id }</td>
	<td>${iter.hit }</td>
	<td>${iter.writtendate }</td>
</tr>
</c:forEach>

</table>

<button type="button" class="btn btn-default" onclick="location.href='/board/write'">글쓰기</button>

<c:import url="/WEB-INF/views/layout/paging.jsp"/>

</div><!-- div.container -->


<c:import url="/WEB-INF/views/layout/footer.jsp" />