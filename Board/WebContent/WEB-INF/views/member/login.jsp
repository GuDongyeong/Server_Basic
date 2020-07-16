<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	
	// 페이지 접속 시 입력창으로 포커스
	$("input").eq(0).focus();
	
	// 패스워드 입력창에서 엔터 누르면 submit
	$("input").eq(1).keydown(function(key){
		if(key.keyCode == 13 ){
			$(this).parents("form").submit();
		}		
	});
	
	// 로그인 버튼 누르면 form submit
	$("#btnLogin").click(function(){
		$(this).parents("form").submit();
	});
	
	//취소 버튼 누르면 이전 페이지로
	$("#btnCancel").click(function(){
		history.go(-1);
	})
	
	
	
});
</script>

<style type="text/css">
#loginForm{
	width: 300px;
	margin: 0 auto;
}
</style>

<div class="text-center">
<h1>로그인</h1>
</div>

<hr>

<form action="/member/login" method="post" id="loginForm">
  <div class="form-group">
    <label for="uid">아이디 </label>
    <input type="text" name="uid" id="uid" class="form-control" placeholder="아이디를 입력하세요">
  </div>
  <div class="form-group">
    <label for="upw">패스워드</label>
	<input type="text" name="upw" id="upw" class="form-control" placeholder="비밀번호를 입력하세요">
  </div>
  <div class="text-center">
  	<button type="button" id="btnLogin" class="btn btn-primary">로그인</button>   	
  	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
  </div>
</form>

<c:import url="/WEB-INF/views/layout/footer.jsp" />