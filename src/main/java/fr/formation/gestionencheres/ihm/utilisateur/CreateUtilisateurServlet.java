package fr.formation.gestionencheres.ihm.utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.bll.UtilisateurManager;
import fr.formation.gestionencheres.bll.UtilisateurManagerSingl;
import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;
import fr.formation.gestionencheres.ihm.adminTasks.ErrorsManagement;
import fr.formation.gestionencheres.ihm.adminTasks.RequestManagement;

/**
 * Servlet implementation class CreateUtilisateurServlet
 */
@WebServlet("/CreateUtilisateurServlet")
public class CreateUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUtilisateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/index.jsp");
	        request.setAttribute("page", "createLogin");
	        rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UtilisateurManager usermanager = UtilisateurManagerSingl.getInstance();
		List<String> lstErros = new ArrayList<>();
		// String motDePasse = request.getParameter("motDePasse");
		// request parameters for new user
		Utilisateur user = new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"),
				request.getParameter("prenom"), request.getParameter("email"), request.getParameter("telephone"),
				request.getParameter("rue"), request.getParameter("codePostal"), request.getParameter("ville"),
				request.getParameter("motDePasse"), 0, false);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		try {
			usermanager.createUtilisateur(user);
		} catch (BllException e) {
			ErrorsManagement.BllExceptionCather(e, lstErros, request);
			e.printStackTrace();
		} catch (DALException e) {
			ErrorsManagement.DALExceptionCather(e, lstErros, request);
			e.printStackTrace();
		}

		if (lstErros.isEmpty()) {
			try {
				RequestManagement.manageHomePageAttributes(request);
			} catch (DALException e) {
				ErrorsManagement.DALExceptionCather(e, lstErros, request);
				e.printStackTrace();
			} catch (BllException e) {
				ErrorsManagement.BllExceptionCather(e, lstErros, request);
				e.printStackTrace();
			}
			request.setAttribute("loginCreated", "true");
			request.setAttribute("page", "home");
		} else {
			request.setAttribute("page", "createLogin");
			request.setAttribute("utilisateurError", user);
		}
		rd.forward(request, response);
	}

}
