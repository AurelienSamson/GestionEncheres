package fr.formation.gestionencheres.dal;

import java.util.ArrayList;
import java.util.List;

public class DALException extends Exception {
	
	private List<Integer> lstErrorCodes;
	
	public DALException() {
		this.lstErrorCodes = new ArrayList<>();
	}
	
	/**
	 * 
	 * @param code: Integer associated to the error code in DalErrorCodes class
	 */
	public void addError(Integer code) {
		//if the list of error codes does not contains the code generated then add.
		if(!this.lstErrorCodes.contains(code)) {
			this.lstErrorCodes.add(code);
		}
	}

	
	/**
	 * 
	 * @return boolean: true if the instance contains some errors and false if not
	 */
	public boolean ErrorsExist() {
		return this.lstErrorCodes.size()>0;
	}
	
	/**
	 * 
	 * @return List: return list of error codes stored in the instance
	 */
	public List<Integer> getListErrorCodes(){
		return this.lstErrorCodes;
	}

}
