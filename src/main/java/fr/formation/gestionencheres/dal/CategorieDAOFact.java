package fr.formation.gestionencheres.dal;

public class CategorieDAOFact {
	private static CategorieDAO instance = new CategorieDAOImpl();
	
	public static CategorieDAO getInstance() {
		return instance;
	}

}
