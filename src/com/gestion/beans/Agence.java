package com.gestion.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="agence")
public class Agence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Agence")
	private int idAgence;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="telephone")
	private String telephone;
	
	public Agence() {
		
	}
	
	public Agence(String libelle, String adresse, String telephone) {
		super();
		
		this.libelle = libelle;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", libelle=" + libelle + ", adresse=" + adresse + ", telephone="
				+ telephone + "]";
	}
	public int getIdAgence() {
		return idAgence;
	}
	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	
	

}
