<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
function submitContents(elClickedObj) {
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

	try {
	    elClickedObj.form.submit();
	} catch(e) {}
}
</script>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#title").keydown(function(key) {
		if (key.keyCode === 13) {
		   key.preventDefault();
		}
	});

	$("#btnUpdate").click(function(){
	
		
		if( $("#title").val() == ""){
			$("#title").val("[제목없음]");
		}

		submitContents($("#btnWrite"));
		$("form").submit();
		
	});
	
});
</script>
<style type="text/css">
form{
	width: 70%;
	margin: 0 auto;
}
</style>

<form action="/board/update" method="post" class="form-horizontal"
enctype="multipart/form-data">
<c:set var="boardno" value="${board.boardno }" scope="session" />
<table class="table table-bordered">

 <tr>
  <td class="info">글제목</td>
  <td colspan="3">
    <input type="text" class="form-control" name="title" id="title" value="${board.title }">
  </td>
 </tr>
 
 <tr>
  <td class="info">아이디</td><td>${userid }</td>
 </tr>

 <tr>
  <td class="info" colspan="4">본문</td>
 </tr>

 <tr>
  <td colspan="4">
  	<textarea class="form-control" id="content" name="content" rows="10" >${board.content }</textarea>
  </td>
 </tr>

 <tr>
  <td class="info">첨부파일</td>
  <td colspan="3">${boardfile.originname } / ${boardfile.filesize }byte&nbsp;&nbsp;&nbsp;${boardfile.writedate }
  <input type="file" name="upfile" />
  </td>
 </tr>
</table>
 
</form>

 <div class="form-group text-center">
	<button type="button" class="btn btn-primary" id="btnUpdate" >수정</button>
	<button type="button" class="btn btn-danger" onclick="location.href='/board/list'">목록</button>
 </div>

<!-- 스마트 에디터 적용 -->
<!-- <textarea>에 스마트에디터의 스킨을 입히는 코드 -->
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors
	, elPlaceHolder: "content"// 에디터가 적용될 <textarea>의 id
	, sSkinURI: "/resources/se2/SmartEditor2Skin.html" // 에디터 스킨
	, fCreator: "createSEditor2"
});
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />