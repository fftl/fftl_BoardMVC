<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>상세페이지</title>
</head>
<body>
<h1>
	상세페이지
</h1>
	<form method="POST" action="/update">
		<p>제목 : <input type="text" name="title" value="${ data.title }"></p>
		<p>닉네임 : <input type="text" name="nickname" value="${ data.nickname }"></p>
		<p>작성시간 : <fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd"/></p>	
		<p>내용 : <input type="text" name="content" value="${ data.content}"></p>	
		<input type="hidden" name="boardId" value="${ data.board_id }"/>
		<input type="submit" value="저장" />
	</form>
	<p>
		<a href="/list">목록으로</a>
	</p>
</body>
</html>
