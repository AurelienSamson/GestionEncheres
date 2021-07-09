package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;

public interface ArticleEnVenteManager {
	
	public void createArticleEnVente(ArticleEnVente article) throws BllException, DALException;
	
	public ArticleEnVente getArticleEnVenteByNoArticle(Integer noArticle) throws DALException, BllException;
	
	public void updateArticleEnVente(ArticleEnVente article) throws DALException, BllException;
	
	public void updateArticleCurrnetPrice(Integer noArticle, Integer newPrice) throws DALException;
	
	public void deleteArticleEnVente(ArticleEnVente article) throws DALException;
	
	public List<ArticleEnVente> getAllArticleEnVentes() throws DALException, BllException;
	
	public List<ArticleEnVente> getArticleEnVenteByEtatVente(String etat) throws DALException, BllException;
	
	public List<ArticleEnVente> getArticleEnVenteByCategorie(Categorie categorie) throws DALException, BllException;
	
	public List<ArticleEnVente> getArticleEnVenteByNom(String nomArticle) throws DALException, BllException;
	
	public List<ArticleEnVente> getArticleEnVenteByVendeurAndEtatVente(Utilisateur user, String etatVente) throws DALException, BllException;
	
	public BllException validateArtticleEnVente(ArticleEnVente article);
	
}
