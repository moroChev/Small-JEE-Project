package com.gestion.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employe")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name= "id_employe")
	private int idEmploye;
	
	@Column( name= "nom")
	private String nom;
	
	@Column( name= "prenom")
	private String prenom;
	
	@Column( name= "adresse")
	private String adresse;
	
	@Column( name= "telephone")
	private String telephone;
	
	@Column( name= "date_embauche")
	private String dateEmbauche;
	
	@Column( name= "num_agence")
	private double numAgence;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Id_User" )
	private UsersComptes userComptes;
	
	public Employe() {
		
	}
	
	public Employe( String nom, String prenom, String adresse, String telephone, String date) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateEmbauche = date;
	
	}

	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", dateEmbauche=" + dateEmbauche + ", numAgence=" + numAgence
				+ ", userComptes=" + userComptes + "]";
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(String date) {
		this.dateEmbauche = date;
	}

	public double getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(double numAgence) {
		this.numAgence = numAgence;
	}

	public UsersComptes getUserComptes() {
		return userComptes;
	}

	public void setUserComptes(UsersComptes userComptes) {
		this.userComptes = userComptes;
	}

	


}
