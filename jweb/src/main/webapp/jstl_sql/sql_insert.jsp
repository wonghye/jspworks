<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sql insert 예제</title>
</head>
<body>
	<h2>회원 가입</h2>
	<form action="./insertProcess.jsp" method="post">
		<p>아이디 : <input type="text" name="eid">
		<p>패스워드 : <input type="password" name="passwd">
		<p>이 름 : <input type="text" name="name">
		<p><input type="submit" value="등록">
	</form>
</body>
</html>