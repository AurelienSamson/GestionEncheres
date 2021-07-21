package fr.formation.gestionencheres.bll;

public class ArticleEnVenteManagerSingl {
	private static ArticleEnVenteManager instance;
	
	public static ArticleEnVenteManager getInstance() {
		if(instance == null) {
			instance = new ArticleEnVenteManagerImpl();
		}
		return instance;
		
	}

}
