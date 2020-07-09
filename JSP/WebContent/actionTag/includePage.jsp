<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div>
<h3>여기는 서브페이지</h3>
<p>include 된 페이지 영역입니다</p>
</div>

<p>전달 파라미터 : <%=request.getParameter("date") %></p>
<p>컨텍스트 : <%=request.getAttribute("requestDate") %>