<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creer Compte</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style1.css"/>" />

</head>
<body>
	<h1>Creer d'un Compte Bancaire</h1>

	<form action="/MiniProjet/CreerCompteNVClient" method="post">
		<fieldset>
			<legend>Information sur le client :</legend>
			<br>
			<c:import url="/EmployePages/GestionClient/inf_client_form.jsp" />
		</fieldset><br>
		<fieldset>
			<legend>Compte Utilisateur :</legend>
			<br>
			<c:import url="/EmployePages/GestionClient/inf_user_form.jsp" />
		</fieldset><br>
		<fieldset>
			<legend>Information sur le compte :</legend>
			<br>
			<c:import url="/EmployePages/GestionCompte/inf_compte_form.jsp" />
		</fieldset>
		<input type="submit" value="Valider" />
	</form>

</body>
</html>