package dao;

import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table BIEN
 * 
 * @author Ilyas DAOUDA + Nicolas DIOUBATE
 * @version 2.0
 */
public class BienDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public BienDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un bien dans la table BIEN 
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param bien le bien a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int addBien(Bien bien) {
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
			ps = con.prepareStatement("INSERT INTO BIEN(idBien, typeBien, nombreChambre, anneeConstruction, arrondissement, ville, numAppartement, numEtage, numRue, typeRue, nomRue, nomResidence, isChauffageIndividuel, typeChauffage, isMaisonIndividuelle, isAppartement) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, bien.getIdBien());
			ps.setString(2, bien.getType());
			ps.setInt(3, bien.getNombreChambres());
			ps.setInt(4, bien.getAnneeConstruction());
			ps.setInt(5, bien.getArrondissement());
			ps.setString(6, bien.getVille());
			ps.setInt(7, bien.getNumAppartement());
			ps.setInt(8, bien.getEtage());
			ps.setInt(9, bien.getNumRue());
			ps.setString(10, bien.getTypeRue());
			ps.setString(11, bien.getNomRue());
			ps.setString(12, bien.getResidence());
			ps.setBoolean(13, bien.aChauffageIndividuel());
			ps.setString(14, bien.getTypeChauffage());
			ps.setBoolean(15, bien.isMaisonIndividuelle());
			ps.setBoolean(16, bien.isAppartement());
			ps.close();
			ps = con.prepareStatement("INSERT INTO BIEN(isJardin, isMeuble, isTerrain, surfaceTerrain, isEscalier, isCave, isSousSol, isCour, surfaceCour, isBalcon, surfaceJardin, isTerrasse, surfaceTerrasse, descriptionMeuble, surfaceBalcon, surfaceBien) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setBoolean(1, bien.aUnJardin());
			ps.setBoolean(2, bien.isMeuble());
			ps.setBoolean(3, bien.aUnTerrain());
			ps.setFloat(4, bien.getSurfaceTerrain());
			ps.setBoolean(5, bien.aUnEscalier());
			ps.setBoolean(6, bien.aUneCave());
			ps.setBoolean(7, bien.aUnSousSol());
			ps.setBoolean(8, bien.aUneCour());
			ps.setFloat(9, bien.getSurfaceCour());
			ps.setBoolean(10, bien.aUnBalcon());
			ps.setFloat(11, bien.getSurfaceJardin());
			ps.setBoolean(12, bien.aUneTerrasse());
			ps.setFloat(13, bien.getSurfaceTerrasse());
			ps.setString(14, bien.getDescriptionMeubles());
			ps.setFloat(15, bien.getSurfaceBalcon());
			ps.setFloat(16, bien.getSurface());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de bien existe déjà. Ajout impossible !");
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
	 * Permet de modifier un bien dans la table BIEN
	 *  Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param bien le bien a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int updateBien(Bien bien) {
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
			ps = con.prepareStatement("UPDATE BIEN set typeBien = ?, nombreChambre = ?, anneeConstruction = ?, arrondissement = ?, ville = ?, numAppartement = ?, numEtage = ?, numRue = ?, typeRue = ?, nomRue = ?, nomResidence = ?, isChauffageIndividuel = ?, typeChauffage = ?, isJardin = ?, isMaisonIndividuelle = ?, isAppartement = ? WHERE id = ?");
			ps.setString(1, bien.getType());
			ps.setInt(2, bien.getNombreChambres());
			ps.setInt(3, bien.getAnneeConstruction());
			ps.setInt(4, bien.getArrondissement());
			ps.setString(5, bien.getVille());
			ps.setInt(6, bien.getNumAppartement());
			ps.setInt(7, bien.getEtage());
			ps.setInt(8, bien.getNumRue());
			ps.setString(9, bien.getTypeRue());
			ps.setString(10, bien.getNomRue());
			ps.setString(11, bien.getResidence());
			ps.setBoolean(12, bien.aChauffageIndividuel());
			ps.setString(13, bien.getTypeChauffage());
			ps.setBoolean(14, bien.aUnJardin());
			ps.setBoolean(15, bien.isMaisonIndividuelle());
			ps.setBoolean(16, bien.isAppartement());
			ps.setInt(17, bien.getIdBien());
			ps.close();
			ps = con.prepareStatement("UPDATE BIEN set surfaceJardin = ?, isMeuble = ?, isTerrain = ?, surfaceTerrain = ?, isEscalier = ?, isCave = ?, isSousSol = ?, isCour = ?, surfaceCour = ?, isBalcon = ?, surfaceBalcon = ?, isTerrasse = ?, surfaceTerrasse = ?, descriptionMeuble = ?, surfaceBien = ? WHERE idBien = ?");
			ps.setFloat(1, bien.getSurfaceJardin());
			ps.setBoolean(2, bien.isMeuble());
			ps.setBoolean(3, bien.aUnTerrain());
			ps.setFloat(4, bien.getSurfaceTerrain());
			ps.setBoolean(5, bien.aUnEscalier());
			ps.setBoolean(6, bien.aUneCave());
			ps.setBoolean(7, bien.aUnSousSol());
			ps.setBoolean(8, bien.aUneCour());
			ps.setFloat(9, bien.getSurfaceCour());
			ps.setBoolean(10, bien.aUnBalcon());
			ps.setFloat(11, bien.getSurfaceBalcon());
			ps.setBoolean(12, bien.aUneTerrasse());
			ps.setFloat(13, bien.getSurfaceTerrasse());
			ps.setString(14, bien.getDescriptionMeubles());
			ps.setFloat(15, bien.getSurface());
			ps.setInt(16, bien.getIdBien());

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
	 * Permet de supprimer un bien par identifiant dans la table BIEN.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param idBien l'identifiant du bien à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int deleteBien(int idBien) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du bien
			ps = con.prepareStatement("DELETE FROM BIEN WHERE idBien = ?");
			ps.setInt(1, idBien);

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
	 * Permet de recuperer un bien a partir de sa reference
	 * 
	 * @param idBien l'identifiant du bien a recuperer
	 * @return le bien trouve; null si aucun bien ne correspond a cet identifiant
	 */
	public Bien getBien(int idBien) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bien returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM BIEN WHERE idBien = ?");
			ps.setInt(1, idBien);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Bien(rs.getInt("idBien"),
											rs.getString("ville"), 
											rs.getInt("arrondissement"),
											rs.getInt("numRue"),
											rs.getString("typeRue"),
											rs.getString("nomRue"),
											rs.getString("typeBien"),
											rs.getString("nomResidence"),
											rs.getFloat("surfaceBien"),
											rs.getInt("nombreChambre"),
											rs.getString("descriptionMeuble"),
											rs.getBoolean("isMeuble"),
											rs.getBoolean("isBalcon"),
											rs.getBoolean("isTerrasse"),
											rs.getFloat("surfaceTerrasse"),
											rs.getFloat("surfaceBalcon"),
											rs.getInt("anneeConstruction"),
											rs.getString("typeChauffage"),
											rs.getBoolean("isAppartement"),
											rs.getBoolean("isMaisonIndividuelle"));
				returnValue.setAppartement(rs.getBoolean("isEscalier"), rs.getBoolean("isChauffageIndividuel"),
						                   rs.getInt("numEtage"), rs.getInt("numAppartement"));
				returnValue.setMaisonIndividuelle(rs.getBoolean("isCave"), rs.getBoolean("isSousSol"), 
						                          rs.getBoolean("isCour"), rs.getBoolean("isJardin"), 
						                          rs.getBoolean("isTerrain"), rs.getFloat("surfaceCour"), 
						                          rs.getFloat("surfaceJardin"), rs.getFloat("surfaceTerrain"));
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
	 * Permet de recuperer tous les biens stockes dans la table BIEN
	 * 
	 * @return une ArrayList de Bien
	 */
	public ArrayList<Bien> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Bien> returnValue = new ArrayList<Bien>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM BIEN ORDER BY idBien");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Bien(rs.getInt("idBien"), rs.getString("ville"), 
										 rs.getInt("arrondissement"), rs.getInt("numRue"),
										 rs.getString("typeRue"), rs.getString("nomRue"),
										 rs.getString("typeBien"), rs.getString("nomResidence"),
										 rs.getFloat("surfaceBien"), rs.getInt("nombreChambre"),
										 rs.getString("descriptionMeuble"), rs.getBoolean("isMeuble"),
										 rs.getBoolean("isBalcon"), rs.getBoolean("isTerrasse"),
										 rs.getFloat("surfaceTerrasse"), rs.getFloat("surfaceBalcon"),
							             rs.getInt("anneeConstruction"), rs.getString("typeChauffage"),
										 rs.getBoolean("isAppartement"), rs.getBoolean("isMaisonIndividuelle")));
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
	 * ATTENTION : Cette méthode n'a pas vocation à être executée lors d'une
	 * utilisation normale du programme ! Elle existe uniquement pour TESTER les
	 * méthodes écrites au-dessus !
	 * 
	 * @param args non utilisés
	 * @throws SQLException si une erreur se produit lors de la communication avec
	 *                      la BDD
	 */
	public static void main(String[] args) throws SQLException {
		int returnValue;
		SupplierDAO supplierDAO = new SupplierDAO();
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions
		// avec vos données en prenant de grands ID
		int[] ids = { 424242, 424243, 424244 };
		// test du constructeur
		Supplier s1 = new Supplier(ids[0], "Mon fournisseur principal", "Rouen", "monfournisseurprincipal@mail.com");
		Supplier s2 = new Supplier(ids[1], "Mon fournisseur secondaire", "Le Havre",
				"monfournisseursecondaire@mail.com");
		Supplier s3 = new Supplier(ids[2], "Mon fournisseur de secours", "Paris", "monfournisseursecours@mail.com");
		// test de la methode add
		returnValue = supplierDAO.add(s1);
		System.out.println(returnValue + " fournisseur ajoute");
		returnValue = supplierDAO.add(s2);
		System.out.println(returnValue + " fournisseur ajoute");
		returnValue = supplierDAO.add(s3);
		System.out.println(returnValue + " fournisseur ajoute");
		System.out.println();

		// test de la methode get
		Supplier sg = supplierDAO.get(1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(sg);
		System.out.println();

		// test de la methode getList
		ArrayList<Supplier> list = supplierDAO.getList();
		for (Supplier s : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(s.toString());
		}
		System.out.println();
		// test de la methode delete
		// On supprime les 3 biens qu'on a créé
		returnValue = 0;
		for (int id : ids) {
//			returnValue = supplierDAO.delete(id);
			System.out.println(returnValue + " fournisseur supprime");
		}

		System.out.println();
	}
}