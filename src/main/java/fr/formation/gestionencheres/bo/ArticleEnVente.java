package fr.formation.gestionencheres.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleEnVente {
	private Integer noArticle;
	private String nom;
	private String Article;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private Integer etatVente;
	private Utilisateur user;
	private List<Enchere> lstEncheres = new ArrayList<>();
	private List<Retrait> lstRetrait = new ArrayList<>();
	private Categorie categorie;

	public ArticleEnVente() {
		super();
	}

	public ArticleEnVente(String nom, String article, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Integer etatVente) {
		super();
		this.nom = nom;
		Article = article;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	public ArticleEnVente(Integer noArticle, String nom, String article, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Integer etatVente) {
		super();
		this.noArticle = noArticle;
		this.nom = nom;
		Article = article;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getArticle() {
		return Article;
	}

	public void setArticle(String article) {
		Article = article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public Integer getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(Integer etatVente) {
		this.etatVente = etatVente;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}

	public List<Retrait> getLstRetrait() {
		return lstRetrait;
	}

	public void setLstRetrait(List<Retrait> lstRetrait) {
		this.lstRetrait = lstRetrait;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "ArticleEnVente [noArticle=" + noArticle + ", nom=" + nom + ", Article=" + Article + ", description="
				+ description + ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres
				+ ", miseAPrix=" + miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", user="
				+ user.getPrenom() + ", lstEncheres=" + lstEncheres + ", lstRetrait=" + lstRetrait + ", categorie="
				+ categorie.getLibelle() + "]";
	}

}
