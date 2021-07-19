package fr.formation.gestionencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;
import fr.formation.gestionencheres.bo.Enchere;
import fr.formation.gestionencheres.bo.Retrait;
import fr.formation.gestionencheres.bo.Utilisateur;

public class EnchereDAOImpl implements EnchereDAO {
	private final String SQL_INSERT_ENCHERE = "INSERT INTO ENCHERES VALUES (?, ?, ?, ?)";
	private final String SQL_SELECT_ENCHERE = "SELECT * FROM ENCHERES;";
	private final String SQL_SELECT_ENCHERE_ORDERED_BY_NOM_ARTICLE = "SELECT e.date_enchere, e.montant_enchere, c.libelle FROM ENCHERES e INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article INNER JOIN CATEGORIES c ON av.no_categorie = c.no_categorie ORDER BY c.libelle ASC;";

	private final String SQL_SELECT_ENCHERE_PLUS_HAUTE_ET_UTILISATEUR = "SELECT TOP 1 e.date_enchere, e.montant_enchere, u.pseudo, u.nom, u.prenom, u.email, u.telephone, u.rue, u.code_postal, u.ville, u.mot_de_passe, u.credit, u.administrateur FROM ARTICLES_VENDUS av INNER JOIN ENCHERES e ON av.no_utilisateur = e.no_utilisateur INNER JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur ORDER BY montant_enchere DESC;";

	@Override
	public void insertEnchere(Enchere enchere) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_INSERT_ENCHERE);
			stm.setTimestamp(1, Timestamp.valueOf(enchere.getDateEnchere()));
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
	public List<Enchere> selectEncheres() {
		List<Enchere> encheres = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			Enchere enchere;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ENCHERE);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				enchere = new Enchere(rs.getTimestamp("date_enchere").toLocalDateTime(), rs.getInt("montant_enchere"));
				encheres.add(enchere);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encheres;
	}

	@Override
	public List<Enchere> selectAllCurrentEncheres() {
		List<Enchere> encheres = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			Enchere enchere;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ENCHERE);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				enchere = new Enchere(rs.getTimestamp("date_enchere").toLocalDateTime(), rs.getInt("montant_enchere"));
				encheres.add(enchere);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encheres;
	}

//	@Override
//	public List<Enchere> getAllCurrentEncheresOrderedByCategorie() {
//		// TODO Mettre une HashMap?
//		return null;
//	}

	@Override
	public List<Enchere> selectAllCurrentEncheresOrderedByNomArticle() {
		List<Enchere> encheres = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			Enchere enchere;
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_ENCHERE_ORDERED_BY_NOM_ARTICLE);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				enchere = new Enchere(rs.getTimestamp("date_enchere").toLocalDateTime(), rs.getInt("montant_enchere"));
				encheres.add(enchere);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encheres;
	}

}
