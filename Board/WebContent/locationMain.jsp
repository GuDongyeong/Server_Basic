<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp" />
<!-- 사이드 메뉴바 -->
<style type="text/css">
body {
    margin:20px auto;
    padding: 0;
    font-family:sans-serif; 
}

ul#navi {
    width: 100%;
    list-style:none;
    background:#F6D6FD;
    margin:0;
    padding:0;
}

ul#navi, ul#navi ul {
    list-style:none;
    margin:0;
    padding:0;
    width: 100%;
}


ul.sub li {
    margin: 0;
    height:35px;
    line-height:35px;
    cursor:pointer;
}
ul.sub li a {
    display: block;
    width: 100%;
    height:100%;
    text-decoration:none;
    text-align: center;
    padding: 0;
}
ul.sub li:hover {
    background:#DE9DED;
}
</style>

<style type="text/css">

#wrapper{
	width: 1200px;
	margin: 20px auto;

	border: 1px solid #ccc;

}

#sidenav {
	float: left;

	width: 28%;
	height: 700px;

	border: 1px solid red;

}

#main{
/*    background-color:tomato; */
	float: right;

	width: 68%;
	height: 700px;

	border: 1px solid green;

}

.classimg{
	width: 300px;
	height: 200px;
	border: 1px solid #ccc;
}

.aTagStyleNone {
    text-decoration : none;
    color : black;
}
</style>

<div id="wrapper">
<h3>지역별 클래스</h3>
<hr>
<div id="sidenav">
	<ul id="navi">
        <li class="group">
            <ul class="sub">
                <li><a href="#">전체</a></li>
                <li><a href="#">서울</a></li>
                <li><a href="#">경기</a></li>
                <li><a href="#">강원</a></li>
                <li><a href="#">충청</a></li>
                <li><a href="#">경상</a></li>
                <li><a href="#">전라</a></li>
                <li><a href="#">제주</a></li>
            </ul>
        </li>
    </ul>
</div>


<div id="main">
	<h4>지역명</h4>
	<hr>
	<div class="col-xs-5 col-xs-4">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
	      </div>
	    </div>
	  </div>
	<div class="col-xs-5 col-xs-4">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
	      </div>
	    </div>
	  </div>
	<div class="col-xs-5 col-xs-4">
	    <div class="thumbnail">
	      <img src="/resources/img/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
	      </div>
	    </div>
	  </div>
</div>

</div>

<div class="clearfix"></div>
<hr>

<c:import url="/footer.jsp" />