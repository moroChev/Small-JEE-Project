package com.gestion.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Client")
	private int idClient;

	@Column(name = "Nom")
	private String nom;

	@Column(name = "Prenom")
	private String prenom;

	@Column(name = "Date_Naissance")
	private String dateNaissance;

	@Column(name = "Telephone")
	private String telephone;

	@Column(name = "Email")
	private String email;

	@Column(name = "Id_agence")
	private int idAgence;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_user")
	private UsersComptes userComptes;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = CompteBancaire.class, mappedBy = "client", cascade = CascadeType.ALL)
	private Set<CompteBancaire> lesComptesBancaire;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = DemandeCredit.class, mappedBy = "client", cascade = CascadeType.ALL)
	private Set<DemandeCredit> lesDemndes;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Credit.class, mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Credit> lesCredit;

	public Set<DemandeCredit> getLesDemndes() {
		return lesDemndes;
	}

	public void setLesDemndes(Set<DemandeCredit> lesDemndes) {
		this.lesDemndes = lesDemndes;
	}

	public Set<Credit> getLesCredit() {
		return lesCredit;
	}

	public void setLesCredit(Set<Credit> lesCredit) {
		this.lesCredit = lesCredit;
	}

	public Client() {

	}

	public Client(String nom, String prenom, String dateNaissance, String tele, String email,int idAgence) {
		// this.idClient = idClient;int idClient,
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = tele;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.idAgence = idAgence;
		// this.userComptes = idUser; UsersComptes idUser

	}

	public Set<CompteBancaire> getLesComptesBancaire() {
		return lesComptesBancaire;
	}

	public void setLesComptesBancaire(Set<CompteBancaire> lesComptesBancaire) {
		this.lesComptesBancaire = lesComptesBancaire;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}

	public UsersComptes getUserComptes() {
		return userComptes;
	}

	public void setUserComptes(UsersComptes idUser) {
		this.userComptes = idUser;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
//		int i=1;
//		StringBuffer laliste =  new StringBuffer();
//		String  num = "Compte N°: ";
//		laliste.append(num);
//		for(CompteBancaire comptae: lesComptesBancaire )
//		{
//			laliste.append(num);
//			laliste.append(i);
//			laliste.append(" "+comptae.toString()+"\n");
//			i++;
//		}

		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", telephone=" + telephone + ", email=" + email + ", idAgence=" + idAgence
				+ ", userComptes=" + userComptes + ",nbr lesComptesBancaire=" + lesComptesBancaire.size()
				+ ", nbr des demandes :" + lesDemndes.size() + ",nbr des Credits octroye =" + lesCredit.size() + " ]";
	}

}
