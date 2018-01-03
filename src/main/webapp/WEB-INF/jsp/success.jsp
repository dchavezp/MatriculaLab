<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head>
<title>Completado</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h2>Listo, se ha registrado su matricula</h2>
	<b>Para ver sus cursos registrados click<a href="${pageContext.request.contextPath}/student/listCoursesReg"> aqu&iacute;</a></b>
</body>
</html>