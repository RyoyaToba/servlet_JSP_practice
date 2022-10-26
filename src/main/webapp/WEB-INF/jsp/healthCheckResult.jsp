<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Health" %>
<%
	Health health = (Health)request.getAttribute("health");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
身長：<%= health.getHeight() %><br>
体重：<%= health.getWeight() %><br>
BMI：<%= health.getBmi() %><br>
体型：<%= health.getBodyType() %>
</body>
</html>