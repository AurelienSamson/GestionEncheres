package fr.formation.gestionencheres.ihm.adminTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.gestionencheres.bll.ArticleEnVenteManager;
import fr.formation.gestionencheres.bll.ArticleEnVenteManagerSingl;
import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.bll.CategorieManager;
import fr.formation.gestionencheres.bll.CategorieManagerSingl;
import fr.formation.gestionencheres.bll.UtilisateurManager;
import fr.formation.gestionencheres.bll.UtilisateurManagerSingl;
import fr.formation.gestionencheres.dal.DALException;

public class RequestManagement {
	
	public static void manageHomePageAttributes(HttpServletRequest request) throws DALException, BllException{
		ArticleEnVenteManager articleManager = ArticleEnVenteManagerSingl.getInstance();
		CategorieManager categorieManager = CategorieManagerSingl.getInstance();
		UtilisateurManager userManager = UtilisateurManagerSingl.getInstance();
		
		request.setAttribute("currentEnchere", articleManager.getAllArticleEnVentes());
        request.setAttribute("categories", categorieManager.getAllCategories());
        request.setAttribute("pseudos", userManager.getNoArticlePseudoUtilisateurWithCurrentEnchere());	
	}
	
	
	public static void manageInsertOrUpdateEncherePageAttributes(HttpServletRequest request, HttpServletResponse response) throws IOException{
		CategorieManager categorieManager = CategorieManagerSingl.getInstance();
		try {
			request.setAttribute("categories", categorieManager.getAllCategories());
		} catch (DALException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	

}
