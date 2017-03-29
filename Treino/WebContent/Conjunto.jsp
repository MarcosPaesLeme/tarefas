<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import=" model.Conjunto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conjunto</title>
</head>
<body>
<%Conjunto conjunto = (Conjunto)request.getAttribute("conjunto"); %>
<%String resultado = (String)request.getAttribute("resultado"); %>
<%String oQueFazer = (String)request.getAttribute("oQueFazer"); %>

<h3><%=oQueFazer %> Cliente</h3>
	<%=resultado %>
	<input type="button" value="Voltar" onClick="history.go(-1)"> 
</body>
</html>