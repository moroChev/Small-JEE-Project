<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style1.css"/>" />
<title>Depot</title>
</head>
<body>
<h1>Effectuer dépot d'argent</h1>


	<form action="/MiniProjet/ChercherCompte">
		<fieldset>
			<legend>Trouver le Compte :</legend>
			<label for="idCompte">Numéro du Compte :</label> 
			<input type="text" id="idCompte" name="idCompte" value="" size="30" maxlength="30" />
			<input type="submit" value="Valider" />
		</fieldset>
	</form>
	<c:if test="${ !empty requestScope.compte }">
	 <table>
                <tr>
                    <th>Numéro du Compte</th>
                    <th>Libélle </th>
                    <th>Numéro du Client</th> 
                    <th>Nom complet du Client</th>  
                    <th>Date de création  </th>
                    <th>Solde </th>
                </tr>
                <tr>
                    <td><c:out value="${ requestScope.compte.idCompte }"/></td>             
                    <td><c:out value="${ requestScope.compte.libelle }"/></td>
                    <td><c:out value="${ requestScope.compte.client.idClient }"/></td>
                    <td><c:out value="${ requestScope.compte.client.nom }"/> <c:out value="${ requestScope.compte.client.prenom }"/></td>
                    <td><c:out value="${ requestScope.compte.dateCreation }"/></td>
                    <td><c:out value="${ requestScope.compte.solde }"/></td>
                </tr>
     </table>
     <form action="/MiniProjet/Depot">
		<fieldset>
			<legend>Effectuer le depot :</legend>		
			<input type="hidden" name="idCompte" value="<c:out value="${ requestScope.compte.idCompte }"/>" size="30" maxlength="30" />
			
			<label for="montant">Montant à déposer :</label> 
			<input type="text" name="montant" value="" size="30" maxlength="30" />
			<input type="submit" value="Valider" />
		</fieldset>
	</form>
    </c:if>
</body>
</html>