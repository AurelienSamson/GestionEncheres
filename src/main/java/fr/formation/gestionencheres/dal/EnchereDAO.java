package fr.formation.gestionencheres.dal;

import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Retrait;
import fr.formation.gestionencheres.bo.Utilisateur;

public interface EnchereDAO {
	public void insertArticleVendu(ArticleEnVente article);
	public void insertUtilisateur(Utilisateur user);
	public void insertCategorie(Categorie categorie);
	public void insertRetraits(Retrait retrait);
	public void insertEnchere(Enchere enchere);
	public void updateArticleEnVente(ArticleEnVente article);
	public void updateArticleCurrentPrice(ArticleEnVente article, Integer newPrice);
	public void updateRetrait(Retrait retrait, Integer id);
	public void updateUtilisateur(Utilisateur user);
	public void updateCredit(Utilisateur user, Integer newCredit);
	public void deleteArticleEnVente(ArticleEnVente article);
	public void deleteRetrait(Integer id);
	public void deleteUtilisateur(Utilisateur user);
	
	public Utilisateur getUserByID(Integer id);
	public Utilisateur getUserByPseudo(String pseudo);
	public Categorie getCategorieById(Integer id);
	public Categorie getCategorieByLibelle(String libelle);
	public ArticleEnVente getArticleEnVenteById(Integer id);
	public Retrait getRetraitByNoArticle(Integer noArticle);
	
	public List<ArticleEnVente> getArticlesVendus();
	public List<Utilisateur> getUtilisateurs();
	public List <Categorie> getCategories();
	public List<Enchere> getEncheres();
	public List<Retrait> getRetraits();
	
	public List<Enchere> getAllCurrentEncheres();
	//public List<Enchere> getAllCurrentEncheresOrderedByCategorie();
	public List<Enchere> getAllCurrentEncheresOrderedByNomArticle();
	public List<ArticleEnVente> getAllArticlesEnVenteWhereUtilisateurSetOffer();
	
	public List<ArticleEnVente> getArticlesEnVenteByEtatVente(String etat);
	public List<ArticleEnVente> getArticlesEnVenteByVendeurAndEtatVente(Integer id, String etat);
	
	public List<ArticleEnVente> getArticlesAcquireByUtilisateur(Integer id);
	public List<ArticleEnVente> getArticleEnVenteFromCategorie(Categorie categorie);
	public List<ArticleEnVente> getArticleEnVenteOrderedByNom();
	public Enchere getAmountAndUtilisateurOfBestOfferFromArticleEnVente(ArticleEnVente article);
	//public HashMap<Integer , String> getArticlePseudoUtilisateurWithCurrentEnchere();
	
}
