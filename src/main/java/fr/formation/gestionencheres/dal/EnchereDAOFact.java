package fr.formation.gestionencheres.dal;

public class EnchereDAOFact {
	private static EnchereDAO instance = new EnchereDAOImpl();
	
	public EnchereDAO getInstance() {
		return instance;
	}
}
