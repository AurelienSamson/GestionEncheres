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

import fr.formation.gestionencheres.bll.UtilisateurManager;
import fr.formation.gestionencheres.bll.UtilisateurManagerSingl;
import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;
import fr.formation.gestionencheres.ihm.adminTasks.ErrorsManagement;
import fr.formation.gestionencheres.ihm.adminTasks.SessionManagement;

/**
 * Servlet implementation class DeleteUtilisateurServlet
 */
@WebServlet("/DeleteUtilisateurServlet")
public class DeleteUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       List<String> lstErrors = new ArrayList<>();
	        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/index.jsp");
	        UtilisateurManager userManager =  UtilisateurManagerSingl.getInstance();
	        try {
	            Utilisateur userToDelete = userManager.getUtilisateurByPseudo(request.getUserPrincipal().getName());
	            userManager.deleteUtilisateur(userToDelete);
	        } catch (DALException e) {
	            ErrorsManagement.DALExceptionCather(e, lstErrors, request);;
	        }
	        if (lstErrors.isEmpty()) {
	            request.setAttribute("loginDeleted", "true");
	            request.setAttribute("page", "home");
	        } else {
	            request.setAttribute("page", "updateProfile");
	        }
	        SessionManagement.endSession(request);;
	        rd.forward(request, response);
	}

}
