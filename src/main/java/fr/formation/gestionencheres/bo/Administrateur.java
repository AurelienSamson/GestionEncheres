package fr.formation.gestionencheres.bo;

public interface Administrateur {
	public void desactiverCompteUtilisateur(Utilisateur user);
	
	public void supprimerCompte(Utilisateur user);
	
	public void changerLibelleCategorie(Categorie categorie);
	
	public void ajouterArticleCategorie(Categorie categorie, ArticleEnVente article);
	
	public void supprimerArticleCategorie(Categorie categorie, ArticleEnVente article);
}
