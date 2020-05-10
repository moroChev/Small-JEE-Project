<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style1.css"/>" />
<title>Login Page</title>
</head>
<body>
	<h1>Banque ONLINE</h1>

	<fieldset>
		<legend>Authentification</legend>
		<form action="/MiniProjet/Authentification" method="POST">
			<label for="nomClient">Login </label> 
			<input type="text" name="Login" value="" size="40" maxlength="50" /> <br /> 
			<label for="prenomClient">Password</label>
			<input type="text" name="Password" value=""size="40" maxlength="50" /> <br />
			<input type="submit" value="Valider" />		
		</form>
	</fieldset>
</body>
</html>