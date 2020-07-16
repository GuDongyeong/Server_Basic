<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<script type="text/javascript">
$(document).ready(function(){

	$("#btnDelete").click(function(){
		var chk = confirm("정말 삭제하시겠습니까?");
		
		if( chk ){
			location.href="/board/delete?boardno="+${board.boardno };
		}
	})
	
	
})
</script>

<div class="container">

<h1>게시글 상세보기</h1>
<hr>

<table class="table table-bordered">
 <tr>
  <td class="info">글번호</td><td colspan="3">${board.boardno }</td>
 </tr>
 
 <tr>
  <td class="info">글제목</td><td colspan="3">${board.title }</td>
 </tr>
 
 <tr>
  <td class="info">아이디</td><td>${board.id }</td>
  <td class="info">닉네임</td><td>${member.usernick }</td>
 </tr>
 
 <tr>
  <td class="info">조회수</td><td>${board.hit }</td>
  <td class="info">추천수</td><td>[추후추가]</td>
 </tr>

 <tr>
  <td class="info">작성일</td><td colspan="3">${board.writtendate }</td>
 </tr>

 <tr>
  <td class="info" colspan="4">본문</td>
 </tr>

 <tr>
  <td colspan="4">${board.content }</td>
 </tr>

 <tr>
  <td class="info">첨부파일</td>
  <td colspan="3">
   <a href="/upload/${boardfile.storedname }" download="${boardfile.originname }">${boardfile.originname } / ${boardfile.filesize }byte</a>
  </td>
 </tr>
</table>
</div>
---- ${boardFile.originname }
<div class="text-center">


</div>

<div class="text-center">
 <button type="button" class="btn btn-primary" onclick="history.go(-1)">목록</button>
<c:if test="${userid eq board.id }">
 <button type="button" class="btn btn-success" onclick="location.href='/board/update?boardno=${board.boardno}'">수정</button>
 <button type="button" class="btn btn-danger" id="btnDelete">삭제</button>
</c:if>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />