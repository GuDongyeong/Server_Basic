<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	
	// 페이지 접속 시 입력창으로 포커스
	$("input").eq(0).focus();
	
	// 닉네입 입력창에서 엔터 입력 시 form submit
	$("input").eq(2).keydown(function(key){
		
		if(key.keyCode == 13){
			$(this).parents("form").submit();			
		}
	})
	
	// 로그인 버튼 클릭시 form submit
	$("#bntJoin").click(function(){
		$(this).parents("form").submit();
	})
	
	//취소 버튼 클릭 시 이전 페이지로
	$("#btnCancel").click(function(){
		history.go(-1);
	})
	
	// 아이디 중복 검사 AJAX
	$("#uid").blur(function(){
		
		if( $("#uid").val() == "" ){
			$("#idUnable").text("아이디를 입력하세요");
		}else{
			$("#idUnable").html("");
			
			$.ajax({
				type: "post"// 요청 메소드
				, url: "/join/idcheck" // 요청 url
				, data: {
					"id":$("#uid").val()
				}
				, dataType: "html"
				, success: function(res){
					
					var jsonObj = JSON.parse(res);
					
					if( jsonObj.chk ){
						$("#idUnable").html("")
						$("#idAble").html(jsonObj.message)
					}else{
						$("#idAble").html("")
						$("#idUnable").html(jsonObj.message)
					}
				}
				, error: function(){
					console.log("AJAX 실패")
				}
			});
			
		}
		
	})
});
</script>

<style>
form{
	width: 400px;
	margin: 0 auto;
}
</style>
<div class="text-center">
<h1>회원가입</h1>
</div>

<hr>

<form action="/member/join" method="post">
  <div class="form-group">
    <label for="uid">아이디</label>
    <input type="text" name="uid" id="uid" class="form-control" placeholder="아이디를 입력하세요">
  </div>
  <div id="idUnable" class="form-group" style="color: red;"></div>
  <div id="idAble" class="form-group" style="color: green;"></div>
  <div class="form-group">
    <label for="upw">비밀번호</label>
    <input type="text" name="upw" id="upw" class="form-control" placeholder="비밀번호를 입력하세요">
  </div>
  <div class="form-group">
    <label for="unick">닉네임</label>
    <input type="text" name="unick" id="unick" class="form-control" placeholder="닉네임 입력하세요">
  </div>
   <div id="nickVal" class="form-group"></div>
  <div class="text-center">
  	<button type="button" id="btnJoin" class="btn btn-primary">회원가입</button>   	
  	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
  </div>
</form>


<c:import url="/WEB-INF/views/layout/footer.jsp" />