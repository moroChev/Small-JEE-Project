<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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