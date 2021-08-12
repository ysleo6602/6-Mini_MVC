<%@ page import="spms.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
<%
Member member = (Member)request.getAttribute("member");
%>
<h1>회원정보</h1>
<form action='update.do' method='post'>
번호: <input type='text' name='no' value='<%=member.getNo() %>' readonly><br>
이름: <input type='text' name='name' value='<%=member.getName() %>'><br>
이메일: <input type='text' name='email' value='<%=member.getEmail() %>'><br>
가입일: <%=member.getCreatedDate() %><br>
<input type='submit' value='저장'>
<input type='button' value='삭제' onclick='location.href="delete.do?no=<%=member.getNo() %>"'>
<input type='button' value='취소' onclick='location.href="list.do"'>
</form>
</body>
</html>