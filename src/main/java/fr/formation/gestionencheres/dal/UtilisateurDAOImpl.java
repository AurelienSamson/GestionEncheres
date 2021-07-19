package fr.formation.gestionencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.formation.gestionencheres.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	private final String SQL_INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final String SQL_UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?;";
	private final String SQL_UPDATE_UTILISATEURS_CREDIT = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur = ?;";
	private final String SQL_DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;";
	private final String SQL_SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS;";
	private final String SQL_SELECT_UTILISATEUR_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	private final String SQL_SELECT_UTILISATEUR_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?;";
	private final String SQL_CHECK_PSEUDO_AND_MAIL_ALREADY_EXIST = "SELECT * FROM UTILISATEUR WHERE pseudo LIKE ? OR email LIKE ?;";
	private final String SQL_CHECK_PSEUDO_ALREADY_EXIST = "SELECT * FROM UTILISATEUR WHERE pseudo LIKE ?;";
	private final String SQL_CHECK_MAIL_ALREADY_EXIST = "SELECT * FROM UTILISATEUR WHERE email LIKE ?;";
	private final String SQL_SELECT_NO_ARTICLE_AND_PSEUDO = "SELECT no_article, u.pseudo FROM ARTICLES_VENDUS av INNER JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur WHERE etat_vente = 'EC';";
	
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
	public void updateUtilisateur(Utilisateur user) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_UPDATE_UTILISATEUR);
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
			stm.setInt(12, user.getNoUtilisateur());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCredit(Integer noUtilisateur, Integer newCredit) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_UPDATE_UTILISATEURS_CREDIT);
			stm.setInt(1, newCredit);
			stm.setInt(2, noUtilisateur);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUtilisateur(Utilisateur user) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_DELETE_UTILISATEUR);
			stm.setInt(1, user.getNoUtilisateur());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur selectUtilisateurByPseudo(String pseudo) {
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
	public List<Utilisateur> selectAllUtilisateur() {
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
	public Utilisateur selectUtilisateurByNoUtilisateur(Integer noUtilisateur) {
		Utilisateur utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_UTILISATEUR_ID);
			stm.setInt(1, noUtilisateur);
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
	public boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DALException {
		boolean isUnique = true;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_CHECK_PSEUDO_AND_MAIL_ALREADY_EXIST);
			stm.setString(1, pseudo);
			stm.setString(2, pseudo);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			if (rs.next()) {
				isUnique = false;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			dalException.addError(DalErrorCodes.SQL_SELECT_ERROR);
			throw dalException;
		}
		return isUnique;

	}

	@Override
	public boolean checkForUniquePseudo(String pseudo) throws DALException {
		boolean isUnique = true;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_CHECK_PSEUDO_ALREADY_EXIST);
			stm.setString(1, pseudo);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			if (rs.next()) {
				isUnique = false;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			dalException.addError(DalErrorCodes.SQL_SELECT_ERROR);
			throw dalException;
		}
		return isUnique;
	}

	@Override
	public boolean checkForUniqueMail(String mail) throws DALException {
		boolean isUnique = true;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_CHECK_MAIL_ALREADY_EXIST);
			stm.setString(1, mail);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			if (rs.next()) {
				isUnique = false;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			dalException.addError(DalErrorCodes.SQL_SELECT_ERROR);
			throw dalException;
		}
		return isUnique;
	}

	@Override
	public HashMap<Integer, String> selectNoArticlePseudoUtilisateurWithCurrentEnchere() throws DALException {
		HashMap<Integer, String> articlesEnEnchere = new HashMap<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stm = connection.prepareStatement(SQL_SELECT_NO_ARTICLE_AND_PSEUDO);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				articlesEnEnchere.put(rs.getInt(1), rs.getString(2));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
