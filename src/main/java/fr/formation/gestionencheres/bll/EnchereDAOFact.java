package fr.formation.gestionencheres.bll;

public class EnchereDAOFact {
	
	private static EnchereDAO instance = new EnchereDAOImpl();
	
	public static EnchereDAO getInstance() {
		return instance;
	}

}
