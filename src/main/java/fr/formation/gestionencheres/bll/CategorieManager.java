package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.Categorie;

public interface CategorieManager {

	
	public void createCategorie(Categorie categorie);
	
	public Categorie getCategorieByNoCategorie(Integer noCategorie);
	
	public List<Categorie> getAllCategories();
	
}
