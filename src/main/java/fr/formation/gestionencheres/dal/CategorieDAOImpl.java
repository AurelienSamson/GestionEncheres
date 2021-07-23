package fr.formation.gestionencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.bo.ArticleEnVente;
import fr.formation.gestionencheres.bo.Categorie;

public class CategorieDAOImpl implements CategorieDAO {
	private final String SQL_INSERT_CATEGORIE = "INSERT INTO CATEGORIES VALUES (?);";
	private final String SQL_SELECT_CATEGORIE = "SELECT * FROM CATEGORIES;";
	private final String SQL_SELECT_CATEGORIE_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?;";
	private final String SQL_SELECT_CATEGORIE_LIBELLE = "SELECT * FROM CATEGORIES WHERE libelle = ?;";

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
	public Categorie selectCategorieByNoCategorie(Integer noCategorie) {
		Categorie categorie = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_CATEGORIE_ID);
			stm.setInt(1, noCategorie);
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
	public Categorie selectCategorieByLibelle(String libelle) {
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
	public List<Categorie> selectAllCategories() {
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
	public List<ArticleEnVente> getArticleEnVenteFromCategorie(Categorie categorie) {
		// TODO Mettre une HashMap?
		return null;
	}

}
