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
@Table(name="credit")
public class Credit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name= "id_Credit")
	private int idCredit;
	
	@Column( name= "Date_credit")
	private String dateCredit;
	
	@Column( name= "montant_octroye")
	private double montantDonne;
	
	@Column( name= "montant_restant")
	private double montantRestant;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Id_Client", nullable=false)
	private Client client;
	
	public Credit(String dateCredit, double montantDonne, double montantRestant) {
		super();
//		this.idCredit = idCredit; int idCredit, 
		this.dateCredit = dateCredit;
		this.montantDonne = montantDonne;
		this.montantRestant = montantRestant;
	}
	
	public Credit() {}
	
	public int getIdCredit() {
		return idCredit;
	}
	public void setIdCredit(int idCredit) {
		this.idCredit = idCredit;
	}
	
	public String getDateCredit() {
		return dateCredit;
	}
	public void setDateCredit(String dateCredit) {
		this.dateCredit = dateCredit;
	}
	
	public Client getClient()
	{
		return this.client;
	}
	public void setClient(Client idClient)
	{
		this.client=idClient;
	}
	
	public double getMontantDonne() {
		return montantDonne;
	}
	public void setMontantDonne(double montantDonne) {
		this.montantDonne = montantDonne;
	}
	
    public double getMontantRestant() {
		return montantRestant;
	}
	public void setMontantRestant(double montantRestant) {
		this.montantRestant = montantRestant;
	}
	@Override
	public String toString() {
		return "Credit [idCredit=" + idCredit + ", dateCredit=" + dateCredit + ", montantDonne=" + montantDonne
				+ ", montantRestant=" + montantRestant + ", Client=" + client + "]";
	}
	
	
	
}
