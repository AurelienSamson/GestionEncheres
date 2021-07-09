package fr.formation.gestionencheres.bll;

public class RetraitDAOFact {
	private static RetraitDAO instance = new RetraitDAOImpl();
	
	public static RetraitDAO getInstance() {
		return instance;
	}

}
