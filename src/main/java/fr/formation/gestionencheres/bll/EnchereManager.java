package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Utilisateur;

public interface EnchereManager {

	public void createEnchere(Enchere enchere);
	
	public List<Enchere> getAllCurrentEncheres();
	
	public List<Enchere> getAllCurrentEncheresByCategorie();
	
	public List<Enchere> getAllCurrentEncheresByNomArticle();
	
	public List<Enchere> getAllEncheresWhereUtilisateurSetOffer();
	
	public List<Integer> getAllNoArticlesAcquireByUtilisateur(Utilisateur user);
	
	public HashMap<Integer, Integer> getAmountAndNoUtilisateurOfBestOfferFromArticleEnVente(ArticleEnVente article);
	
	public List<Integer> getAllNoArticlesAndEtatVenteByUtilisateur(Utilisateur user, String etatVente);
}
