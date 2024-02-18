<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help Page</title>
</head>
<body>
	<h1>This is Help Page</h1>

	<%
	/* String name = (String) request.getAttribute("name");
	Integer rollnumber = (Integer) request.getAttribute("rollnumber");
	LocalDateTime time = (LocalDateTime) request.getAttribute("time"); */
	%>

	<h1>
		My Name is :
		<%-- <%=name%> --%>
		${name }
	</h1>
	<h1>
		My Rollnumber is :
		<%-- <%=rollnumber%> --%>
		${rollnumber }
	</h1>

	<h1>
		Current time is:
		<%-- <%=time%> --%>
		<!-- time.toString()  -->
		${time }
	</h1>

	<hr>
	<%-- <h1>${marks }</h1> --%>
	<c:forEach var="item" items="${marks}">
		<%-- <h1>${item }</h1> --%>
		<h1>
			<c:out value="${item }"></c:out>
		</h1>
	</c:forEach>

</body>
</html>