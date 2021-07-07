package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.Utilisateur;

public interface UtilisateurManager {

	public void createUtilisateur(Utilisateur user);

	public Utilisateur getUtilisateurByNoUtilisateur(Integer noUtilisateur);

	public Utilisateur getutilisateurByPseudo(String pseuddo);
	
	public HashMap<Integer , String> getNoArticlePseudoUtilisateurWithCurrentEnchere();
	
	public List<Utilisateur> getAllUtilisateur();
	
	public void updateUtilisateur(Utilisateur user);
	
	public void updateCredit(Integer noUtilisateur, Integer newCredit);
	
	public void deleteUtilisateur(Utilisateur user);
	
	public BllException validateutilisateur(Utilisateur user);

}
