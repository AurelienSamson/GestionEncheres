package fr.formation.gestionencheres.bo;

import java.util.List;

public interface Vendeur {
	public List<ArticleEnVente> getArticlesEnVente();
	
	public void vendreArticle(ArticleEnVente article);
	
	public void annulerVenteArticle(ArticleEnVente article);
}
