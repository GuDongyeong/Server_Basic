<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/httpRequest.js"></script>
<script type="text/javascript">

// 서버로 AJAX 요청을 보내는 함수
function send(){
	
	console.log("ajaxToServer called")
	
	var n = username.value;
	var c = context.value;
	
	
	// 전달파라미터 준비
	var params = "username=" + n + "&context=" + c;
	
	// URL 구성
	var url = "/ajax/ajax_05_ok.jsp";
	
	// AJAX 요청
	sendRequest("POST", url, params, collback)
	
	

}

// AJAX 요청 처리 콜백 함수
function collback(){
	
	// 서버로부터 온 ajax응답 처리
	if(httpRequest.readyState == 4){ // DONE 단계
		if(httpRequest.status == 200){ // HTTP 200, OK.
			console.log("정상응답")
			
// 			console.log(httpRequest.responseText);
			
			// 정상 응답 처리 함수
			appendResult();
			
		}else{
			console.log("AJAX 요청/응답 에러");
			
		}
	}
	
}

// 결과 <div>를 추가해주는 함수
function appendResult(){
	console.log("appendResult called");
	
	console.log("--- responseText ---")
	console.log(httpRequest.responseText)
	
	console.log("--- responseXML---")
	console.log(httpRequest.responseXML)
	
	// XML 데이터를 추출하기(파싱, parsing)
	//	XML Document객체에는 getElementById("idname") 을 사용할 수 없다
	
	//	getElementsByTagName("tagname")을 사용해야 한다
	
	// 응답받는 XML 데이터
	var resultData = httpRequest.responseXML;
	console.log(resultData)
	
	// member 태그 객체 얻기 - 배열로 반환함
	var member = resultData.getElementsByTagName("member");
	console.log( member[0] );
	
	// record 태그 객체 얻기 - 배열로 반환함
	var record = member[0].getElementsByTagName("record");
	console.log(record[0]);
	
	// name 태그, context 태그 객체 얻기 - 배열로 반환
	var username = record[0].getElementsByTagName("name")[0];
	var context = record[0].getElementsByTagName("content")[0];
	
	console.log("--- username ---")
	console.log(username);
	
	console.log("--- context ---")
	console.log(context)
	
	// 태그의 자식 텍스트 데이터 꺼내기
	var nameData = username.firstChild.nodeValue;
	var contentData = context.firstChild.nodeValue;
	
	console.log("--- nameData ----")
	console.log(nameData);
	console.log("--- contentData ---")
	console.log(contentData)
	
	//div#result 에 <div> 추가하기
	resultLayout.innerHTML += "<div>" + nameData + ", " + contentData + "</div>";
	
}
</script>
</head>
<body>

<h1>AJAX 05</h1>
<hr>

<!--  이름, <input>태그, id="username" -->
<!--  내용, <input>태그, id="context" -->

<!--  이름, 내용 두 가지 데이터를 ajax_04_ok.jsp로 전송 -->
<!--  전송한 데이터를 이용하여 응답 데이터로 작성한다 -->

<!-- 응답 받은 데이터를 이용하여 <div>를 생성하고 그 안에 데이터를 기록 -->

<!-- 형식
	<div>
		name : Alice
		content: 안녕하세요!
		
		Alice님, 안녕하세요!
	</div>
-->

<!-- 응답받은 <div>데이터는 <button>하단에 계속해서 추가되도록 만든다 -->

<form name="f"> 
<!-- name 없어도됨 -->
이름 : <input type="text" id="username" name="username" /><br>
내용 : <br><textarea id="context" name="context" ></textarea><br><br>

	<button type="button" onclick="send();">전송</button>
</form>

<hr>
<div id="resultLayout"></div>

</body>
</html>