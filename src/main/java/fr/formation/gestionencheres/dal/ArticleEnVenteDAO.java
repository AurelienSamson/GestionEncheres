package fr.formation.gestionencheres.dal;

import java.util.List;

import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Utilisateur;

public interface ArticleEnVenteDAO {

	public void insertArticleEnVente(ArticleEnVente article) throws DALException;

	public List<ArticleEnVente> selectAllArticleEnVentes() throws DALException;

	public ArticleEnVente selectArticleEnVenteByNoArticle(Integer noArticle) throws DALException;

	public List<ArticleEnVente> selectArticleEnVenteByCategorie(Categorie categorie) throws DALException;

	public List<ArticleEnVente> selectArticleEnVenteByEtatVente(String etat) throws DALException;

	public List<ArticleEnVente> selectArticleEnVenteByVendeurAndEtatVente(Integer id, String etat) throws DALException;

	public List<ArticleEnVente> selectArticleEnVenteByNom(String nomArticle) throws DALException, BllException;

	public List<ArticleEnVente> selectArticleEnVenteOrderByNom() throws DALException;

	public List<ArticleEnVente> selectArticlesAcquireByUtilisateur(Integer id) throws DALException;

	public List<ArticleEnVente> selectAllArticlesEnVenteWhereUtilisateurSetOffer() throws DALException;

	public void updateArticleEnVente(ArticleEnVente article) throws DALException;

	public void updateArticleCurrentPrice(Integer noArticle, Integer newPrice) throws DALException;

	public void deleteArticleEnVente(ArticleEnVente article) throws DALException;

//	public HashMap<Integer , String> selectArticlePseudoUtilisateurWithCurrentEnchere();

}
