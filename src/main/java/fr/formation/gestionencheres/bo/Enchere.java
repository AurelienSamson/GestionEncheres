package fr.formation.gestionencheres.bo;

import java.time.LocalTime;

public class Enchere {
	private LocalTime dateEnchere;
	private Integer montant_enchere;

	public Enchere() {
		super();
	}

	public Enchere(LocalTime dateEnchere, Integer montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}

	public LocalTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalTime dateEnchere) {
		this.dateEnchere = dateEnchere;
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
