package fr.formation.gestionencheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	private Integer noCategorie;
	private String libelle;
	private List<ArticleEnVente> lstArticlesEnVente = new ArrayList<>();

	public Categorie() {
		super();
	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticleEnVente> getlstArticlesEnVente() {
		return lstArticlesEnVente;
	}

	public void setlstArticlesEnVente(List<ArticleEnVente> lstArticlesEnVente) {
		this.lstArticlesEnVente = lstArticlesEnVente;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", lstArticlesEnVente="
				+ lstArticlesEnVente + "]";
	}

	

}
