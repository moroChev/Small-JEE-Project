<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style1.css"/>" />
<title>Creation Compte</title>
</head>
<body>
	<h1>Creation Ancien client</h1>

	<form action="/MiniProjet/ChercherClient">
		<fieldset>
			<legend>Trouver le Client :</legend>
			<label for="idClient">Num�ro du Client :</label> 
			<input type="text" id="idClient" name="idClient" value="" size="30" maxlength="30" />
			<input type="submit" value="Valider" />
		</fieldset>
	</form>
	
		<c:if test="${ !empty requestScope.client }">
				<fieldset>
					<legend>Informations du client :</legend>
						<p>Nom : <c:out value="${ client.nom }" /> </p>
						<p>Pr�nom : <c:out value="${ client.prenom }" /></p>
						<p>Date de naissance : <c:out value="${ client.dateNaissance }" /></p>
						<p>Num�ro de t�l�phone : <c:out value="${ client.telephone }" /></p>
						<p>Email :<c:out value="${ client.email }" /></p>
						<p>le nombre des comptes bancaire :<c:out value="${fn:length(client.lesComptesBancaire)}" /></p>
						<p>le nombre des demandes des cr�dit :<c:out value="${fn:length(client.lesDemndes)}" /></p>
						<p>le nombre des cr�dits octroy� :<c:out value="${fn:length(client.lesCredit)}" /></p>
				</fieldset>
			<form action="/MiniProjet/CreerCompteOldClient" method="post">
				<fieldset>
					<legend>Information sur le compte :</legend>
					<br>
					<c:import url="/EmployePages/GestionCompte/inf_compte_form.jsp" />
				</fieldset>
				<input type="hidden" name="idClient" value="${ client.idClient }">
				<input type="submit" value="Valider" />
			</form>
		</c:if>
	

</body>
</html>