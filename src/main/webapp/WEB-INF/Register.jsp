<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String error = (String) request.grtAttribute("error") %>
<%  if(error!=null) { %>
<p>style="color:red"</p><%= error %>
<% } %>
<form action="reg" method="post">
Id:<input type="number" placeholder="Enter Id" name="id">
Name:<input type="text" placeholder="Enter Name" name="name">
<input type="submit">
</form>
</body>
</html>