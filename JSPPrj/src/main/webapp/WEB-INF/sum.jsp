<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int x = 3;
	int y = 4;	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Calculator
	<form action="/hyunsense/sum.jsp" method="post">
		<ul>
			<li><label for="x">X :</label><input name="x" /></li>
			<li><label for="y">Y :</label><input name="y" /></li>
		</ul>
		<p><input type="submit" value = "sum"/></p>	
		<p>sum : <%= (x+y) %></p>
	</form>
</body>
</html>