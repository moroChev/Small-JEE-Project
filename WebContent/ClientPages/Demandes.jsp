<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes Demandes</title>
</head>
<body>
	<c:import url="/WEB-INF/ClientPages/AcceuilClient.jsp" />

	<h1>Mes Demandes</h1>

	<p>Vous avez X demandes</p>
	
	<p>
		Numèro demande :
		<%-- 		<c:out value="${  }" /> --%>
	</p>
	
	<p>
		date demande :
		<%-- 		<c:out value="${  }" /> --%>
	</p>
	
	<p>
		Montant demande :
		<%-- 		<c:out value="${  }" /> --%>
	</p>
	
	<p>
		Etat demande :
		<%-- 		<c:out value="${  }" /> --%>
	</p>
	


</body>
</html>