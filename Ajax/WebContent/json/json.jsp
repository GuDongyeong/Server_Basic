<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

// Object
var json = {"a":1, "b":2, "c":"Cherry", "d":true, "e":["1", "2", 3] };
console.log(json)

console.log(json.e)
console.log(json.c)

console.log("----------------------------------")

// JSON 객체 -> JSON 텍스트

// 자바스크립트 내장객체 JSON 이용, String으로 변환
var jsonText = JSON.stringify(json); // 마샬링
console.log(jsonText);

console.log("----------------------------------")

// JSON 텍스트 -> JSON 객체
var jsonObject = JSON.parse( jsonText ); // 언마샬링
console.log(jsonObject);


</script>
</head>
<body>

</body>
</html>