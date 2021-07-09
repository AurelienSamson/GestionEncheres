package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.Categorie;

public interface CategorieDAO {
	
	public void insertCategorie(Categorie categorie)throws BllException, DALException;
	
	public Categorie selectCategorieByNoCategorie(Integer noCategorie)throws DALException;
	
	public List<Categorie> selectAllCategories() throws DALException;

}
