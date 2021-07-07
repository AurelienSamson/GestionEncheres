package fr.formation.gestionencheres.dal;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Retrait;
import fr.formation.gestionencheres.bo.Utilisateur;

/**
 * Servlet implementation class TestDAL
 */
@WebServlet("/TestDAL")
public class TestDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereDAO manager = EnchereDAOFact.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestDAL() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur aurelien = new Utilisateur("Aurel", "Samson", "Aurélien", "test@campus_eni.fr", "0000000000",
				"2 bis avenue de la gare", "29000", "Quimper", "zj,ng6845", 100, 0);
		Utilisateur guillaume = new Utilisateur("Guigui", "Samson", "Guillaume", "test2@campus_eni.fr", "1111111111",
				"La Forterie", "61400", "Saint-Langis", "erbhfg,558gb6d", 100, 1);
		Utilisateur delphine = new Utilisateur("Dedel", "Samson", "Delphine", "test3@campus_eni.fr", "2222222222",
				"La Forterie", "61400", "Saint-Langis", "ujyufdfdg54818fddf8v1v8v", 100, 1);

		Retrait stLangis = new Retrait("Rue des déportés", "61400", "Saint-Langis");
		Retrait quimper = new Retrait("5 rue Dean", "29000", "Quimper");
		Retrait alençon = new Retrait("3 rue de Potier", "61180", "Alençon");
		Retrait laval = new Retrait("32 rue de Rennes", "53000", "Laval");
		Retrait mondeville = new Retrait("6 rue des drogués", "14000", "Mondeville");

		Categorie info = new Categorie("Informatique");
		Categorie mobilier = new Categorie("Mobilier");
		Categorie vaisselle = new Categorie("Vaisselle");
		Categorie art = new Categorie("Art");
		Categorie voiture = new Categorie("Voiture");

		ArticleEnVente clavier = new ArticleEnVente("Corsair K70", "Clavier mécanique rgb", LocalDate.now(),
				LocalDate.now(), 100, 150, aurelien, info);
		ArticleEnVente souris = new ArticleEnVente("Aerox 3", "Souris Steelseries", LocalDate.now(), LocalDate.now(),
				70, 110, guillaume, info);
		ArticleEnVente peinture = new ArticleEnVente("Le cris Edward Munch", "Peinture impressioniste", LocalDate.now(),
				LocalDate.now(), 500, 1350, delphine, art);
		ArticleEnVente setNapoleon = new ArticleEnVente("set complet vaisselle", "napoléon", LocalDate.now(),
				LocalDate.now(), 700, 2800, guillaume, vaisselle);
		ArticleEnVente mustang = new ArticleEnVente("Mustang GT", "Ford", LocalDate.now(), LocalDate.now(), 36000,
				53000, aurelien, voiture);

		Enchere enchereClavier = new Enchere(LocalDate.now(), 150, aurelien, clavier);
		Enchere enchereSouris = new Enchere(LocalDate.now(), 110, guillaume, souris);
		Enchere encherepeinture = new Enchere(LocalDate.now(), 1350, delphine, peinture);
		Enchere enchereSetNapoleon = new Enchere(LocalDate.now(), 2800, guillaume, setNapoleon);
		Enchere enchereMustang = new Enchere(LocalDate.now(), 53000, aurelien, mustang);

		manager.insertCategorie(info);
		manager.insertCategorie(mobilier);
		manager.insertCategorie(vaisselle);
		manager.insertCategorie(art);
		manager.insertCategorie(voiture);
		
		manager.insertUtilisateur(aurelien);
		manager.insertUtilisateur(guillaume);
		manager.insertUtilisateur(delphine);
		
		manager.insertArticleVendu(clavier);
		manager.insertArticleVendu(souris);
		manager.insertArticleVendu(peinture);
		manager.insertArticleVendu(setNapoleon);
		manager.insertArticleVendu(mustang);
		
		manager.insertEnchere(enchereClavier);
		manager.insertEnchere(enchereSouris);
		manager.insertEnchere(encherepeinture);
		manager.insertEnchere(enchereSetNapoleon);
		manager.insertEnchere(enchereMustang);

		manager.insertRetraits(stLangis);
		manager.insertRetraits(quimper);
		manager.insertRetraits(alençon);
		manager.insertRetraits(laval);
		manager.insertRetraits(mondeville);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
