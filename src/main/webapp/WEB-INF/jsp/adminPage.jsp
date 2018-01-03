<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head>
<title>${title}</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h2>Pagina Administrador</h2>
	<h3>Bienvenido : ${pageContext.request.userPrincipal.name}</h3>
	<b>P&aacute;gina Protegida!</b>
</body>
</html>