package fr.formation.gestionencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Retrait;
import fr.formation.gestionencheres.bo.Utilisateur;

public class EnchereDAOImpl implements EnchereDAO {
	private final String SQL_INSERT_ARTICLE_VENDU = "INSERT INTO ARTICLES_VENDUS VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private final String SQL_INSERT_CATEGORIE = "INSERT INTO CATEGORIES VALUES (?);";
	private final String SQL_INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final String SQL_INSERT_RETRAIT = "INSERT INTO RETRAITS VALUES (?, ?, ?, ?);";
	private final String SQL_INSERT_ENCHERE = "INSERT INTO ENCHERES VALUES (?, ?, ?, ?)";

	private final String SQL_UPDATE_ARTICLE_VENDU = "UPDATE ARTICLES_VENDU SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ? WHERE no_article = ?;";
	private final String SQL_UPDATE_ARTICLE_VENDU_PRIX_INITIAL = "UPDATE ARTICLES_VENDU SET prix_vente = ? WHERE no_article = ?;";
	private final String SQL_UPDATE_RETRAIT = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?;";
	private final String SQL_UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?;";
	private final String SQL_UPDATE_UTILISATEURS_CREDIT = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur = ?;";

	private final String SQL_DELETE_ARTICLE_VENDU = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?;";
	private final String SQL_DELETE_RETRAITS = "DELETE FROM RETRAITS WHERE no_article = ?;";
	private final String SQL_DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;";
	
	private final String SQL_SELECT_ARTICLE_VENDU = "SELECT * FROM ARTICLES_VENDUS;";
	private final String SQL_SELECT_ARTICLES_VENDUS_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?;";
	private final String SQL_SELECT_ENCHERE = "SELECT * FROM ENCHERES;";
	private final String SQL_SELECT_RETRAIT = "SELECT * FROM RETRAITS;";
	private final String SQL_SELECT_RETRAIT_ID = "SELECT * FROM RETRAITS WHERE no_article = ?;";
	private final String SQL_SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS;";
	private final String SQL_SELECT_CATEGORIE = "SELECT * FROM CATEGORIE;";
	private final String SQL_SELECT_UTILISATEUR_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	private final String SQL_SELECT_UTILISATEUR_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?;";
	private final String SQL_SELECT_CATEGORIE_ID = "SELECT * FROM CATEGORIE WHERE no_categorie = ?;";
	private final String SQL_SELECT_CATEGORIE_LIBELLE = "SELECT * FROM CATEGORIE WHERE libelle = ?;";
	private final String SQL_SELECT_ARTICLES_VENDUS_BY_UTILISATEUR = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES_VENDUS WHERE no_utilisateur = ?;";
	private final String SQL_SELECT_ARTICLES_VENDUS_BY_CATEGORIE = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES_VENDUS WHERE no_categorie = ?;";
	private final String SQL_SELECT_ARTICLES_VENDUS_BY_CATEGORIE_INNER_JOIN = "SELECT c.libelle, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES_VENDUS av INNER JOIN CATEGORIES c ON av.no_categorie = c.no_categorie ORDER BY c.libelle ASC;";
	private final String SQL_SELECT_ARTICLES_VENDUS_ORDER_BY_NOM_ARTICLE = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES_VENDUS ORDER BY nom_article ASC;";
	private final String SQL_SELECT_ENCHERE_PLUS_HAUTE_ET_UTILISATEUR = "SELECT montant_enchere, e.no_utilisateur FROM ENCHERES INNER JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur ORDER BY montant_enchere DESC;";
	
	private int idRetrait = 1;

	@Override
	public void insertArticleVendu(ArticleEnVente article) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_INSERT_ARTICLE_VENDU,
					Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, article.getNom());
			stm.setString(2, article.getDescription());
			stm.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			stm.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			stm.setInt(5, article.getMiseAPrix());
			stm.setInt(6, article.getPrixVente());
			stm.setInt(7, article.getUser().getNoUtilisateur());
			stm.setInt(8, article.getCategorie().getNoCategorie());
			int nb = stm.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next()) {
					article.setNoArticle(rs.getInt(1));
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertCategorie(Categorie categorie) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_INSERT_CATEGORIE, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, categorie.getLibelle());
			int nb = stm.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next()) {
					categorie.setNoCategorie(rs.getInt(1));
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertUtilisateur(Utilisateur user) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_INSERT_UTILISATEUR,
					Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, user.getPseudo());
			stm.setString(2, user.getNom());
			stm.setString(3, user.getPrenom());
			stm.setString(4, user.getEmail());
			stm.setString(5, user.getTelephone());
			stm.setString(6, user.getRue());
			stm.setString(7, user.getCodePostal());
			stm.setString(8, user.getVille());
			stm.setString(9, user.getMotDePasse());
			stm.setInt(10, user.getCredit());
			stm.setInt(11, user.getAdministrateur());
			int nb = stm.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next()) {
					user.setNoUtilisateur(rs.getInt(1));
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertRetraits(Retrait retrait) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_INSERT_RETRAIT);
			stm.setInt(1, idRetrait);
			stm.setString(2, retrait.getRue());
			stm.setString(3, retrait.getCode_postal());
			stm.setString(4, retrait.getVille());
			stm.executeUpdate();
			idRetrait++;
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertEnchere(Enchere enchere) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_INSERT_ENCHERE);
			stm.setDate(1, Date.valueOf(enchere.getDateEnchere()));
			stm.setInt(2, enchere.getMontant_enchere());
			stm.setInt(3, enchere.getArticle().getNoArticle());
			stm.setInt(4, enchere.getUser().getNoUtilisateur());
			stm.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateArticleEnVente(ArticleEnVente article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArticleCurrentPrice(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRetrait(Retrait retrait) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCredit(Integer noUtilisateur, Integer newCredit) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticleEnVente(ArticleEnVente article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRetrait(Retrait retrait) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur getUserByID(Integer id) {
		Utilisateur utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_UTILISATEUR_ID);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getInt("administrateur"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public Utilisateur getUserByPseudo(String pseudo) {
		Utilisateur utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_UTILISATEUR_PSEUDO);
			stm.setString(1, pseudo);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getInt("administrateur"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public Categorie getCategorieById(Integer id) {
		Categorie categorie = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_CATEGORIE_ID);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				categorie = new Categorie(rs.getString("libelle"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}

	@Override
	public Categorie getCategorieByLibelle(String libelle) {
		Categorie categorie = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_CATEGORIE_LIBELLE);
			stm.setString(1, libelle);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				categorie = new Categorie(rs.getString("libelle"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}

	@Override
	public ArticleEnVente getArticleEnVenteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retrait getRetraitByNoArticle(Integer noArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> getArticlesVendus() {
		List<ArticleEnVente> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			ArticleEnVente article;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ARTICLE_VENDU);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				article = new ArticleEnVente(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"));
				articles.add(article);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<Enchere> getEncheres() {
		List<Enchere> encheres = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			Enchere enchere;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ENCHERE);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				enchere = new Enchere(rs.getDate("date_enchere").toLocalDate(), rs.getInt("montant_enchere"));
				encheres.add(enchere);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encheres;
	}

	@Override
	public List<Retrait> getRetraits() {
		List<Retrait> retraits = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			Retrait retrait;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_RETRAIT);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				retrait = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				retraits.add(retrait);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retraits;
	}

	@Override
	public List<Utilisateur> getUtilisateurs() {
		List<Utilisateur> utilisateurs = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			Utilisateur utilisateur;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_UTILISATEUR);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getInt("administrateur"));
				utilisateurs.add(utilisateur);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateurs;
	}

	@Override
	public List<Categorie> getCategories() {
		List<Categorie> categories = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			Categorie categorie;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_CATEGORIE);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				categorie = new Categorie(rs.getString("libelle"));
				categories.add(categorie);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<ArticleEnVente> getArticlesEnVenteByEtatVente(ArticleEnVente article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> getArticlesEnVenteByVendeurAndEtatVente(Utilisateur user, ArticleEnVente article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> getArticlesAcquireByUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> getArticlesAndEtatVenteByUtilisateur(Utilisateur user, ArticleEnVente article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getAllCurrentEncheres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getAllCurrentEncheresOrderedByCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getAllCurrentEncheresOrderedByNomArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getAllEncheresWhereUtilisateurSetOffer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> getArticleEnVenteFromCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> getArticleEnVenteOrderedByNom(ArticleEnVente article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<ArticleEnVente, Integer> getAmountAndUtilisateurOfBestOfferFromArticleEnVente(ArticleEnVente article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, String> getArticlePseudoUtilisateurWithCurrentEnchere() {
		// TODO Auto-generated method stub
		return null;
	}

}
