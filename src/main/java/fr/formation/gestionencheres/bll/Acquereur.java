package fr.formation.gestionencheres.bll;

import fr.formation.gestionencheres.bo.ArticleEnVente;

public interface Acquereur {
	public void encherir(Integer credit);
	
	public void acheterArticle(ArticleEnVente article);
}
