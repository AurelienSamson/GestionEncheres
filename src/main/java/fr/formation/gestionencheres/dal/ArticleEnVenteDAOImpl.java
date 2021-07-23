package fr.formation.gestionencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Utilisateur;

public class ArticleEnVenteDAOImpl implements ArticleEnVenteDAO {
	private final String SQL_INSERT_ARTICLE_VENDU = "INSERT INTO ARTICLES_VENDUS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final String SQL_UPDATE_ARTICLE_VENDU = "UPDATE ARTICLES_VENDU SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ? WHERE no_article = ?;";
	private final String SQL_UPDATE_ARTICLE_VENDU_PRIX_INITIAL = "UPDATE ARTICLES_VENDU SET prix_vente = ? WHERE no_article = ?;";
	private final String SQL_DELETE_ARTICLE_VENDU = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?;";
	private final String SQL_SELECT_ARTICLE_VENDU = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM ARTICLES_VENDUS av INNER JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur;";
	private final String SQL_SELECT_ARTICLES_VENDUS_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?;";
	private final String SQL_SELECT_ARTICLES_VENDUS_BY_CATEGORIE = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES_VENDUS WHERE no_categorie = ?;";
	private final String SQL_SELECT_ARTICLES_VENDUS_BY_CATEGORIE_INNER_JOIN = "SELECT c.libelle, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES_VENDUS av INNER JOIN CATEGORIES c ON av.no_categorie = c.no_categorie ORDER BY c.libelle ASC;";
	private final String SQL_SELECT_ARTICLES_VENDUS_ORDER_BY_NOM_ARTICLE = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES_VENDUS ORDER BY nom_article ASC;";
	private final String SQL_SELECT_ARTICLES_VENDUS_BY_ETAT_VENTE = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente FROM ARTICLES_VENDUS WHERE etat_vente = ?;";
	private final String SQL_SELECT_ARTICLES_VENDUS_BY_ETAT_VENTE_AND_VENDEUR = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente FROM ARTICLES_VENDUS WHERE etat_vente = ? and no_utilisateur = ?;";
	private final String SQL_SELECT_ARTICLES_VENDUS_WHERE_IS_OFFER = "SELECT * FROM ARTICLES_VENDUS WHERE prix_vente IS NOT NULL ;";
	private final String SQL_SELECT_ARTICLES_VENDUS_BY_UTILISATEUR = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ARTICLES_VENDUS WHERE no_utilisateur = ?;";

	@Override
	public void insertArticleEnVente(ArticleEnVente article) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_INSERT_ARTICLE_VENDU,
					Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, article.getNom());
			stm.setString(2, article.getDescription());
			stm.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			stm.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			stm.setInt(5, article.getMiseAPrix());
			stm.setInt(6, article.getPrixVente());
			stm.setString(7, article.getEtatVente());
			stm.setInt(8, article.getUser().getNoUtilisateur());
			stm.setInt(9, article.getCategorie().getNoCategorie());
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
	public void updateArticleEnVente(ArticleEnVente article) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_UPDATE_ARTICLE_VENDU);
			stm.setString(1, article.getNom());
			stm.setString(2, article.getDescription());
			stm.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			stm.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			stm.setInt(5, article.getMiseAPrix());
			stm.setInt(6, article.getPrixVente());
			stm.setInt(7, article.getNoArticle());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateArticleCurrentPrice(Integer noArticle, Integer newPrice) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_UPDATE_ARTICLE_VENDU_PRIX_INITIAL);
			stm.setInt(6, newPrice);
			stm.setInt(2, noArticle);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteArticleEnVente(ArticleEnVente article) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_DELETE_ARTICLE_VENDU);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArticleEnVente selectArticleEnVenteByNoArticle(Integer noArticle) {
		ArticleEnVente article = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ARTICLES_VENDUS_ID);
			stm.setInt(1, noArticle);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				article = new ArticleEnVente(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getString("etat_vente"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public List<ArticleEnVente> selectAllArticleEnVentes() {
		List<ArticleEnVente> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			ArticleEnVente article;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ARTICLE_VENDU);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				article = new ArticleEnVente(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getString("etat_vente"), new Utilisateur(rs.getString("pseudo"), 
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), 
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur")));
				articles.add(article);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteByEtatVente(String etat) {
		List<ArticleEnVente> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			ArticleEnVente article;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ARTICLES_VENDUS_BY_ETAT_VENTE);
			stm.setString(1, etat);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				article = new ArticleEnVente(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getString("etat_vente"));
				articles.add(article);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteByVendeurAndEtatVente(Integer id, String etat) {
		List<ArticleEnVente> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			ArticleEnVente article;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ARTICLES_VENDUS_BY_ETAT_VENTE_AND_VENDEUR);
			stm.setString(1, etat);
			stm.setInt(2, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				article = new ArticleEnVente(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getString("etat_vente"));
				articles.add(article);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteOrderByNom() {
		List<ArticleEnVente> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			ArticleEnVente article;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ARTICLES_VENDUS_ORDER_BY_NOM_ARTICLE);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				article = new ArticleEnVente(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getString("etat_vente"));
				articles.add(article);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticleEnVente> selectArticlesAcquireByUtilisateur(Integer id) {
		List<ArticleEnVente> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			ArticleEnVente article;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ARTICLES_VENDUS_BY_UTILISATEUR);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				article = new ArticleEnVente(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getString("etat_vente"));
				articles.add(article);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticleEnVente> selectAllArticlesEnVenteWhereUtilisateurSetOffer() {
		List<ArticleEnVente> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			ArticleEnVente article;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ARTICLES_VENDUS_WHERE_IS_OFFER);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				article = new ArticleEnVente(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getString("etat_vente"));
				articles.add(article);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteByCategorie(Categorie categorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleEnVente> selectArticleEnVenteByNom(String nomArticle) throws DALException, BllException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public HashMap<Integer, String> selectArticlePseudoUtilisateurWithCurrentEnchere() {
//		// TODO Mettre une HashMap?
//		return null;
//	}

}
