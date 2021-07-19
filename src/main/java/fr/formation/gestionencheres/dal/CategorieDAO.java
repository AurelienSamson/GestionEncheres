package fr.formation.gestionencheres.dal;

import java.util.List;

import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;

public interface CategorieDAO {

	public void insertCategorie(Categorie categorie) throws BllException, DALException;

	public Categorie selectCategorieByNoCategorie(Integer noCategorie) throws DALException;

	public List<Categorie> selectAllCategories() throws DALException;

	public Categorie selectCategorieByLibelle(String libelle) throws DALException;

	public List<ArticleEnVente> getArticleEnVenteFromCategorie(Categorie categorie) throws DALException;

}
