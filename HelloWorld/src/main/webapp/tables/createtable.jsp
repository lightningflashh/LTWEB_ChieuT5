<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.chithanh.connector.ConnectionProvider" %>
<%@ page import="java.sql.*" %>

<%
	try{
		
		Connection conn = ConnectionProvider.getConnection();
		Statement st = conn.createStatement();
		
	} catch (Exception e) {
		
	}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>