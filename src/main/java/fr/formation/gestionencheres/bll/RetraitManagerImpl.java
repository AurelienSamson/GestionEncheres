package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.Retrait;

public class RetraitManagerImpl implements RetraitManager {

	private static RetraitDAO dao = RetraitDAOFact.getInstance();
	
	 /**
     * @param retrait The instance to add to the DB
     * @throws BllException If there is any format issues with the instance
     * @throws DALException If there is any issues with the DAL part
     */
	@Override
	public void createRetrait(Retrait retrait) throws DALException,BllException{
		BllException bllException = validateRetrait(retrait);
		if(bllException.ErrorsExist()) {
			throw bllException;
		}else {
			dao.insertRetrait(retrait);
		}

	}


	@Override
	public Retrait getRetraitByNoArticle(Integer noArticle) throws DALException{
		
		return dao.selectRetraitByNoArticle(noArticle);
	}

	@Override
	public void updateRetrait(Retrait retrait) throws BllException, DALException{
		BllException bllException = validateRetrait(retrait);
		
		if(bllException.ErrorsExist()) {
			throw bllException;
		}else {
			dao.updateRetrait(retrait);
		}

	}

	@Override
	public void deleteRetrait(Retrait retrait) throws DALException{
		dao.deleteRetrait(retrait);
	}


	/**
     * We need to validate differents formats the user instance before any actions with the DB
     * Also: Check length of the different fields
     * @param retrait :  The instance to validate
     * @return An instance of BLLException filled with the error codes that have been raised
     */
	@Override
	public BllException validateRetrait(Retrait retrait) throws BllException {
		
		BllException bllException = new BllException();
		
		if(retrait.getRue().length()>30) {
			bllException.addError(BLLErrorCodes.LENGTH_RUE_RETRAIT_ERROR);
		}
		
		if(retrait.getCode_postal().length()>15) {
			bllException.addError(BLLErrorCodes.LENGTH_CODEPOSTAL_RETRAIT_ERROR);
		}
		
		if(retrait.getVille().length()>30) {
			bllException.addError(BLLErrorCodes.LENGTH_VILLE_RETRAIT_ERROR);
		}
		
		return bllException;
	}

}
