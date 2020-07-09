<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>fmt:foramtNumber</h1>
<hr>

<fmt:formatNumber value="1234567890"/><br>
<fmt:formatNumber value="1234567890" type="number"/><br>
<fmt:formatNumber value="1234567890" type="currency"/><br><%-- \--%>
<fmt:formatNumber value="1234567890" type="percent"/><br>

<hr>
<fmt:formatNumber value="1234567890" type="number" groupingUsed="false"/>

<hr>
<fmt:formatNumber value="1234567890" type="currency" currencySymbol="$"/>

<hr>
<fmt:formatNumber value="1234567890" type="currency" currencySymbol="$" minFractionDigits="2"/><%-- minFractionDigits : 최소 소수점 유지 수 --%>

<hr>
<%-- minFractionDigits : 최소 소수점 자리수 지정 --%>
<fmt:formatNumber value="123" type="currency" currencySymbol="$" minFractionDigits="5"/>

<hr>
<%-- minIntegerDigits : 정수자리수 지정 --%>
<fmt:formatNumber value="123" type="currency" currencySymbol="$" minIntegerDigits="5"/>

<hr>
<%-- 자동 소수점 반올림 해줌 --%>
<fmt:formatNumber value="12345.60" type="currency" currencyCode="USD"/>

<hr>
<fmt:formatNumber value="12345.60" type="currency" currencyCode="JPY"/>

<hr>
<fmt:formatNumber value="12345.67890" type="number" pattern="##,###.#"/>

<hr>
<%-- 정수부분은 부족해도 모두 나옴 12,345.679 --%>
<fmt:formatNumber value="12345.67890" type="number" pattern="#,###.###"/>

<hr>
<%-- , 한번만 써도 알아서 모두 나옴 --%>
<fmt:formatNumber value="12234234345.67890" type="number" pattern="#,###.###"/>

<hr>
<fmt:formatNumber value="12345.67890" type="number" pattern="00000000000.0000000000"/>

<hr>
<fmt:formatNumber value="12345.6" type="number" pattern="#,###.00"/>

<hr>
<fmt:formatNumber value="12345.6" type="number" pattern="$#,###.00"/>

<hr>
<fmt:formatNumber value="12345.6" type="number" pattern="USD#,###.00"/>

<hr>

</body>
</html>