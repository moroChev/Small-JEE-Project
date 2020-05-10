<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceuil Client</title>
</head>
<body>
<h2>Bienvenue à Votre Banque</h2>
<p> Bienvenue <c:out value="${ sessionScope.client.nom }"/> <c:out value="${ sessionScope.client.prenom }"/> </p>
<a href="/MiniProjet/InfoClient">Mon Profil</a><br>
<a href="/MiniProjet/Comptes">Mes Comptes</a><br>
<a href="/MiniProjet/Demandes">Mes demandes</a><br>
<a href="/MiniProjet/Credit">Mes Crédit</a><br>
</body>
</html>