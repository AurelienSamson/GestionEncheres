package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.Retrait;

public interface RetraitManager {
	
	public void createRetrait(Retrait retrait) throws DALException, BllException;
	
	public Retrait getRetraitByNoArticle(Integer noArticle) throws DALException;
	
	public void updateRetrait(Retrait retrait) throws BllException, DALException;
	
	public void deleteRetrait(Retrait retrait) throws DALException;
	
	public BllException validateRetrait(Retrait retrait) throws BllException;	

}
