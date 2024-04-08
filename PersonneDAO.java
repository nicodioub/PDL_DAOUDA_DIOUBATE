package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table personne
 * 
 * @author Ilyas DAOUDA + Nicolas DIOUBATE
 * @version 1.0
 **/
public class PersonneDAO extends ConnectionDAO{
	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public PersonneDAO() {
		super();
	}
	
	/**
	 * Permet d'ajouter une personne dans la table personne
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param personne : la personne a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Personne personne) {
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
			ps = con.prepareStatement("INSERT INTO supplier(nom, prenom, email, numero) VALUES(?, ?, ?, ?)");
			ps.setString(1, personne.getNom());
			ps.setString(2, personne.getPrenom());
			ps.setString(3, personne.getEmail());
			ps.setString(4, personne.getNumero());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe déjà. Ajout impossible !");
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
	 * Permet de modifier une personne dans la table personne.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param personne : la personne a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Personne personne) {
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
			ps = con.prepareStatement("UPDATE supplier set name = ?, address = ?, email = ? WHERE id = ?");
			ps.setString(1, supplier.getName());
			ps.setString(2, supplier.getAddress());
			ps.setString(3, supplier.getEmail());
			ps.setInt(4, supplier.getId());

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

}
