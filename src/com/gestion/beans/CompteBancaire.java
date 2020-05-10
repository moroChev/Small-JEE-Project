package com.gestion.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compte_bancaire")
public class CompteBancaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Compte")
	private int idCompte;
	
	@Column(name="Date_creation")
	private String dateCreation;
	
	@Column(name="Solde")
	private double solde;
	
	@Column(name="libelle")
	private String libelle;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Id_Client")
	private Client client;
	
	public CompteBancaire() {}

	public CompteBancaire( double solde, String libelle) {
		super();
		this.libelle=libelle;
		this.solde = solde;

	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String dernierConsultation) {
		this.libelle = dernierConsultation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client idClient) {
		this.client = idClient;
	}
	
	@Override
	public String toString() {
		return "CompteBancaire [idCompte=" + idCompte + ", dateCreation=" + dateCreation + ", solde=" + solde
				+ ", libelle=" + libelle + ", idClient=" + client + "]";
	}

	
}
