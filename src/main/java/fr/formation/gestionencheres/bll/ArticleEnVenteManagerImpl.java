package fr.formation.gestionencheres.bll;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Utilisateur;

public class ArticleEnVenteManagerImpl implements ArticleEnVenteManager {

	private static ArticleEnVenteDAO dao = ArticleEnVenteDAOFact.getInstance();

	@Override
	public void createArticleEnVente(ArticleEnVente article) throws BllException, DALException {
		BllException bllException = validateArtticleEnVente(article);
		if (bllException.ErrorsExist()) {
			throw bllException;
		} else {
			dao.insertArticleEnVente(article);
		}

	}

	@Override
	public ArticleEnVente getArticleEnVenteByNoArticle(Integer noArticle) throws DALException, BllException {
		ArticleEnVente articleEnVente = dao.selectArticleEnVenteByNoArticle(noArticle);
		if (articleEnVente == null) {
			BllException bllException = new BllException();
			bllException.addError(BLLErrorCodes.NO_RESULTS_ERROR);
			throw bllException;
		}
		return articleEnVente;
	}

	@Override
	public void updateArticleEnVente(ArticleEnVente article) throws DALException, BllException {
		BllException bllException = validateArtticleEnVente(article);
		if (bllException.ErrorsExist()) {
			throw bllException;
		} else {
			dao.updateArticleEnVente(article);
		}

	}

	@Override
	public void updateArticleCurrnetPrice(Integer noArticle, Integer newPrice) throws DALException {
		dao.updateArticleCurrnetPrice(noArticle, newPrice);
	}

	@Override
	public void deleteArticleEnVente(ArticleEnVente article) throws DALException {
		dao.deleteArticleEnVente(article);

	}

	@Override
	public List<ArticleEnVente> getAllArticleEnVentes() throws DALException, BllException {
		List<ArticleEnVente> articleEnVentes = dao.selectAllArticleEnVentes();
		if (articleEnVentes.isEmpty()) {
			BllException bllException = new BllException();
			bllException.addError(BLLErrorCodes.NO_RESULTS_ERROR);
			throw bllException;
		} else {
			return articleEnVentes;
		}
	}

	@Override
	public List<ArticleEnVente> getArticleEnVenteByEtatVente(String etat) throws DALException, BllException {
		List<ArticleEnVente> articleEnVentes = dao.selectArticleEnVenteByEtatVente(etat);
		if (articleEnVentes.isEmpty()) {
			BllException bllException = new BllException();
			bllException.addError(BLLErrorCodes.NO_RESULTS_ERROR);
			throw bllException;
		} else {
			return articleEnVentes;
		}
	}

	@Override
	public List<ArticleEnVente> getArticleEnVenteByCategorie(Categorie categorie) throws DALException, BllException {
		List<ArticleEnVente> articleEnVentes = dao.selectArticleEnVenteByCategorie(categorie);
		if (articleEnVentes.isEmpty()) {
			BllException bllException = new BllException();
			bllException.addError(BLLErrorCodes.NO_RESULTS_ERROR);
			throw bllException;
		} else {
			return articleEnVentes;
		}
	}

	@Override
	public List<ArticleEnVente> getArticleEnVenteByNom(String nomArticle) throws DALException, BllException {
		List<ArticleEnVente> articleEnVentes = dao.selectArticleEnVenteByNom(nomArticle);
		if (articleEnVentes.isEmpty()) {
			BllException bllException = new BllException();
			bllException.addError(BLLErrorCodes.NO_RESULTS_ERROR);
			throw bllException;
		} else {
			return articleEnVentes;
		}
	}

	@Override
	public List<ArticleEnVente> getArticleEnVenteByVendeurAndEtatVente(Utilisateur user, String etatVente)
			throws DALException, BllException {
		List<ArticleEnVente> articleEnVentes = dao.selectArticleEnVenteByVendeurAndEtatVente(user, etatVente);
		if (articleEnVentes.isEmpty()) {
			BllException bllException = new BllException();
			bllException.addError(BLLErrorCodes.NO_RESULTS_ERROR);
			throw bllException;
		} else {
			return articleEnVentes;
		}
	}

	@Override
	public BllException validateArtticleEnVente(ArticleEnVente article) {
		BllException bllException = new BllException();

		if (article.getNom().length() > 30) {
			bllException.addError(BLLErrorCodes.LENGTH_NOM_ARTICLE_ERROR);
		}

		if (article.getDescription().length() > 300) {
			bllException.addError(BLLErrorCodes.LENGTH_DESCRIPTION_ARTICLE_ERROR);
		}
		// different states: PC(Pas Encours), EC(Encours), AN(Annule), VE(Vendue)
		String[] differentEtatVente = { "PC", "EC", "AN", "VE" };
		if (!Arrays.asList(differentEtatVente).contains(article.getEtatVente())) {
			bllException.addError(BLLErrorCodes.VALUE_STATUT_VENTE_ARTICLE_ERROR);
		}
		
		if(article.getDateDebutEncheres().isAfter(article.getDateFinEncheres())) {
			bllException.addError(BLLErrorCodes.START_DATE_AFTER_END_DATE_ERROR);
		}
		
		if(article.getDateDebutEncheres().isBefore(LocalDate.now()) || article.getDateFinEncheres().isBefore(LocalDate.now())) {
			bllException.addError(BLLErrorCodes.DATE_BEFORE_TODAY_ERROR);
		}
		return bllException;
	}

}
