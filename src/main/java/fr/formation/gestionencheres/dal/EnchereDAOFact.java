package fr.formation.gestionencheres.dal;

public class EnchereDAOFact {
	private static EnchereDAO instance = new EnchereDAOImpl();
	
	public static EnchereDAO getInstance() {
		return instance;
	}
}
