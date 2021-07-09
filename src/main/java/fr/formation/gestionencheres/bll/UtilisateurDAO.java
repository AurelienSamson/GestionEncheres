package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	
	public void insert(Utilisateur user) throws DALException;
	
	public Utilisateur selectUtilisateurByNoUtilisateur(Integer noUtilisateur) throws DALException;
	
	public List<Utilisateur> selectAllUtilisateur() throws DALException;
	
	public void updateUtilisateur(Utilisateur user) throws DALException;
	
	public void deleteUtilisateur(Utilisateur user) throws DALException;
	
	public boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DALException;
	
	public boolean checkForUniquePseudo(String pseudo) throws DALException;
	
	public boolean checkForUniqueMail(String mail) throws DALException;
	
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws DALException;
	
	public  HashMap<Integer, String> selectNoArticlePseudoUtilisateurWithCurrentEnchere() throws DALException;
	
	public void updateCredit(Integer noUtilisateur, Integer newCredit) throws DALException;
}
