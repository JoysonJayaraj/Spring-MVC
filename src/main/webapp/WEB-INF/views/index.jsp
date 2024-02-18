<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<h1>This is Home Page</h1>
	<h1>Called by Home Page</h1>
	<h1>url /home</h1>
	<h1>Name is Durgesh</h1>

	<%
	String name = (String) request.getAttribute("name");
	%>

	<h1>
		Name is
		<%=name%></h1>

	<%
	Integer id = (Integer) request.getAttribute("id");
	%>
	<h1>
		ID is :
		<%=id%></h1>

	<%
	List<String> friends = (List<String>) request.getAttribute("frnd");
	%>

	<%-- <% for(String s : friends) {
		out.println(s);
	}
	%> --%>

	<%
	for (String s : friends) {
	%>
	<h1><%=s%></h1>
	<%
	}
	%>

</body>
</html>