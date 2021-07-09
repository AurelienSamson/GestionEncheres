package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;

public class EnchereManagerImpl implements EnchereManager {
	
	private static EnchereDAO dao = EnchereDAOFact.getInstance();

	@Override
	public void createEnchere(Enchere enchere) throws DALException {
		dao.insertEnchere(enchere);

	}

	@Override
	public List<Enchere> getAllCurrentEncheres() throws DALException {
		return dao.selectAllCurrentEncheres();
	}

	@Override
	public List<Enchere> getAllCurrentEncheresByCategorie() throws DALException {
		return dao.selectAllCurrentEncheresByCategorie();
	}

	@Override
	public List<Enchere> getAllCurrentEncheresByNomArticle() throws DALException {
		return dao.selectAllCurrentEncheresByNomArticle();
	}

	@Override
	public List<Enchere> getAllEncheresWhereUtilisateurSetOffer() throws DALException{
		return dao.selectAllEncheresWhereUtilisateurSetOffer();
	}

	@Override
	public List<ArticleEnVente> getAllArticlesAcquireByUtilisateur(Utilisateur user) throws DALException{
		return dao.selectAllArticlesAcquireByUtilisateur(user);
	}

	@Override
	public HashMap<Integer, Integer> getAmountAndNoUtilisateurOfBestOfferFromArticleEnVente(ArticleEnVente article) throws DALException{
		return dao.selectAmountAndNoUtilisateurOfBestOfferFromArticleEnVente(article);
	}

}
