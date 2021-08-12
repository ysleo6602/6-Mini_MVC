<%@ page import="spms.vo.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>회원 목록</h1>
<p><a href='add.do'>신규 회원   </a></p>
<%
ArrayList<Member> members = (ArrayList<Member>)request.getAttribute("members");
for(Member member : members){
%>
<%=member.getNo() %>,<a href='update.do?no=<%=member.getNo() %>'><%=member.getName()%></a>,
<%=member.getEmail() %>,<%=member.getCreatedDate() %>
<a href='delete.do?no=<%=member.getNo()%>'>[삭제]</a><br>
<%} %>
<jsp:include page="/Tail.jsp"/>
</body>
</html>