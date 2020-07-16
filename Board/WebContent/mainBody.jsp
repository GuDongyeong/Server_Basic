<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- header 임포트 -->
<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">

.mainImg > img{
	width: 100%;
	height: 300px;
}

.classIntro > img{
	border: 1px solid black;
	
	width: 80%;
	height: 200px;
}

.classIntro{
	text-align: center;
	display: inline-block;
	width: 30%;

}
.classWrap{
	text-align: center;
}

.classTitle, .classinfo{
	text-align: none;
	padding: 0;
	margin: 0;
}

.mainAc{ color: black;}

.mainAc:link{
	text-decoration: none;
}
.mainAc:visit{
	text-decoration: none;
	color: black;
}
.mainAc:hover{
	text-decoration: none;
	color: black;
}

.wrapperClassBox{
	white-space: nowrap;
	width: 1100px;
	margin: 0 auto;
}
</style>

<div class="container">

	<div class="mainImg">
  	 <img alt="image" src="/resources/mainImg.jpg"/>
 	</div>
 	<hr>
 	
	<section class="wrapperClassBox" >
	<div style="font-size: 15pt;">
	 <a class="mainAc" href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><strong>&nbsp;인기 클래스</strong></a>
	</div>
	<br>
	<div class="row">
	  <div class="col-xs-5 col-xs-4">
	    <div class="thumbnail">
	      <img src="/resources/mini.jpg" alt="...">
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
	      <img src="/resources/mini.jpg" alt="...">
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
	      <img src="/resources/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
	      </div>
	    </div>
	 </div>
	</div>
	</section>
	<hr>
	<section class="wrapperClassBox">
	<div style="font-size: 15pt;">
	 <a class="mainAc" href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><strong>&nbsp;신규 클래스</strong></a>
	 </div>
	 	<br>
	<div class="row">
	  <div class="col-xs-5 col-xs-4">
	    <div class="thumbnail">
	      <img src="/resources/mini.jpg" alt="...">
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
	      <img src="/resources/mini.jpg" alt="...">
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
	      <img src="/resources/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
	      </div>
	    </div>
	 </div>
	</div>
	</section>
	<hr>
	<section class="wrapperClassBox">
	<div style="font-size: 15pt;">
	 <a class="mainAc" href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><strong>&nbsp;재능기부 클래스</strong></a>
	 </div>
	 <br>
	<div class="row">
	  <div class="col-xs-5 col-xs-4">
	    <div class="thumbnail">
	      <img src="/resources/mini.jpg" alt="...">
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
	      <img src="/resources/mini.jpg" alt="...">
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
	      <img src="/resources/mini.jpg" alt="...">
	      <div class="caption">
	        <h3>Class Title</h3>
	        <p>클래스 설명클래스 설명클래스 설명클래스 설명</p>
	        <p>&nbsp;60,000원</p>
	        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
	      </div>
	    </div>
	 </div>
	</div>
	</section>

</div>


<c:import url="/footer.jsp" />