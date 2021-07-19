package fr.formation.gestionencheres.bll;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;
import fr.formation.gestionencheres.dal.UtilisateurDAO;
import fr.formation.gestionencheres.dal.UtilisateurDAOFact;

public class UtilisateurManagerImpl implements UtilisateurManager {

	private static UtilisateurDAO dao = UtilisateurDAOFact.getInstance();
	@Override
	public void createUtilisateur(Utilisateur user) throws BllException, DALException{
		
		BllException bllException = validateUtilisateur(user);
		if(!dao.checkForUniquePseudoAndMail(user.getPseudo(),user.getEmail())) {
			bllException.addError(BLLErrorCodes.PSEUDO_OR_MAIL_TAKEN_ERROR);
		}
		
		if(bllException.ErrorsExist()) {
			throw bllException;
		}else {
			dao.insert(user);
		}

	}

	@Override
	public Utilisateur getUtilisateurByNoUtilisateur(Integer noUtilisateur) throws DALException{
		
		return dao.selectUtilisateurByNoUtilisateur(noUtilisateur);
	}

	@Override
	public Utilisateur getUtilisateurByPseudo(String pseudo) throws DALException{
		
		return dao.selectUtilisateurByPseudo(pseudo);
	}

	@Override
	public HashMap<Integer, String> getNoArticlePseudoUtilisateurWithCurrentEnchere() throws DALException{
		
		return dao.selectNoArticlePseudoUtilisateurWithCurrentEnchere();
	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() throws DALException{
		return dao.selectAllUtilisateur();
	}

	@Override
	public void updateUtilisateur(Utilisateur user, boolean checkForMail, boolean checkForUtilisateur) throws BllException, DALException{
		BllException bllException = validateUtilisateur(user);
		// check if email already exist in the DBB
		if(checkForMail) {
			
			if(!dao.checkForUniqueMail(user.getEmail())) {
				bllException.addError(BLLErrorCodes.PSEUDO_OR_MAIL_TAKEN_ERROR);
			}
		}
		
		if(checkForUtilisateur) {
			
			if(!dao.checkForUniquePseudo(user.getPseudo())) {
				bllException.addError(BLLErrorCodes.PSEUDO_OR_MAIL_TAKEN_ERROR);
			}
		}
		
		if(bllException.ErrorsExist()) {
			throw bllException;
		}else {
			dao.updateUtilisateur(user);
		}
		

	}

	@Override
	public void updateCredit(Integer noUtilisateur, Integer newCredit) throws DALException{
		dao.updateCredit(noUtilisateur, newCredit);

	}

	@Override
	public void deleteUtilisateur(Utilisateur user) throws DALException{
		dao.deleteUtilisateur(user);

	}

	@Override
	public BllException validateUtilisateur(Utilisateur user) {
		// Expressions regulieres pour valider les formats: Pseudo, email, telephone
		// Site Utilisé pour construire ces expressions:  https://regex101.com/ 
		
		String pseudoValidationRegularExpression = "^[A-Za-z0-9]+";
		String emailValidationRegularExpression = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		String telephoneValidationRegularExpression = "^0[1-9][0-9]{8}$";
		
		
		BllException bllException = new BllException();
		
		if(user.getPseudo().length()>30) {
			bllException.addError(BLLErrorCodes.LENGTH_PSEUDO_UTILISATEUR_ERROR);
		}
		
		if(!Pattern.matches(pseudoValidationRegularExpression, user.getPseudo())) {
			bllException.addError(BLLErrorCodes.PSEUDO_NOT_ALPHANUMERIC_ERROR);
		}
		
		if(user.getNom().length()>30) {
			bllException.addError(BLLErrorCodes.LENGTH_NOM_UTILISATEUR_ERROR);
		}
		
		if(user.getPrenom().length()>30) {
			bllException.addError(BLLErrorCodes.LENGTH_PRENOM_UTILISATEUR_ERROR);
		}
		
		if(user.getEmail().length()>50) {
			bllException.addError(BLLErrorCodes.LENGTH_EMAIL_UTILISATEUR_ERROR);
		}
		
		//TO DO: Check for Format Email:  Not yet found an appropriate Regular expression
		if(!Pattern.matches(emailValidationRegularExpression, user.getEmail())) {
			bllException.addError(BLLErrorCodes.FORMAT_EMAIL_UTILISATEUR_ERROR);
		}
		
		if(user.getTelephone().length()>15) {
			bllException.addError(BLLErrorCodes.LENGTH_TEL_UTILISATEUR_ERROR);
		}
		
		if(!Pattern.matches(telephoneValidationRegularExpression, user.getTelephone())) {
			bllException.addError(BLLErrorCodes.FORMAT_TEL_UTILISATEUR_ERROR);
		}
		
		if(user.getRue().length()>30) {
			bllException.addError(BLLErrorCodes.LENGTH_RUE_UTILISATEUR_ERROR);
		}
		
		if(user.getCodePostal().length()>10) {
			bllException.addError(BLLErrorCodes.LENGTH_CODEPOSTAL_UTILISATEUR_ERROR);
		}
		
		if(user.getVille().length()>50) {
			bllException.addError(BLLErrorCodes.LENGTH_VILLE_UTILISATEUR_ERROR);
		}
		
		
		return bllException;
	}

}
