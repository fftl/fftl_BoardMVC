<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>게시글 작성하기</title>
</head>
<body>
<h1>
	게시글 작성
</h1>
	<form method="POST">
		<p>제목 : <input type="text" name="title"></p>
		<p>닉네임 : <input type="text" name="nickname"></p>
		<p>내용 : <input type="text" name="content"></p>
		<p><input type="submit" value="저장"></p>
	</form>
</body>
</html>
