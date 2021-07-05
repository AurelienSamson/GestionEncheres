package fr.formation.gestionencheres.bo;

import java.time.LocalTime;

public class Enchere {
	private LocalTime dateEnch�re;
	private Integer montant_enchere;

	public Enchere() {
		super();
	}

	public Enchere(LocalTime dateEnch�re, Integer montant_enchere) {
		super();
		this.dateEnch�re = dateEnch�re;
		this.montant_enchere = montant_enchere;
	}

	public LocalTime getDateEnch�re() {
		return dateEnch�re;
	}

	public void setDateEnch�re(LocalTime dateEnch�re) {
		this.dateEnch�re = dateEnch�re;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnch�re=" + dateEnch�re + ", montant_enchere=" + montant_enchere + "]";
	}

}
