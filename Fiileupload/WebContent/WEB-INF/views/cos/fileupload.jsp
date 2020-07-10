<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>파일업로드 Form</h1>
<h3>COS Fileupload</h3>
<hr>

<form action="/cos/fileupload" method="post" 
enctype="multipart/form-data">
<!-- enctype="application/x-www-form-urlencoded"> -->


<label>제목 : <input type="text" name="title"/></label><br>
<label>닉네임 : <input type="text" name="nick"/></label><br>

<label>파일 : <input type="file" name="upfile"/></label><br>

<button>전송</button>

</form>



</body>
</html>