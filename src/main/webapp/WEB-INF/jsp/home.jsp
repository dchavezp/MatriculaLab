<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
	<h1>Home page</h1>
	<p>This is Home page.</p>
	<p>Don't forget: ${thought}</p>
	<p>The last student was: ${personObj.firstName}, ${personObj.age}</p>
	<p>
		<a href="person-form.html">Person page</a> <br />
	</p>
</body>


 <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
</html>
