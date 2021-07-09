package fr.formation.gestionencheres.bll;

public class BLLErrorCodes {
	// User possible error codes
	static final Integer LENGTH_PSEUDO_UTILISATEUR_ERROR = 20001;
	static final Integer LENGTH_NOM_UTILISATEUR_ERROR = 20002;
	static final Integer LENGTH_PRENOM_UTILISATEUR_ERROR = 20003;
	static final Integer LENGTH_EMAIL_UTILISATEUR_ERROR = 20004;
	static final Integer LENGTH_TEL_UTILISATEUR_ERROR = 20005;
	static final Integer LENGTH_RUE_UTILISATEUR_ERROR = 20006;
	static final Integer LENGTH_CODEPOSTAL_UTILISATEUR_ERROR = 20007;
	static final Integer LENGTH_VILLE_UTILISATEUR_ERROR = 20008;
	static final Integer FORMAT_EMAIL_UTILISATEUR_ERROR = 20009;
	static final Integer FORMAT_TEL_UTILISATEUR_ERROR = 20010;
	static final Integer PSEUDO_OR_MAIL_TAKEN_ERROR = 20011;
	static final Integer PSEUDO_NOT_ALPHANUMERIC_ERROR = 20012;
	
	// Article possible error codes
	static final Integer LENGTH_NOM_ARTICLE_ERROR = 20013;
    static final Integer LENGTH_DESCRIPTION_ARTICLE_ERROR = 20014;
    static final Integer VALUE_STATUT_VENTE_ARTICLE_ERROR = 20015;
    static final Integer START_DATE_AFTER_END_DATE_ERROR = 20016;
    static final Integer DATE_BEFORE_TODAY_ERROR = 20017;
    
    // Categorie possible error codes
    static final Integer LENGTH_LIBELLE_CATEGORIE_ERROR = 20018;
    static final Integer LIBELLE_CATEGORIE_TAKEN_ERROR = 20019;
    
    // Retrait possible error codes
    static final Integer LENGTH_RUE_RETRAIT_ERROR = 20020;
    static final Integer LENGTH_CODEPOSTAL_RETRAIT_ERROR = 20021;
    static final Integer LENGTH_VILLE_RETRAIT_ERROR = 20022;
    
    static final Integer NO_RESULTS_ERROR = 20023;

}
