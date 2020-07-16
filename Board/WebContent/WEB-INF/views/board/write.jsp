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

	$("#btnWrite").click(function(){
	
		
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

<div class="text-center">
 <h1>글쓰기</h1>
</div>
<form action="/board/write" method="post" class="form-horizontal"
enctype="multipart/form-data">
<table class="table table-bordered">
 
 <tr>
  <td class="info" >글제목</td><td colspan="3"><input style="width: 100%" type="text" name="title" id="title" placeholder="제목을 입력하세요" /></td>
 </tr>
 
 <tr>
  <td class="info">아이디</td><td colspan="3">${userid }</td>
 </tr>

 <tr>
  <td class="info" colspan="4">본문</td>
 </tr>

 <tr>
  <td colspan="4"><textarea id="content" name="content" rows="10" placeholder="내용을 입력하세요" style="width: 100%"></textarea></td>
 </tr>

 <tr>
  <td class="info">첨부파일</td>
  <td colspan="3"><input type="file" name="upfile" /></td>
 </tr>
</table>

</form>

 <div class="text-center">
	<button type="button" class="btn btn-primary" id="btnWrite" >글쓰기</button>
	<button type="button" class="btn btn-danger" onclick="location.href='/board/list'">취소</button>
 </div>
 
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder: "content",
 sSkinURI: "/resources/se2/SmartEditor2Skin.html",
 fCreator: "createSEditor2"
})
</script> 
 
 
<c:import url="/WEB-INF/views/layout/footer.jsp" />