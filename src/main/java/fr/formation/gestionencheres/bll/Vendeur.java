package fr.formation.gestionencheres.bll;

import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;

public interface Vendeur {
	public List<ArticleEnVente> getArticlesEnVente();
	
	public void vendreArticle(ArticleEnVente article);
	
	public void annulerVenteArticle(ArticleEnVente article);
}
