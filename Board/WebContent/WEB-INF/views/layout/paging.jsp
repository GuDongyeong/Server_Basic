<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="text-center">
  <ul class="pagination">
  
  <!-- 첫 페이지로 가기 -->
  <c:if test="${paging.curPage ne 1 }">
<%--   <c:if test="${paging.curPage gt paging.pageCount }"> --%>
  <li><a href="/board/list">&larr;</a></li>
  </c:if>
  
  <!-- 이전 페이징 리스트로 가기 -->
  <c:if test="${paging.startPage gt paging.pageCount }">
  <li><a href="/board/list?curPage=${paging.startPage - paging.pageCount }">&laquo;</a></li>
  </c:if>

  <c:if test="${paging.startPage eq 1}">
  <li><a class="disabled">&laquo;</a></li>
  </c:if>
  
  <!-- 이전 페이지로 가기 -->
  <c:if test="${paging.curPage ne 1 }">
  <li><a href="/board/list?curPage=${paging.curPage-1 }">&lt;</a></li>
  </c:if>
  
  <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
  
    <!-- 현재 페이지라면 강조(.active) -->
    <c:if test="${paging.curPage eq i }">
    <li class="active"><a href="/board/list?curPage=${i }">${i }</a></li>
    </c:if>
    <!-- 현재 페이지가 아니라면 평소 모습 -->
	<c:if test="${paging.curPage ne i }">
    <li><a href="/board/list?curPage=${i }">${i }</a></li>
	</c:if>

  </c:forEach>
  
  <!-- 다음 페이지로 가기 -->
  <c:if test="${paging.curPage ne paging.totalPage }">
  <li><a href="/board/list?curPage=${paging.curPage+1 }">&gt;</a></li>
  </c:if>

  <!-- 다음 페이징 리스트로 가기 -->
  <c:if test="${paging.curPage ne paging.totalPage }">
  <li><a href="/board/list?curPage=${paging.startPage + paging.pageCount}">&raquo;</a></li>
  </c:if>

  <c:if test="${paging.curPage eq paging.totalPage }">
  <li><a class="disabled">&raquo;</a></li>
  </c:if>

  <!-- 마지막 페이지로 가기 -->
  
  <c:if test="${paging.curPage ne paging.totalPage }">
  <li><a href="/board/list?curPage=${paging.totalPage }">&rarr;</a></li>
  </c:if>
  </ul>
</div>