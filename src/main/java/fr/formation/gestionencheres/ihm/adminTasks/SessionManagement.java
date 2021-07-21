package fr.formation.gestionencheres.ihm.adminTasks;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.formation.gestionencheres.bll.UtilisateurManager;
import fr.formation.gestionencheres.bll.UtilisateurManagerSingl;
import fr.formation.gestionencheres.bo.Utilisateur;
import fr.formation.gestionencheres.dal.DALException;

public class SessionManagement {


	/**
	 * Set a session and register session attribute for 5 min = 300s
	 * @param request : request instance
	 */
	public static void setSessionConnected(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		session.setAttribute("isConnected", "true");
		
	}
	
	
	/**
	 * This method End the user session.
	 * @param request
	 */
	public static void endSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
	
	/**
	 * This method set the a session for a connected user identify by pseudo.
	 * @param request: request instance
	 * @param pseudo: utilisateur pseudo as in bo layer
	 * @throws DALException: in case there is any SQL issues in DAL
	 */
	public static void setUtilisateurSession(HttpServletRequest request, String pseudo) throws DALException{
		UtilisateurManager usermanager = UtilisateurManagerSingl.getInstance();
		HttpSession session = request.getSession();
		Utilisateur user = usermanager.getUtilisateurByPseudo(pseudo);
		session.setAttribute("userSession", user);
	}
}
