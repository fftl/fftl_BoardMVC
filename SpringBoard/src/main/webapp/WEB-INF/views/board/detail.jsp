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
	<p>제목 : ${ data.title }</p>
	<p>닉네임 : ${ data.nickname }</p>
	<p>작성시간 : <fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd"/></p>	
	<p>내용 : ${ data.content}</p>
	<p><a href="update?boardId=${boardId}">수정</a></p>
	
	<form method="POST" action="/delete">
		<input type="hidden" name="boardId" value="${boardId}"/>
		<input type="submit" value="삭제" />
	</form>
	
	<p>
		<a href="/list">목록으로</a>
	</p>
</body>
</html>
