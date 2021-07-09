package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.dal.DALException;

public interface CategorieManager {

	
	public void createCategorie(Categorie categorie) throws BllException, DALException;
	
	public Categorie getCategorieByNoCategorie(Integer noCategorie) throws DALException;
	
	public List<Categorie> getAllCategories() throws DALException;
	
}
