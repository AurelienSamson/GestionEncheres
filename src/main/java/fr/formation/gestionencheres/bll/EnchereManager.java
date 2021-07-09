package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Utilisateur;

public interface EnchereManager {

	public void createEnchere(Enchere enchere) throws DALException;
	
	public List<Enchere> getAllCurrentEncheres() throws DALException;
	
	public List<Enchere> getAllCurrentEncheresByCategorie() throws DALException;
	
	public List<Enchere> getAllCurrentEncheresByNomArticle() throws DALException;
	
	public List<Enchere> getAllEncheresWhereUtilisateurSetOffer();
	
	public List<ArticleEnVente> getAllArticlesAcquireByUtilisateur(Utilisateur user);
	
	public HashMap<Integer, Integer> getAmountAndNoUtilisateurOfBestOfferFromArticleEnVente(ArticleEnVente article);
	
	public List<Integer> getAllArticlesEnVenteByUtilisateurAndEtatVente(Utilisateur user, String etatVente) throws DALException;
}
