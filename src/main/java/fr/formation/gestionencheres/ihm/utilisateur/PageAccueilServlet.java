package fr.formation.gestionencheres.ihm.utilisateur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.gestionencheres.bll.CategorieManager;
import fr.formation.gestionencheres.bll.CategorieManagerSingl;
import fr.formation.gestionencheres.dal.DALException;

/**
 * Servlet implementation class PageAccueilServlet
 */
@WebServlet("/PageAccueilServlet")
public class PageAccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PageAccueilModel accueilModel = new PageAccueilModel();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAccueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager categorieManager = new CategorieManagerSingl().getInstance();
		try {
			accueilModel.setCategories(categorieManager.getAllCategories());
			request.setAttribute("categories", accueilModel.getCategories());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/pagesWeb/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
