package fr.formation.gestionencheres.dal;

import java.util.List;

import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.bo.Retrait;

public interface RetraitDAO {

	public void insertRetrait(Retrait retrait) throws DALException, BllException;

	public Retrait selectRetraitByNoArticle(Integer noArticle) throws DALException;

	public List<Retrait> selectAllRetraits() throws DALException;

	public void updateRetrait(Retrait retrait) throws DALException;

	public void deleteRetrait(Retrait retrait) throws DALException;

}
