<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("test", "pageContext TEST");
request.setAttribute("test", "request TEST");
session.setAttribute("test", "session TEST");
application.setAttribute("test", "application TEST");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP TEST</title>
</head>
<body>
테스트중입니다.<br>
<%-- <%=request.getAttribute("result") %> --%>
${list[0]}<br>
${m.t1}<br>
${str[0]}<br>
<hr color="red">
${pageScope.test}<br>
${requestScope.test}<br>
${sessionScope.test}<br>
${applicationScope.test}<br>	
${param.test}

</body>
</html>