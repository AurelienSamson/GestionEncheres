package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;

public interface EnchereManager {

	public void createEnchere(Enchere enchere) throws DALException;
	
	public List<Enchere> getAllCurrentEncheres() throws DALException;
	
	public List<Enchere> getAllCurrentEncheresByCategorie() throws DALException;
	
	public List<Enchere> getAllCurrentEncheresByNomArticle() throws DALException;
	
	public List<Enchere> getAllEncheresWhereUtilisateurSetOffer() throws DALException;
	
	public List<ArticleEnVente> getAllArticlesAcquireByUtilisateur(Utilisateur user) throws DALException;
	
	public HashMap<Integer, Integer> getAmountAndNoUtilisateurOfBestOfferFromArticleEnVente(ArticleEnVente article) throws DALException;
	
	//public List<ArticleEnVente> getArticlesEnVenteByVendeurAndEtatVente(Utilisateur user, String etatVente) throws DALException;
}
