<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style1.css"/>" />

<title>La liste des demandes</title>
</head>
<body>
<h1>La liste des demandes des credits</h1>
          <table>
                <tr>
                    <th>Numéro de Demande</th>
                    <th>Numéro du Client</th> 
                    <th>Nom complet du Client</th>  
                    <th>Date de la demande   </th>
                    <th>Montant demandé </th>
                    <th>Etat de la demande </th>
                                  
                </tr>
                <c:forEach items="${ requestScope.demandes }" var="demande" >
                <tr>
                    <td><c:out value="${ demande.id_demande }"/></td>
                    <td><c:out value="${ demande.client.idClient }"/></td>
                    <td><c:out value="${ demande.client.nom }"/> <c:out value="${ demande.client.prenom }"/></td>
                    <td><c:out value="${ demande.dateDemande }"/></td>
                    <td><c:out value="${ demande.montantDemande }"/></td>
                    <td>     
                    <c:choose>
                                        <c:when test="${ demande.etatDemande == 1 }">Etape 1 : Demande en ligne toujours</c:when>
                                        <c:when test="${ demande.etatDemande == 2 }">Etape 2 : Convoquer pour un entretien</c:when>
                                        <c:when test="${ demande.etatDemande == 3 }">Etape 3 : en cours d'étude</c:when>
                                        <c:when test="${ demande.etatDemande == 10 }">Etape 4 : demande accepté</c:when>
                                        <c:when test="${ demande.etatDemande == -1 }">Etape 4 : demande refusé</c:when>
                    </c:choose>
                    </td>     
                </tr>
                </c:forEach>
            </table>

</body>
</html>