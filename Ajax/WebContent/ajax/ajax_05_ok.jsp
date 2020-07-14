<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<member>
	<dataCount>1</dataCount>

	<record>
		<name>${param.username }</name>
		<content>${param.context }</content>
	</record>
</member>