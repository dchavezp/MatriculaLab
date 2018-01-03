<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head>
<title>${title}</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h2>Pagina de Estudiante</h2>
	<h3>Bienvenido : ${pageContext.request.userPrincipal.name}</h3>
	<b>Para ver sus cursos haga click<a href="${pageContext.request.contextPath}/student/registration"> aqu&iacute;</a></b>
</body>
</html>