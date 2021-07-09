package fr.formation.gestionencheres.bll;

import java.util.ArrayList;
import java.util.List;

public class BllException extends Exception {
	private List<Integer> lstErrorCodes;
	
	public BllException() {
		this.lstErrorCodes = new ArrayList<>();
	}
	
	public void addError(Integer code) {
		//if the list of error codes does not contains the code generated then add.
		if(!this.lstErrorCodes.contains(code)) {
			this.lstErrorCodes.add(code);
		}
	}

	
	public boolean ErrorsExist() {
		return this.lstErrorCodes.size()>0;
	}
	
	public List<Integer> getListErrorCodes(){
		return this.lstErrorCodes;
	}
}
