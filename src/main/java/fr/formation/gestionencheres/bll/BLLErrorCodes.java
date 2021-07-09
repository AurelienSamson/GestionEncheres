package fr.formation.gestionencheres.bll;

public class BLLErrorCodes {
	// User possible error codes
	static final Integer LENGTH_PSEUDO_UTILISATEUR_ERROR = null;
	static final Integer LENGTH_NOM_UTILISATEUR_ERROR = null;
	static final Integer LENGTH_PRENOM_UTILISATEUR_ERROR = null;
	static final Integer LENGTH_EMAIL_UTILISATEUR_ERROR = null;
	static final Integer LENGTH_TEL_UTILISATEUR_ERROR = null;
	static final Integer LENGTH_RUE_UTILISATEUR_ERROR = null;
	static final Integer LENGTH_CODEPOSTAL_UTILISATEUR_ERROR = null;
	static final Integer LENGTH_VILLE_UTILISATEUR_ERROR = null;
	static final Integer FORMAT_EMAIL_UTILISATEUR_ERROR = null;
	static final Integer FORMAT_TEL_UTILISATEUR_ERROR = null;
	static final Integer PSEUDO_OR_MAIL_TAKEN_ERROR = null;
	static final Integer PSEUDO_NOT_ALPHANUMERIC_ERROR = null;
	
	// Article possible error codes
	static final Integer LENGTH_NOM_ARTICLE_ERROR = null;
    static final Integer LENGTH_DESCRIPTION_ARTICLE_ERROR = null;
    static final Integer VALUE_STATUT_VENTE_ARTICLE_ERROR = null;
    static final Integer START_DATE_AFTER_END_DATE_ERROR = null;
    static final Integer DATE_BEFORE_TODAY_ERROR = null;
    
    // Categorie possible error codes
    static final Integer LENGTH_LIBELLE_CATEGORIE_ERROR = null;
    static final Integer LIBELLE_CATEGORIE_TAKEN_ERROR = null;
    
    // Retrait possible error codes
    static final Integer LENGTH_RUE_RETRAIT_ERROR = null;
    static final Integer LENGTH_CODEPOSTAL_RETRAIT_ERROR = null;
    static final Integer LENGTH_VILLE_RETRAIT_ERROR = null;
    
    static final Integer NO_RESULTS_ERROR = null;

}
