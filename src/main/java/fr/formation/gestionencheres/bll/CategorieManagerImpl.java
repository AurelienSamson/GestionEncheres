package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.dal.CategorieDAO;
import fr.formation.gestionencheres.dal.CategorieDAOFact;
import fr.formation.gestionencheres.dal.DALException;

public class CategorieManagerImpl implements CategorieManager {

	private static CategorieDAO dao = CategorieDAOFact.getInstance();
	
	@Override
	public void createCategorie(Categorie categorie) throws BllException, DALException{
		
		BllException bllException = new BllException();
		
		if(categorie.getLibelle().length()>30) {
			bllException.addError(BLLErrorCodes.LENGTH_LIBELLE_CATEGORIE_ERROR);
		}		
		
		if(bllException.ErrorsExist()) {
			throw bllException;
		}else {
			dao.insertCategorie(categorie);
		}

	}

	@Override
	public Categorie getCategorieByNoCategorie(Integer noCategorie) throws DALException{
		
		return dao.selectCategorieByNoCategorie(noCategorie);
	}

	@Override
	public List<Categorie> getAllCategories() throws DALException{
	
		return dao.selectAllCategories();
	}

}
