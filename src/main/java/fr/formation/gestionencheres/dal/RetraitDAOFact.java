package fr.formation.gestionencheres.dal;

public class RetraitDAOFact {
	private static RetraitDAO instance = new RetraitDAOImpl();
	
	public static RetraitDAO getInstance() {
		return instance;
	}

}
