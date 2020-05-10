<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style1.css"/>" />
<title>Nos Clients</title>
</head>
<body>
<h1>La liste des clients de la banque</h1>
          <table>
                <tr>
                    <th>Numéro du Client</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Date de naissance</th>
                    <th>Téléphone</th>
                    <th>Email</th>
                    <th>nombre des comptes</th>
                    <th>nombre des demandes</th>
                    <th>nombre des credits</th>                  
                </tr>
                <c:forEach items="${ requestScope.clients }" var="client" >
                <tr>
                    <td><c:out value="${ client.idClient }"/></td>
                    <td><c:out value="${ client.nom }"/></td>
                    <td><c:out value="${ client.prenom }"/></td>
                    <td><c:out value="${ client.dateNaissance }"/></td>
                    <td><c:out value="${ client.telephone }"/></td>
                    <td><c:out value="${ client.email }"/></td>
                    <td><c:out value="${fn:length(client.lesComptesBancaire)}"/></td>
                    <td><c:out value="${fn:length(client.lesDemndes)}"/></td>
                    <td><c:out value="${fn:length(client.lesCredit)}"/></td>

                </tr>
                </c:forEach>
            </table>


</body>
</html>