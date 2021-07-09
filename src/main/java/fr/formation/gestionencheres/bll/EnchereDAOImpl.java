package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;

public class EnchereDAOImpl implements EnchereDAO {

	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Enchere> selectAllCurrentEncheres() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAllCurrentEncheresByCategorie() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAllCurrentEncheresByNomArticle() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAllEncheresWhereUtilisateurSetOffer() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> selectAllArticlesAcquireByUtilisateur(Utilisateur user) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Integer> selectAmountAndNoUtilisateurOfBestOfferFromArticleEnVente(ArticleEnVente article)
			throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
