package fr.formation.gestionencheres.bll;

public class ArticleEnVenteDAOFact {

	private static ArticleEnVenteDAO instance = new ArticleEnVenteDAOImpl();
	
	public static ArticleEnVenteDAO getInstance() {
		return instance;
	}
}
