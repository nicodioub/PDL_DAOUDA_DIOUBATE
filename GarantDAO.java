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
			ps.setInt(1, garant.getIdGarant());
			ps.setString(2, garant.getNom());
			ps.setString(3, garant.getPrenom());
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
			ps.setString(1, garant.getNom());
			ps.setString(2, garant.getPrenom());
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

	
	/**
	 * ATTENTION : Cette méthode n'a pas vocation à être executée lors d'une utilisation normale du programme !
	 * Elle existe uniquement pour TESTER les méthodes écrites au-dessus !
	 * 
	 * @param args non utilisés
	 * @throws SQLException si une erreur se produit lors de la communication avec la BDD
	 */
	public static void main(String[] args) throws SQLException {
		int returnValue;
		GarantDAO garantDAO = new GarantDAO();
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		int[] ids = {424242, 424243, 424244};
		// test du constructeur
		Garant s1 = new Garant(ids[0], "Ilyas", "Daouda", "Volta");
		Garant s2 = new Garant(ids[1], "Nicolas", "Dioubate", "Turing");
		Garant s3 = new Garant(ids[2], "Chloe", "Cabot", "Charliat");
		// test de la methode add
		returnValue = garantDAO.addGarant(s1);
		System.out.println(returnValue + " garant ajoute");
		returnValue = garantDAO.addGarant(s2);
		System.out.println(returnValue + " garant ajoute");
		returnValue = garantDAO.addGarant(s3);
		System.out.println(returnValue + " garant ajoute");
		System.out.println();
		
		// test de la methode get
		Garant sg = garantDAO.getGarant(1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		ArrayList<Garant> list = garantDAO.getList();
		for (Garant s : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(s.toString());
		}
		System.out.println();
		// test de la methode delete
		// On supprime les 3 garants qu'on a créé
		returnValue = 0;
		for (int id : ids) {
//			returnValue = garantDAO.deleteGarant(id);
			System.out.println(returnValue + " fournisseur supprime");
		}
		
		System.out.println();
	}
}