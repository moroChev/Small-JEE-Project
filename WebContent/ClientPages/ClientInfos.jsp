<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon Profil</title>
</head>
<body>
	<c:import url="/WEB-INF/ClientPages/AcceuilClient.jsp" />
	
	<h1>Mon Profil</h1>
	<p>
		votre Nom :
		<c:out value="${ sessionScope.client.nom }" />
	</p>

	<p>
		votre Prenom :
		<c:out value="${ sessionScope.client.prenom }" />
	</p>

	<p>
		votre Date naissance :
		<c:out value="${ sessionScope.client.dateNaissance }" />
	</p>

	<p>
		votre telephone :
		<c:out value="${ sessionScope.client.telephone }" />
	</p>

	<p>
		votre Email :
		<c:out value="${ sessionScope.client.email }" />
	</p>

	<p>
		votre agence :
		<%-- 		<c:out value="${ param.prenom }" /> --%>
	</p>

</body>
</html>