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

/**
 * Servlet implementation class SeeUtilisateurServlet
 */
@WebServlet("/SeeUtilisateurServlet")
public class SeeUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/index.jsp");
        request.setAttribute("page", "profile");
        UtilisateurManager userManager = UtilisateurManagerSingl.getInstance();
        List<String> lstErrors = new ArrayList<>();
        try {
            Utilisateur user = userManager.getUtilisateurByNoUtilisateur(Integer.valueOf(request.getParameter("noUtilisateur")));
            request.setAttribute("utilisateurRequest", user);
            // If the noUtilisateursare the same,the  user can update it
            if (user.getNoUtilisateur() == Integer.valueOf(request.getParameter("noUtilisateur"))) {
                request.setAttribute("canUpdate", "true");
            }
        } catch (DALException e) {
            ErrorsManagement.DALExceptionCather(e, lstErrors, request);
        }
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
