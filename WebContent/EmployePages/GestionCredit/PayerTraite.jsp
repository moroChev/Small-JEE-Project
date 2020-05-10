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
<title>Payer La Traite</title>
</head>
<body>
	<h1>Payer La Traite</h1>

	<form action="/MiniProjet/ChercherCredit" method="GET">
		<fieldset>
			<legend>Chercher le Credit</legend>
			<label for="idCredit">Num�ro du credit :</label>
			<input type="text" id="idCredit" name="idCredit" value="" size="30" maxlength="30" />
			<br> <input type="submit" value="Valider" />
		</fieldset>
	</form>

	<c:if test="${ !empty requestScope.credit }" var="credit">
		<fieldset>
			<legend>Les informations :</legend>
			<fieldset>
				<legend>Informations du client :</legend>
				<c:set var="client" value="${ requestScope.credit.client }" scope="request" />
				<div id="corps">
					<p>
						Nom :
						<c:out value="${ client.nom }" />
					</p>
					<p>
						Pr�nom :
						<c:out value="${ client.prenom }" />
					</p>
					<p>
						Adresse :
						<c:out value="${ client.dateNaissance }" />
					</p>
					<p>
						Num�ro de t�l�phone :
						<c:out value="${ client.telephone }" />
					</p>
					<p>
						Email :
						<c:out value="${ client.email }" />
					</p>
					<p>
						le nombre des comptes bancaire :
						<c:out value="${fn:length(client.lesComptesBancaire)}" />
					</p>
					<p>
						le nombre des demandes des cr�dit :
						<c:out value="${fn:length(client.lesDemndes)}" />
					</p>
					<p>
						le nombre des cr�dits octroy� :
						<c:out value="${fn:length(client.lesCredit)}" />
					</p>
				</div>
			</fieldset>
			<fieldset>
				<legend>Informations sur le credit :</legend>
				<div id="corps">
					<p>
						Numero du cr�dit :
						<c:out value="${ requestScope.credit.idCredit }" />
					</p>
					<p>
						La date d'octroi :
						<c:out value="${ requestScope.credit.dateCredit }" />
					</p>
					<p>
						Le montant octroy� :
						<c:out value="${ requestScope.credit.montantDonne }" />
					</p>
					<p>
						Le montant restant :
						<c:out value="${ requestScope.credit.montantRestant }" />
					</p>
				</div>
			</fieldset>
		</fieldset>
		<fieldset>
			<legend>Payer La Traite :</legend>
			<form action="/MiniProjet/PayerTraite" method="GET">
			<input type="hidden" name="idCredit" value="${ requestScope.credit.idCredit }" />
				<label for="montant">le Montant � payer :</label> <input type="text"
					id="montant" name="montant" value="" size="30" maxlength="30" /> <br>
				<input type="submit" value="Valider" />

			</form>
		</fieldset>
	</c:if>









</body>
</html>