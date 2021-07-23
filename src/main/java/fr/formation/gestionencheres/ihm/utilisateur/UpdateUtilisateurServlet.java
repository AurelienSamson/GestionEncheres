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
import fr.formation.gestionencheres.ihm.adminTasks.SessionManagement;

/**
 * Servlet implementation class UpdateUtilisateurServlet
 */
@WebServlet("/UpdateUtilisateurServlet")
public class UpdateUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUtilisateurServlet() {
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
        UtilisateurManager userManager = UtilisateurManagerSingl.getInstance();
        request.setCharacterEncoding("UTF-8");
        List<String> lstErrors = new ArrayList<>();
        boolean checkForPseudo = true;
        boolean checkForMail = true;
        try {
            Utilisateur userToUpdate = userManager.getUtilisateurByPseudo(request.getUserPrincipal().getName());
            String originalPseudo = userToUpdate.getPseudo();
            String originalMail = userToUpdate.getEmail();
            if (originalPseudo.equals(request.getParameter("pseudo"))) {
                checkForPseudo = false;
            }
            
            userToUpdate.setPseudo(request.getParameter("pseudo"));
            userToUpdate.setNom(request.getParameter("name"));
            userToUpdate.setPrenom(request.getParameter("firstName"));
            if (originalMail.equals(request.getParameter("email"))) {
                checkForMail = false;
            }
            userToUpdate.setEmail(request.getParameter("email"));
            userToUpdate.setTelephone(request.getParameter("telephone"));
            userToUpdate.setRue(request.getParameter("street"));
            userToUpdate.setCodePostal(request.getParameter("codePostal"));
            userToUpdate.setVille(request.getParameter("town"));
            if (!request.getParameter("new_password").isEmpty()) {
            	userToUpdate.setMotDePasse((request.getParameter("new_password")));
            }
            userManager.updateUtilisateur(userToUpdate, checkForMail, checkForPseudo);
            SessionManagement.setUtilisateurSession(request, userToUpdate.getPseudo());
        } catch (DALException e) {
            ErrorsManagement.DALExceptionCather(e, lstErrors, request);
        } catch (BllException e) {
            ErrorsManagement.BllExceptionCather(e, lstErrors, request);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
        if (lstErrors.isEmpty()) {
            try {
                RequestManagement.manageHomePageAttributes(request);
            } catch (DALException e) {
                ErrorsManagement.DALExceptionCather(e, lstErrors, request);
            } catch (BllException e) {
                ErrorsManagement.BllExceptionCather(e, lstErrors, request);
            }
            request.setAttribute("loginUpdated", "true");
            request.setAttribute("page", "home");
        } else {
            request.setAttribute("page", "updateProfile");
        }
        rd.forward(request, response);
	}

}
