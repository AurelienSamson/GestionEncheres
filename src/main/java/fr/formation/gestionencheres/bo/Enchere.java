package fr.formation.gestionencheres.bo;

import java.time.LocalDate;

public class Enchere {
	private LocalDate dateEnchere;
	private Integer montant_enchere;
	private Utilisateur user;
	private ArticleEnVente article;

	public Enchere() {
		super();
	}

	public Enchere(LocalDate dateEnchere, Integer montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public ArticleEnVente getArticle() {
		return article;
	}

	public void setArticle(ArticleEnVente article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", user="
				+ user.getPrenom() + ", article=" + article.getNom() + "]";
	}

}
