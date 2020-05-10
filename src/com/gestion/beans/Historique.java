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
@Table(name="historique")
public class Historique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Operation")
	private int idOperation;
	
	@Column(name="Date_Operation")
	private String dateOperation;
	
	@Column(name="Libelle")
	private String libelle;
	
	@Column(name="Debit")
	private double debit;
	
	@Column(name="Credit")
	private double credit;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_compte")
	private CompteBancaire lecompte;
	
	public Historique() {}
	
	public Historique( String dateOperation, String libelle, double debit, double credit) {
		super();
	//	this.idOperation = idOperation; int idOperation,
		this.dateOperation = dateOperation;
		this.libelle = libelle;
		this.debit = debit;
		this.credit = credit;

	}

	public int getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public String getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}


	
	@Override
	public String toString() {
		return "Historique [idOperation=" + idOperation + ", dateOperation=" + dateOperation + ", libelle=" + libelle
				+ ", debit=" + debit + ", credit=" + credit + ", idCompte=" + lecompte + "]";
	}

	public CompteBancaire getLecompte() {
		return lecompte;
	}

	public void setLecompte(CompteBancaire lecompte) {
		this.lecompte = lecompte;
	}


	

}
