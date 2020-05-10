<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="/inc/style1.css" />
<title>Les Credits</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style1.css"/>" />


</head>
<body>
<h1>La liste des crédits de la banque</h1>
          <table>
                <tr>
                    <th>Numéro du Crédit</th>
                    <th>Numéro du Client</th> 
                    <th>Nom complet du Client</th>  
                    <th>Date d'octroi   </th>
                    <th>Montant Octroyé </th>
                    <th>Montant Restant </th>
                                  
                </tr>
                <c:forEach items="${ requestScope.credits }" var="credit" >
                <tr>
                    <td><c:out value="${ credit.idCredit }"/></td>
                    <td><c:out value="${ credit.client.idClient }"/></td>
                    <td><c:out value="${ credit.client.nom }"/> <c:out value="${ credit.client.prenom }"/></td>
                    <td><c:out value="${ credit.dateCredit }"/></td>
                    <td><c:out value="${ credit.montantDonne }"/></td>
                    <td><c:out value="${ credit.montantRestant }"/></td>
                </tr>
                </c:forEach>
            </table>


</body>
</html>