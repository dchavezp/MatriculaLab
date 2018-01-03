<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Matricula</title>
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script>
	$(document).ready(function() {
		$.post("../student/listCourses"), function(data) {
			$('#list_user').html(data);
		}
	});
</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h2>Lista de Cursos</h2>
	<h3>Usuario : ${pageContext.request.userPrincipal.name}</h3>
	<form>
		<table cellspacing="0" width="80%">
			<tr>
				<th>Nro</th>
				<th>Curso</th>
				<th>Grupo</th>
			</tr>
			<tbody id="list_user">

			</tbody>
		</table>
		<input type="submit" value="Matricularse"><a
			href="${pageContext.request.contextPath}/student/listCourses">refrescar</a>
	</form>
</body>
</html>