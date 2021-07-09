package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;

public interface UtilisateurManager {

	public void createUtilisateur(Utilisateur user) throws BllException, DALException;

	public Utilisateur getUtilisateurByNoUtilisateur(Integer noUtilisateur) throws DALException;

	public Utilisateur getUtilisateurByPseudo(String pseuddo) throws DALException;
	
	// give the list (must return only name of users) of all users that currently have an auction
	// so that we can display the sellers names on the homepage
	public HashMap<Integer , String> getNoArticlePseudoUtilisateurWithCurrentEnchere() throws DALException;
	
	public List<Utilisateur> getAllUtilisateurs() throws DALException;
	
	public void updateUtilisateur(Utilisateur user, boolean checkForMail, boolean checkForUtilisateur)
			throws BllException, DALException;
	
	public void updateCredit(Integer noUtilisateur, Integer newCredit) throws DALException;
	
	public void deleteUtilisateur(Utilisateur user) throws DALException;
	
	public BllException validateUtilisateur(Utilisateur user);

	

}
