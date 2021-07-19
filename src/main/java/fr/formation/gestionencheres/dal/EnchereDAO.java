package fr.formation.gestionencheres.dal;

import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Retrait;
import fr.formation.gestionencheres.bo.Utilisateur;

public interface EnchereDAO {

	public void insertEnchere(Enchere enchere) throws DALException;

	public List<Enchere> selectEncheres() throws DALException;

	public List<Enchere> selectAllCurrentEncheres() throws DALException;

//	public List<Enchere> selectAllCurrentEncheresOrderedByCategorie() throws DALException;

	public List<Enchere> selectAllCurrentEncheresOrderedByNomArticle() throws DALException;

}
