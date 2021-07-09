package fr.formation.gestionencheres.dal;

public class ArticleEnVenteDAOFact {

	private static ArticleEnVenteDAO instance = new ArticleEnVenteDAOImpl();
	
	public static ArticleEnVenteDAO getInstance() {
		return instance;
	}
}
