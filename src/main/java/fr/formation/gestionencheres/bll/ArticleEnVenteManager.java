package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Utilisateur;

public interface ArticleEnVenteManager {
	
	public void createArticleEnVente(ArticleEnVente article);
	
	public ArticleEnVente getArticleEnVenteByNoArticle(Integer noArticle);
	
	public void updateArticleEnVente(ArticleEnVente article);
	
	public void updateArticleCurrnetPrice(Integer noArticle, Integer newPrice);
	
	public void deleteArticleEnVente(ArticleEnVente article);
	
	public List<ArticleEnVente> getAllArticleEnVentes();
	
	public List<Integer> getNoArticleEnVenteByEtatVente(String etat);
	
	public List<ArticleEnVente> getArticleEnVenteFromCategorie(Categorie categorie);
	
	public List<ArticleEnVente> getArticleEnVenteByNom(String nom);
	
	public List<Integer> getNoArticleEnVenteByVendeurAndEtatVente(Utilisateur user, String etatVente);
	
	public BllException validateArtticleEnVente(ArticleEnVente article);
	
}
