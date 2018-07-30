<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<h2>hiiii</h2>
	<form action=" ${pageContext.request.contextPath}/display"  method="post">
		<center>
			<input type="text" name="name"> <input type="submit"
				value="submit">
		</center>
	</form>
</body>
</html>
