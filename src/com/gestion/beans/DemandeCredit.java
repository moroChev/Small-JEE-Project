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
@Table(name="demandes_credit")
public class DemandeCredit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_demande")
	private int id_demande;
	
	@Column(name="Date_demande")
	private String dateDemande;
	
	@Column(name="Montant_demande")
	private double montantDemande;
	
	@Column(name="Etat_demande")
	private String etatDemande;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Id_Client", nullable=false)
	private Client client;
	
	public DemandeCredit() {}

	public int getId_demande() {
		return id_demande;
	}

	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}

	public String getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}

	public double getMontantDemande() {
		return montantDemande;
	}

	public void setMontantDemande(double montantDemande) {
		this.montantDemande = montantDemande;
	}

	public String getEtatDemande() {
		return etatDemande;
	}

	public void setEtatDemande(String etatDemande) {
		this.etatDemande = etatDemande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client idClient) {
		this.client = idClient;
	}

	public DemandeCredit( String dateDemande, double montantDemande, String etatDemande) {
		super();
		this.dateDemande = dateDemande;
		this.montantDemande = montantDemande;
		this.etatDemande = etatDemande;	
	}

	@Override
	public String toString() {
		return "DemandeCredit [id_demande=" + id_demande + ", dateDemande=" + dateDemande + ", montantDemande="
				+ montantDemande + ", etatDemande=" + etatDemande + ", Client=" + client + "]";
	}
	
	
	
	

}
