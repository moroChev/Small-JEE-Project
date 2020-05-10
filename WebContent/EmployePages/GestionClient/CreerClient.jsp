<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style1.css"/>" />
<title>Creer Client</title>



</head>
<body>
	<h1>Creation d'un client</h1>


	<form action="/MiniProjet/CreerClient" method="get">
		<fieldset>
			<legend>Creation du Profil</legend>
			<c:import url="/EmployePages/GestionClient/inf_client_form.jsp"></c:import>
		</fieldset>

		<fieldset>
			<legend>Creation du Compte Utilisateur</legend>
			<c:import url="/EmployePages/GestionClient/inf_user_form.jsp"></c:import>
		</fieldset>
		<input type="submit" value="Valider" />
	</form>


</body>
</html>