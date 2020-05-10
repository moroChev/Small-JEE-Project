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
		<li>G�rer Les client
			<ul>
				<li><a href="/MiniProjet/ListeClients">Les Clients de la banque</a></li>
				<li><a href="/MiniProjet/EmployePages/GestionClient/CreerClient.jsp">Cr�er un nouveau client</a></li>
				<li><a href="#">Modifier un client existant</a></li>
			</ul>
		</li>
		<li>G�rer Les comptes
			<ul>
				<li><a href="/MiniProjet/EmployePages/GestionCompte/Depot.jsp">Effectuer un d�pot</a></li>
				<li>Cr�er un compte
					<ul>
						<li><a href="/MiniProjet/EmployePages/GestionCompte/CreerCompteOldClient.jsp">pour un client d�ja existant</a></li>
						<li><a href="/MiniProjet/EmployePages/GestionCompte/CreerCompteNVClient.jsp">pour un nouveau client</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li>G�rer Les demandes
			<ul>
				<li><a href="/MiniProjet/LesDemandes">Consulter les demandes</a></li>
				<li><a href="/MiniProjet/EmployePages/GestionDemande/AvancerDemande.jsp">Avancer l'etat d'une demande</a></li>
			</ul>
		</li>
		<li>G�rer Les cr�dits
			<ul>
				<li><a href="/MiniProjet/LesCredit">Consulter les cr�dits</a></li>
				<li><a href="/MiniProjet/EmployePages/GestionCredit/PayerTraite.jsp">Payer une Traite</a></li>
			</ul>
		</li>
	</ul>


</body>
</html>