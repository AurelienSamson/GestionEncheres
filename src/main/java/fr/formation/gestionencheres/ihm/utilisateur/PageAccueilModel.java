package fr.formation.gestionencheres.ihm.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;

public class PageAccueilModel {
	private List<Categorie> categories = new ArrayList<>();
	private List<ArticleEnVente> articles = new ArrayList<>();

	public PageAccueilModel() {
		super();
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public List<ArticleEnVente> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleEnVente> articles) {
		this.articles = articles;
	}
	
	
}
