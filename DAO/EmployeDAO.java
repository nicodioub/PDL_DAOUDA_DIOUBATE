package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Employé
 * 
 * @author Ilyas DAOUDA + Nicolas DIOUBATE
 * @version 1.0
 * */
public class EmployeDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public EmployeDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un employe dans la table EMPLOYE
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param employe l'employe a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int addEmploye(Employe employe) {
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
			ps = con.prepareStatement("INSERT INTO EMPLOYE(idEmploye, login, password) VALUES(?, ?, ?)");
			ps.setInt(1, employe.getIdEmploye());
			ps.setString(2, employe.getNomUtilisateur());
			ps.setString(3, employe.getMotDePasse());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant d'employe existe déjà. Ajout impossible !");
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
	 * Permet de modifier un employe dans la table EMPLOYE
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param employe l'employe a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int updateEmploye(Employe employe) {
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
			ps = con.prepareStatement("UPDATE EMPLOYE set login = ?, password = ? WHERE idEmploye = ?");
			ps.setString(1, employe.getNomUtilisateur());
			ps.setString(2, employe.getMotDePasse());
			ps.setInt(3, employe.getIdEmploye());

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
	 * Permet de supprimer un employe par identifiant dans la table EMPLOYE
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param idEmploye l'identifiant de l'employe à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int deleteEmploye(int idEmploye) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID de l'employe
			ps = con.prepareStatement("DELETE FROM EMPLOYE WHERE idEmploye = ?");
			ps.setInt(1, idEmploye);

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
	 * Permet de recuperer un employe a partir de son identifiant
	 * 
	 * @param idEmploye l'identifiant de l'employe a recuperer
	 * @return l'employe trouve; null si aucun employe ne correspond a cette reference
	 */
	public Employe getEmploye(int idEmploye) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employe returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM EMPLOYE WHERE idEmploye = ?");
			ps.setInt(1, idEmploye);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Employe(rs.getInt("idEmploye"),
									       rs.getString("login"),
									       rs.getString("password"));
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
	 * Permet de recuperer tous les employes stockes dans la table EMPLOYE
	 * 
	 * @return une ArrayList de Employe
	 */
	public ArrayList<Employe> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Employe> returnValue = new ArrayList<Employe>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM EMPLOYE ORDER BY idEmploye");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Employe(rs.getInt("idEmploye"),
						                     rs.getString("login"),
						                     rs.getString("password")));
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
		EmployeDAO employeDAO = new EmployeDAO();
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		int[] ids = {1, 2, 3};
		// test du constructeur
		Employe s1 = new Employe(ids[0], "ilyas.daouda", "binome1");
		Employe s2 = new Employe(ids[1], "nicolas.dioubate", "binome2");
		Employe s3 = new Employe(ids[2], "chloe.cabot", "profpdl");
		// test de la methode add
		returnValue = employeDAO.addEmploye(s1);
		System.out.println(returnValue + " employe ajoute");
		returnValue = employeDAO.addEmploye(s2);
		System.out.println(returnValue + " employe ajoute");
		returnValue = employeDAO.addEmploye(s3);
		System.out.println(returnValue + " employe ajoute");
		System.out.println();
		
		// test de la methode get
		Employe sg = employeDAO.getEmploye(1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		ArrayList<Employe> list = employeDAO.getList();
		for (Employe s : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(s.toString());
		}
		System.out.println();
		// test de la methode delete
		// On supprime les 3 employes qu'on a créé
		returnValue = 0;
		for (int id : ids) {
//			returnValue = supplierDAO.delete(id);
			System.out.println(returnValue + " employe supprime");
		}
		
		System.out.println();
	}
}