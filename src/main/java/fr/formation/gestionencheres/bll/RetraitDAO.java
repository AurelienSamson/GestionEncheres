package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.Retrait;

public interface RetraitDAO {
	
	public void insertRetrait(Retrait retrait) throws DALException, BllException;
	
	public Retrait selectRetraitByNoArticle(Integer noArticle) throws DALException;
	
	public List<Retrait> selectAllRetraits() throws DALException;
	
	public void updateRetrait(Retrait retrait) throws DALException;
	
	public void deleteRetrait(Retrait retrait) throws DALException;
	
	

}
