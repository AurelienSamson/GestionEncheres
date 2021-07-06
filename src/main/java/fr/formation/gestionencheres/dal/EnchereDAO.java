package fr.formation.gestionencheres.dal;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Retrait;
import fr.formation.gestionencheres.bo.Utilisateur;

public interface EnchereDAO {
	public void insertArticleVendu(ArticleEnVente article);
	public void insertCategorie(Categorie categorie);
	public void insertUtilisateur(Utilisateur user);
	public void insertRetraits(Retrait retrait);
	public void insertEnchere(Enchere enchere);
	public Utilisateur getUserByID(Integer id);
	public Utilisateur getUserByPseudo(String pseudo);
	public Categorie getCategorieById(Integer id);
	public Categorie getCategorieByLibelle(String libelle);
}
