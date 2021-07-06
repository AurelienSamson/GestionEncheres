package fr.formation.gestionencheres.bo;

import java.time.LocalTime;

public class Enchere {
	private LocalTime dateEnchere;
	private Integer montant_enchere;

	public Enchere() {
		super();
	}

	public Enchere(LocalTime dateEnchère, Integer montant_enchere) {
		super();
		this.dateEnchere = dateEnchère;
		this.montant_enchere = montant_enchere;
	}

	public LocalTime getDateEnchère() {
		return dateEnchere;
	}

	public void setDateEnchère(LocalTime dateEnchère) {
		this.dateEnchere = dateEnchère;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchere + ", montant_enchere=" + montant_enchere + "]";
	}

}
