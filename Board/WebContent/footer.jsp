<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">

#info1 {text-align: center; }
/* #info2 {background-color: red; } */
/* #info3 {background-color: yellow; } */
/* #info4 {background-color: blue; } */
/* #info5 {background-color: green;} */


#wrap {
	border:  1px solid #ccc;

	width: 980px;
 	
	/* 외부정렬 */
 	margin: 0 auto; 

	/* <table>처럼 레이아웃 설정됨 */
	display: table;
	
	/* 내용물(table-cell)의 크기가 일정하도록 설정 */
	table-layout: fixed;
	
	border-right:none;

	border-left:none;
	
	border-top:none;

	border-bottom:none;
}

#wrap > div {
	width: 25%; /* 4개 */
	
	height: 130px;
	
	/* 테이블의 내용물(tabl-cell ,td, th)처럼 레이아웃 설정됨 */
	display: table-cell;
	
	/* table-cell, inline에서 사용 가능  */
	
	/* 수직 정렬 : 중앙 */
	vertical-align: middle;
	
	/* 내부 정렬 : 가운데 */
	text-align: center;  
	
	
}

</style>


<div class="container"> <!-- 가운데 오게 하기  -->

<br>
<hr>
<div id="info1" >	
<a href="#">서비스 이용약관</a>&nbsp;&nbsp;
<a href="#">개인정보 처리방침</a>&nbsp;&nbsp;
<a href="#">제작자 소개</a>&nbsp;&nbsp;
<a href="#">사이트 소개</a>&nbsp;&nbsp;
</div>

<br>

<div id="wrap" >

<div id="info2" >
<!-- <img alt="오디씨 로고" src="/resources/img/odc.png"> -->
</div>

<div id="info3" >
<small>(주) 오디씨</small><br><br>
<small>전화 010-1234-5789</small><br><br>
<small>주소 서울 강남 KH빌딩</small><br><br>
<small>사업자 번호 012 - 3456 - 7890</small>
</div>

<div id="info4" >
<small>고객센터  : 월-금 ( 9:00- 18:00)</small><br><br>
<small><a>카카오톡 오디씨</a></small><br><br>
<small>메일 abc12345@gamil.com</small>
</div>

<div id="info5" style="font-size: 35px;" >
<a href="#"><div class="glyphicon glyphicon-phone"></div></a>
<a href="#"><div class="glyphicon glyphicon-envelope"></div></a>
<a href="#"><div class="glyphicon glyphicon-map-marker"></div></a>
</div>

</div>
</div>
</body>
</html>