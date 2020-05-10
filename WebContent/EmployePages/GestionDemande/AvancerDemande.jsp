<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style1.css"/>" />
<title>Avancer Demande</title>
</head>
<body>
	<h4>L'Etape 1 : Demande en ligne</h4>
	<h4>L'Etape 2 : Convocation pour entretien</h4>
	<h4>L'Etape 3 : Etude du dossier</h4>
	<h4>L'Etape 4 : réponse définitive (Acceptation ou refus)</h4>



	<form action="/MiniProjet/ChercherDemande" method="GET">
		<fieldset>
			<legend>Chercher la Demande</legend>
			<label for="idDemande">Numéro de la demande :</label> <input
				type="text" id="idDemande" name="idDemande" value="" size="30"
				maxlength="30" /> <br> <input type="submit" value="Valider" />
		</fieldset>
	</form>

	<c:if test="${ !empty requestScope.demande }" var="demande">
		<fieldset>
			<legend>Les informations :</legend>
			<fieldset>
				<legend>Informations du client :</legend>
				<c:set var="client" value="${ requestScope.demande.client }"
					scope="request" />
				<div id="corps">
					<p>
						Nom :
						<c:out value="${ client.nom }" />
					</p>
					<p>
						Prénom :
						<c:out value="${ client.prenom }" />
					</p>
					<p>
						Adresse :
						<c:out value="${ client.dateNaissance }" />
					</p>
					<p>
						Numéro de téléphone :
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
						le nombre des demandes des crédit :
						<c:out value="${fn:length(client.lesDemndes)}" />
					</p>
					<p>
						le nombre des crédits octroyé :
						<c:out value="${fn:length(client.lesCredit)}" />
					</p>
				</div>
			</fieldset>
			<fieldset>
				<legend>Informations sur la demande :</legend>
				<div id="corps">
					<p>
						Numero de la demande :
						<c:out value="${ requestScope.demande.id_demande }" />
					</p>
					<p>
						La date de la demande :
						<c:out value="${ requestScope.demande.dateDemande }" />
					</p>
					<p>
						Le montant demande :
						<c:out value="${ requestScope.demande.montantDemande }" />
					</p>
					<p>
						L'état de la demande :
						<c:out value="${ requestScope.demande.etatDemande }" />
					</p>
				</div>
			</fieldset>
		</fieldset>
		
		<fieldset>
		<legend>Avancer la demande :</legend>
		<form action="/MiniProjet/AvancerDemande" method="GET">
			    <input type="hidden" name="idDemande" value="${ requestScope.demande.id_demande }" /> 
				<input type="checkbox" id="montant" name="montant" value="2" /> <span>Etape 2 : </span> Convocation Pour Entretien<br> 
				<input type="checkbox" id="montant" name="montant" value="3" /> <span>Etape 3 : </span> Etude du dossier<br>
			<c:if test="${ requestScope.demande.etatDemande == 3 }">
		     	<fieldset>
			    	<legend>Etape 4 : reponse définitive</legend>
			    	<input type="checkbox" id="montant" name="montant" value="10" /> <span>Accepter </span><br> 
			    	<input type="checkbox" id="montant" name="montant" value="-1" /> <span>Refuser </span><br>
			</fieldset>
			</c:if>
			<input type="submit" value="Valider" />
			 </form>
		</fieldset>
	

	</c:if>




</body>
</html>