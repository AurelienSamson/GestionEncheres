package fr.formation.gestionencheres.dal;

public class UtilisateurDAOFact {
	private static UtilisateurDAO instance = new UtilisateurDAOImpl();
	
	public static UtilisateurDAO getInstance() {
		
		return instance;
	}

}
