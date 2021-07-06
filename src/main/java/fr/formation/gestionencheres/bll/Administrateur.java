package fr.formation.gestionencheres.bll;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Utilisateur;

public interface Administrateur {
	public void desactiverCompteUtilisateur(Utilisateur user);
	
	public void supprimerCompte(Utilisateur user);
	
	public void changerLibelleCategorie(Categorie categorie);
	
	public void ajouterArticleCategorie(Categorie categorie, ArticleEnVente article);
	
	public void supprimerArticleCategorie(Categorie categorie, ArticleEnVente article);
}
