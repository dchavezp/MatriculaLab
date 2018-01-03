<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Matricula</title>
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script>
	$(document).ready(function() {
		$.get("../student/listCourses"), function(data) {
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