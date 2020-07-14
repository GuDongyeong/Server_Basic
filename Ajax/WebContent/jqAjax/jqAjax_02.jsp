<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#btnCalc").click(function(){
		
		// 요청 URL
		var url = "/jqAjax/jqAjax_ok.jsp";
		
		
		// 요청 파라미터
		var data = {
				"num1": $("#num1").val()
				, "num2": $("#num2").val()
				, "oper": $("#oper").val()
		}

		// AJAX 요청 보내기 - $.get(), $.post()
// 		$.get( url, data, function(res){
// 			$("#resultLayout").html(res)
			
// 			// 결과값 추가하기
// //		$("#resultLayout").html($("#resultLayout").html() + res)
// 		});
		
		$.post( url, data, function(res){
			$("#resultLayout").html(res)
		});
		
	});
});
</script>
</head>
<body>

<h1>jQuery AJAX 계산기 02</h1>

<input type="text" id="num1" />
<select id="oper">
	<option value="add">더하기</option>
	<option value="sub">빼기</option>
	<option value="mul">곱하기</option>
	<option value="div">나누기</option>
</select>

<input type="text" id="num2" />

<button id="btnCalc"> = </button>

<hr>

<div id="resultLayout"></div>


</body>
</html>