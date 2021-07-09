package fr.formation.gestionencheres.dal;

import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Override
	public void insert(Utilisateur user) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur selectUtilisateurByNoUtilisateur(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAllUtilisateur() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUtilisateur(Utilisateur user) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUtilisateur(Utilisateur user) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DALException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkForUniquePseudo(String pseudo) throws DALException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkForUniqueMail(String mail) throws DALException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, String> selectNoArticlePseudoUtilisateurWithCurrentEnchere() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCredit(Integer noUtilisateur, Integer newCredit) throws DALException {
		// TODO Auto-generated method stub

	}

}
