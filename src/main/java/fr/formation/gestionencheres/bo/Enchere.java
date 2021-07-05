package fr.formation.gestionencheres.bo;

import java.time.LocalTime;

public class Enchere {
	private LocalTime dateEnchère;
	private Integer montant_enchere;

	public Enchere() {
		super();
	}

	public Enchere(LocalTime dateEnchère, Integer montant_enchere) {
		super();
		this.dateEnchère = dateEnchère;
		this.montant_enchere = montant_enchere;
	}

	public LocalTime getDateEnchère() {
		return dateEnchère;
	}

	public void setDateEnchère(LocalTime dateEnchère) {
		this.dateEnchère = dateEnchère;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchère + ", montant_enchere=" + montant_enchere + "]";
	}

}
