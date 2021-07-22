package fr.formation.gestionencheres.ihm.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.formation.gestionencheres.bo.Categorie;

public class PageAccueilModel {
	private List<Categorie> categories = new ArrayList<>();

	public PageAccueilModel(List<Categorie> categories) {
		super();
		this.categories = categories;
	}

	public PageAccueilModel() {
		super();
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	
}
