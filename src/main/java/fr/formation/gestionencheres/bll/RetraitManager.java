package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.Retrait;

public interface RetraitManager {
	
	public void createRetrait(Retrait retrait);
	
	public List<Retrait> getAllRetrait();
	
	public Retrait getRetraitByNoArticle(Integer noArticle);
	
	public void updateRetrait(Retrait retrait);
	
	public void deleteRetrait(Retrait retrait);
	
	

}
