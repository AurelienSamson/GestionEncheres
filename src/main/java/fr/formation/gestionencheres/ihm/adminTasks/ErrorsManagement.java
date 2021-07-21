package fr.formation.gestionencheres.ihm.adminTasks;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.dal.DALException;
import fr.formation.gestionencheres.ihm.messages.ErrorMessageBodyReader;

public class ErrorsManagement {
	
	/**
	 * This method deals with BllException errors message and put them into a list
	 * @param errorBll: a BllException
	 * @param lstErrors : List of errors
	 * @param request: the instance of the HTTP request
	 */
	public static void BllExceptionCather(BllException errorBll, List<String> lstErrors, HttpServletRequest request) {
		for(Integer errorCode : errorBll.getListErrorCodes()) {
			lstErrors.add(ErrorMessageBodyReader.getErrorMessageBodyReader(errorCode));
		}
		request.setAttribute("lstErrors", lstErrors);
		
	}
	
	/**
	 * This method deals with DallException errors message and put them into a list
	 * @param errorDal: a DALLException
	 * @param lstErrors : List of errors
	 * @param request: the instance of the HTTP request
	 */
	public static void DALExceptionCather(DALException errorDal, List<String> lstErrors, HttpServletRequest request) {
		request.setAttribute("errorName", "Erreur au niveau de la BDD");
		for(Integer errorCode : errorDal.getListErrorCodes()) {
			lstErrors.add(ErrorMessageBodyReader.getErrorMessageBodyReader(errorCode));
		}
		request.setAttribute("lstErrors", lstErrors);
		
	}

}
