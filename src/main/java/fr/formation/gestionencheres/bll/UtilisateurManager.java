package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.Utilisateur;

public interface UtilisateurManager {

	public void createUtilisateur(Utilisateur user);

	public Utilisateur getUtilisateurByNoUtilisateur(Integer noUtilisateur);

	public Utilisateur getUtilisateurByPseudo(String pseuddo);
	
	// give the list (must return only name of users) of all users that currently have an auction
	// so that we can display the sellers names on the homepage
	public HashMap<Integer , String> getNoArticlePseudoUtilisateurWithCurrentEnchere();
	
	public List<Utilisateur> getAllUtilisateurs();
	
	public void updateUtilisateur(Utilisateur user);
	
	public void updateCredit(Integer noUtilisateur, Integer newCredit);
	
	public void deleteUtilisateur(Utilisateur user);
	
	public BllException validateUtilisateur(Utilisateur user);

}
