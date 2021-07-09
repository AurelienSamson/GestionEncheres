package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;

public interface EnchereDAO {
	
	public void insertEnchere(Enchere enchere) throws DALException;
	
	public List<Enchere> selectAllCurrentEncheres() throws DALException;
	
	public List<Enchere> selectAllCurrentEncheresByCategorie() throws DALException;
	
	public List<Enchere> selectAllCurrentEncheresByNomArticle() throws DALException;
	
	public List<Enchere> selectAllEncheresWhereUtilisateurSetOffer() throws DALException;
	
	public List<ArticleEnVente> selectAllArticlesAcquireByUtilisateur(Utilisateur user) throws DALException;
	
	public HashMap<Integer, Integer> selectAmountAndNoUtilisateurOfBestOfferFromArticleEnVente(ArticleEnVente article) throws DALException;
	

}
