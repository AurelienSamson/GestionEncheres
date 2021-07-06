package fr.formation.gestionencheres.bo;

import java.util.ArrayList;
import java.util.List;

import fr.formation.gestionencheres.bll.Acquereur;
import fr.formation.gestionencheres.bll.Administrateur;
import fr.formation.gestionencheres.bll.Vendeur;

public class Utilisateur implements Administrateur, Acquereur, Vendeur{
	private Integer noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private Integer credit;
	private int administrateur;
	private List<ArticleEnVente> lstArticlesEnVente = new ArrayList<>();
	private List<Enchere> lstEncheres = new ArrayList<>();

	public Utilisateur() {
		super();
	}

	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, int administrateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, Integer credit, int administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public int getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(int administrateur) {
		this.administrateur = administrateur;
	}

	public List<ArticleEnVente> getVente() {
		return lstArticlesEnVente;
	}

	public void setVente(List<ArticleEnVente> vente) {
		this.lstArticlesEnVente = vente;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}

	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", lstArticlesEnVente=" + lstArticlesEnVente + ", lstEncheres=" + lstEncheres + "]";
	}

	@Override
	public void desactiverCompteUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCompte(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changerLibelleCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterArticleCategorie(Categorie categorie, ArticleEnVente article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerArticleCategorie(Categorie categorie, ArticleEnVente article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleEnVente> getArticlesEnVente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vendreArticle(ArticleEnVente article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void annulerVenteArticle(ArticleEnVente article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encherir(Integer credit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acheterArticle(ArticleEnVente article) {
		// TODO Auto-generated method stub
		
	}

}
