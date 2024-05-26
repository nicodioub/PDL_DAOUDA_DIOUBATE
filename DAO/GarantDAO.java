package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table GARANT
 * 
 * @author Ilyas DAOUDA + Nicolas DIOUBATE
 * @version 1.0
 * */
public class GarantDAO extends ConnectionDAO {
	/**
	 * Constructeur de la classe
	 * 
	 */
	public GarantDAO() {
		super();
	}
	
	/**
	 * Permet de récupérer l'id maximum et l'incrémente de 1
	 * 
	 * @return (l'Idmax + 1)
	 */
	public int getMaxIdGarant() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
        int maxId = 0;
        try {
            // Créer une connexion à la base de données et exécuter une requête pour obtenir le maximum de l'ID
            // Ici, vous devez utiliser votre logique spécifique pour accéder à la base de données
            // Par exemple, si vous utilisez JDBC :
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT MAX(idGarant) AS max_id FROM GARANT");
            if (rs.next()) {
                maxId = rs.getInt("max_id");
            }
            // Fermer les ressources
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			// fermeture du preparedStatement et de la connexion
        	try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
        return (maxId+1);
    }

	/**
	 * Permet d'ajouter un garant dans la table GARANT
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param garant le garant a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int addGarant(Garant garant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO GARANT(idGarant, nomGarant, prenomGarant, adresse) VALUES(?, ?, ?, ?)");
			ps.setInt(1, getMaxIdGarant());
			ps.setString(2, garant.getNomGarant());
			ps.setString(3, garant.getPrenomGarant());
			ps.setString(4, garant.getAdresse());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de garant existe déjà. Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try { 
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de modifier un garant dans la table GARANT
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param garant le garant a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int updateGarant(Garant garant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE GARANT set nomGarant = ?, prenomGarant = ?, adresse = ? WHERE idGarant = ?");
			ps.setString(1, garant.getNomGarant());
			ps.setString(2, garant.getPrenomGarant());
			ps.setString(3, garant.getAdresse());
			ps.setInt(4, garant.getIdGarant());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de supprimer un garant par idGarant dans la table GARANT
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param idGarant l'identifiant du garant à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int deleteGarant(int idGarant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'identifiant
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'identifiant du garant
			ps = con.prepareStatement("DELETE FROM GARANT WHERE idGarant = ?");
			ps.setInt(1, idGarant);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}


	/**
	 * Permet de recuperer un garant a partir de son identifiant
	 * 
	 * @param idGarant l'identifiant du fournisseur a recuperer
	 * @return le garant trouve; null si aucun garant ne correspond a cet identifiant
	 */
	public Garant getGarant(int idGarant) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Garant returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM GARANT WHERE idGarant = ?");
			ps.setInt(1, idGarant);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Garant(rs.getInt("idGarant"),
									       rs.getString("nomGarant"),
									       rs.getString("prenomGarant"),
									       rs.getString("adresse"));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de recuperer tous les garants stockes dans la table GARANT
	 * 
	 * @return une ArrayList de Garant
	 */
	public ArrayList<Garant> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Garant> returnValue = new ArrayList<Garant>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM GARANT ORDER BY idGarant");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Garant(rs.getInt("idGarant"),
						                     rs.getString("nomGarant"),
						                     rs.getString("prenomGarant"),
						                     rs.getString("adresse")));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
}
