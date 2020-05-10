<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceuil emplyee</title>
</head>
<body>
	<h1>Bienvenue Employe</h1>

	<p>
		Bienvenue
		<c:out value="${ sessionScope.employe.nom }" />
		<c:out value="${ sessionScope.employe.prenom }" />
	</p>
	<ul>
		<li>Gérer Les client
			<ul>
				<li><a href="/MiniProjet/ListeClients">Les Clients de la banque</a></li>
				<li><a href="/MiniProjet/EmployePages/GestionClient/CreerClient.jsp">Créer un nouveau client</a></li>
				<li><a href="#">Modifier un client existant</a></li>
			</ul>
		</li>
		<li>Gérer Les comptes
			<ul>
				<li><a href="/MiniProjet/EmployePages/GestionCompte/Depot.jsp">Effectuer un dépot</a></li>
				<li>Créer un compte
					<ul>
						<li><a href="/MiniProjet/EmployePages/GestionCompte/CreerCompteOldClient.jsp">pour un client déja existant</a></li>
						<li><a href="/MiniProjet/EmployePages/GestionCompte/CreerCompteNVClient.jsp">pour un nouveau client</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li>Gérer Les demandes
			<ul>
				<li><a href="/MiniProjet/LesDemandes">Consulter les demandes</a></li>
				<li><a href="/MiniProjet/EmployePages/GestionDemande/AvancerDemande.jsp">Avancer l'etat d'une demande</a></li>
			</ul>
		</li>
		<li>Gérer Les crédits
			<ul>
				<li><a href="/MiniProjet/LesCredit">Consulter les crédits</a></li>
				<li><a href="/MiniProjet/EmployePages/GestionCredit/PayerTraite.jsp">Payer une Traite</a></li>
			</ul>
		</li>
	</ul>


</body>
</html>