package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Utilisateur;

public class ArticleEnVenteDAOImpl implements ArticleEnVenteDAO {

	@Override
	public void insertArticleEnVente(ArticleEnVente article) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ArticleEnVente> selectAllArticleEnVentes() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleEnVente selectArticleEnVenteByNoArticle(Integer noArticle) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteByCategorie(Categorie categorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteByEtatVente(String etat) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteByVendeurAndEtatVente(Utilisateur user, String etatVente)
			throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteByNom(String nomArticle) throws DALException, BllException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateArticleEnVente(ArticleEnVente article) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArticleCurrnetPrice(Integer noArticle, Integer newPrice) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticleEnVente(ArticleEnVente article) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
