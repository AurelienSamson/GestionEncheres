package fr.formation.gestionencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.formation.gestionencheres.bll.BllException;
import fr.formation.gestionencheres.bo.Retrait;

public class RetraitDAOImpl implements RetraitDAO {
	private final String SQL_INSERT_RETRAIT = "INSERT INTO RETRAITS VALUES (?, ?, ?, ?);";
	private final String SQL_UPDATE_RETRAIT = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?;";
	private final String SQL_DELETE_RETRAITS = "DELETE FROM RETRAITS WHERE no_article = ?;";
	private final String SQL_SELECT_RETRAIT = "SELECT * FROM RETRAITS;";
	private final String SQL_SELECT_RETRAIT_ID = "SELECT * FROM RETRAITS WHERE no_article = ?;";

	private int idRetrait = 1;

	@Override
	public void insertRetrait(Retrait retrait) {
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
	public void updateRetrait(Retrait retrait, Integer id) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_UPDATE_RETRAIT);
			stm.setString(1, retrait.getRue());
			stm.setString(2, retrait.getCode_postal());
			stm.setString(3, retrait.getVille());
			stm.setInt(4, id);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteRetrait(Integer id) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_DELETE_RETRAITS);
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Retrait selectRetraitByNoArticle(Integer noArticle) {
		Retrait retrait = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_RETRAIT_ID);
			stm.setInt(1, noArticle);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				retrait = new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retrait;
	}

	@Override
	public List<Retrait> selectAllRetraits() {
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

}
