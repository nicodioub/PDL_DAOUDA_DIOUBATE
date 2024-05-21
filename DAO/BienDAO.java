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
	 * Convertit true en 1 et false en 0
	 * 
	 * @param bool : un booléen
	 * @return 1 ou 0
	 */
	public int convertToBinary(boolean bool) {
		if (bool == true)
			return 1;
		else
			return 0;
	}
	
	/**
	 * Permet de récupérer l'id macimum et l'incrémente de 1
	 * 
	 * @return (l'Idmax + 1)
	 */
	public int getMaxIdBien() {
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
            rs = stmt.executeQuery("SELECT MAX(idBien) AS max_id FROM BIEN");
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
			ps = con.prepareStatement("INSERT INTO BIEN(idBien, typeBien, surfaceBien, codePostal, isMaisonIndividuelle, isAppartement, nombreChambre, anneeConstruction, arrondissement, ville, numAppartement, numEtage, numRue, typeRue, nomRue, nomResidence, isChauffageIndividuel, typeChauffage, isJardin, surfaceJardin, isMeuble, isTerrain, surfaceTerrain, isEscalier, isCave, isSousSol, isCour, surfaceCour, isBalcon, surfaceBalcon, isTerrasse, surfaceTerasse, descriptionMeuble) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, getMaxIdBien());
			ps.setString(2, bien.getType());
			ps.setFloat(3, bien.getSurface());
			ps.setInt(4, bien.getCodePostal());
			ps.setInt(5, convertToBinary(bien.isMaisonIndividuelle()));
			ps.setInt(6, convertToBinary(bien.isAppartement()));
			ps.setInt(7, bien.getNombreChambres());
			ps.setInt(8, bien.getAnneeConstruction());
			ps.setInt(9, bien.getArrondissement());
			ps.setString(10, bien.getVille());
			ps.setInt(11, bien.getNumAppartement());
			ps.setInt(12, bien.getEtage());
			ps.setInt(13, bien.getNumRue());
			ps.setString(14, bien.getTypeRue());
			ps.setString(15, bien.getNomRue());
			ps.setString(16, bien.getResidence());
			ps.setInt(17, convertToBinary(bien.aChauffageIndividuel()));
			ps.setString(18, bien.getTypeChauffage());	
			ps.setInt(19, convertToBinary(bien.aUnJardin()));
			ps.setFloat(20, bien.getSurfaceJardin());
			ps.setInt(21, convertToBinary(bien.isMeuble()));
			ps.setInt(22, convertToBinary(bien.aUnTerrain()));
			ps.setFloat(23, bien.getSurfaceTerrain());
			ps.setInt(24, convertToBinary(bien.aUnEscalier()));
			ps.setInt(25, convertToBinary(bien.aUneCave()));
			ps.setInt(26, convertToBinary(bien.aUnSousSol()));
			ps.setInt(27, convertToBinary(bien.aUneCour()));
			ps.setFloat(28, bien.getSurfaceCour());
			ps.setInt(29, convertToBinary(bien.aUnBalcon()));
			ps.setFloat(30, bien.getSurfaceBalcon());
			ps.setInt(31, convertToBinary(bien.aUneTerrasse()));
			ps.setFloat(32, bien.getSurfaceTerrasse());
			ps.setString(33, bien.getDescriptionMeubles());
			
			

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
			ps = con.prepareStatement("UPDATE BIEN set typeBien = ?, surfaceBien = ?, codePostal = ?, isMaisonIndividuelle = ?, isAppartement = ?, nombreChambre = ?, anneeConstruction = ?, arrondissement = ?, ville = ?, numAppartement = ?, numEtage = ?, numRue = ?, typeRue = ?, nomRue = ?, nomResidence = ?, isChauffageIndividuel = ?, typeChauffage = ?, isJardin = ?, surfaceJardin = ?, isMeuble = ?, isTerrain = ?, surfaceTerrain = ?, isEscalier = ?, isCave = ?, isSousSol = ?, isCour = ?, surfaceCour = ?, isBalcon = ?, surfaceBalcon = ?, isTerrasse = ?, surfaceTerrasse = ?, descriptionMeuble = ? WHERE id = ?");
			ps.setString(1, bien.getType());
			ps.setFloat(2, bien.getSurface());
			ps.setInt(3, bien.getCodePostal());
			ps.setBoolean(4, bien.isMaisonIndividuelle());
			ps.setBoolean(5, bien.isAppartement());
			ps.setInt(6, bien.getNombreChambres());
			ps.setInt(7, bien.getAnneeConstruction());
			ps.setInt(8, bien.getArrondissement());
			ps.setString(9, bien.getVille());
			ps.setInt(10, bien.getNumAppartement());
			ps.setInt(11, bien.getEtage());
			ps.setInt(12, bien.getNumRue());
			ps.setString(13, bien.getTypeRue());
			ps.setString(14, bien.getNomRue());
			ps.setString(15, bien.getResidence());
			ps.setBoolean(16, bien.aChauffageIndividuel());
			ps.setString(17, bien.getTypeChauffage());	
			ps.setBoolean(18, bien.aUnJardin());
			ps.setFloat(19, bien.getSurfaceJardin());
			ps.setBoolean(20, bien.isMeuble());
			ps.setBoolean(21, bien.aUnTerrain());
			ps.setFloat(22, bien.getSurfaceTerrain());
			ps.setBoolean(23, bien.aUnEscalier());
			ps.setBoolean(24, bien.aUneCave());
			ps.setBoolean(25, bien.aUnSousSol());
			ps.setBoolean(26, bien.aUneCour());
			ps.setFloat(27, bien.getSurfaceCour());
			ps.setBoolean(28, bien.aUnBalcon());
			ps.setFloat(29, bien.getSurfaceBalcon());
			ps.setBoolean(30, bien.aUneTerrasse());
			ps.setFloat(31, bien.getSurfaceTerrasse());
			ps.setString(32, bien.getDescriptionMeubles());
			ps.setInt(33, bien.getIdBien());

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

	public int updateComponent(Bien bien) {
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
			ps = con.prepareStatement("UPDATE BIEN set typeBien = ?, surfaceBien = ?, codePostal = ?, isMaisonIndividuelle = ?, isAppartement = ?, nombreChambre = ?, anneeConstruction = ?, arrondissement = ?, ville = ?, numAppartement = ?, numEtage = ?, numRue = ?, typeRue = ?, nomRue = ?, nomResidence = ?, isChauffageIndividuel = ?, typeChauffage = ?, isJardin = ?, surfaceJardin = ?, isMeuble = ?, isTerrain = ?, surfaceTerrain = ?, isEscalier = ?, isCave = ?, isSousSol = ?, isCour = ?, surfaceCour = ?, isBalcon = ?, surfaceBalcon = ?, isTerrasse = ?, surfaceTerrasse = ?, descriptionMeuble = ? WHERE id = ?");
			ps.setString(1, bien.getType());
			ps.setFloat(2, bien.getSurface());
			ps.setInt(3, bien.getCodePostal());
			ps.setBoolean(4, bien.isMaisonIndividuelle());
			ps.setBoolean(5, bien.isAppartement());
			ps.setInt(6, bien.getNombreChambres());
			ps.setInt(7, bien.getAnneeConstruction());
			ps.setInt(8, bien.getArrondissement());
			ps.setString(9, bien.getVille());
			ps.setInt(10, bien.getNumAppartement());
			ps.setInt(11, bien.getEtage());
			ps.setInt(12, bien.getNumRue());
			ps.setString(13, bien.getTypeRue());
			ps.setString(14, bien.getNomRue());
			ps.setString(15, bien.getResidence());
			ps.setBoolean(16, bien.aChauffageIndividuel());
			ps.setString(17, bien.getTypeChauffage());	
			ps.setBoolean(18, bien.aUnJardin());
			ps.setFloat(19, bien.getSurfaceJardin());
			ps.setBoolean(20, bien.isMeuble());
			ps.setBoolean(21, bien.aUnTerrain());
			ps.setFloat(22, bien.getSurfaceTerrain());
			ps.setBoolean(23, bien.aUnEscalier());
			ps.setBoolean(24, bien.aUneCave());
			ps.setBoolean(25, bien.aUnSousSol());
			ps.setBoolean(26, bien.aUneCour());
			ps.setFloat(27, bien.getSurfaceCour());
			ps.setBoolean(28, bien.aUnBalcon());
			ps.setFloat(29, bien.getSurfaceBalcon());
			ps.setBoolean(30, bien.aUneTerrasse());
			ps.setFloat(31, bien.getSurfaceTerrasse());
			ps.setString(32, bien.getDescriptionMeubles());
			ps.setInt(33, bien.getIdBien());

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
	
	public int updateTypeDeBien(int idLocataire, String nouveauTypeDeBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET typeBien = ? WHERE idLocataire = ?");
	        ps.setString(1, nouveauTypeDeBien);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	
	public int updateSurface(int idLocataire, int nouvelleSurface) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Bien SET surfaceBien = ? WHERE idBien = ?");
	        ps.setInt(1, nouvelleSurface);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateCodePostal(int idLocataire, int newValueInt) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET CodePostal = ? WHERE idLocataire = ?");
	        ps.setInt(1, newValueInt);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateNumEtage(int idLocataire, int newValueInt) {

	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET numEtage = ? WHERE idLocataire = ?");
	        ps.setInt(1, newValueInt);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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
	
	
	public int updateNumRue(int idLocataire, int newValueInt) {

		
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET numRUe = ? WHERE idLocataire = ?");
	        ps.setInt(1, newValueInt);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateTypeRue(int idLocataire, String nouveauTypeRue) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET typeRue = ? WHERE idLocataire = ?");
	        ps.setString(1, nouveauTypeRue);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateNomRue(int idLocataire, String nomRue) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET nomRue = ? WHERE idLocataire = ?");
	        ps.setString(1, nomRue);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateNomResidence(int idLocataire, String newNomResidence) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET nomResidence = ? WHERE idLocataire = ?");
	        ps.setString(1, newNomResidence);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateTypeChauffage(int idLocataire, String typeChauffage) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET typeChauffage = ? WHERE idLocataire = ?");
	        ps.setString(1, typeChauffage);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateSurfaceJardin(int idLocataire, int nouveauTypeDeBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET surfaceJardin = ? WHERE idLocataire = ?");
	        ps.setInt(1, nouveauTypeDeBien);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	
	public int updatesurfaceTerrain(int idLocataire, int newValueInt) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET surfaceTerrain = ? WHERE idLocataire = ?");
	        ps.setInt(1, newValueInt);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateSurfaceCour(int idLocataire, int newValueInt) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET surfaceCour = ? WHERE idLocataire = ?");
	        ps.setInt(1, newValueInt);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	
	public int updateSurfaceBalcon(int idLocataire, int newValueInt) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET surfaceBalcon = ? WHERE idLocataire = ?");
	        ps.setInt(1, newValueInt);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	
	public int updateSurfaceTerasse(int idLocataire, int newValueInt) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET surfaceTerasse = ? WHERE idLocataire = ?");
	        ps.setInt(1, newValueInt);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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

	public int updateDescriptionMeuble(int idLocataire, String nouveauTypeDeBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int returnValue = 0;

	    // connexion à la base de données
	    try {
	        // tentative de connexion
	        con = DriverManager.getConnection(URL, LOGIN, PASS);

	        // préparation de l'instruction SQL
	        ps = con.prepareStatement("UPDATE Locataire SET descriptionMeuble = ? WHERE idLocataire = ?");
	        ps.setString(1, nouveauTypeDeBien);
	        ps.setInt(2, idLocataire);

	        // exécution de la requête
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
				returnValue = new Bien(rs.getInt("idBien"), rs.getString("typeBien"), 
									   rs.getFloat("surfaceBien"), rs.getInt("codePostal"),
									   rs.getBoolean("isMaisonIndividuelle"), rs.getBoolean("isAppartement"),
									   rs.getInt("nombreChambre"), rs.getInt("anneeConstruction"),
									   rs.getInt("arrondissement"), rs.getString("ville"),
									   rs.getInt("numAppartement"), rs.getInt("numEtage"),
									   rs.getInt("numRue"), rs.getString("typeRue"),
									   rs.getString("nomRue"), rs.getString("nomResidence"),
									   rs.getBoolean("isChauffageIndividuel"), rs.getString("typeChauffage"),
							           rs.getBoolean("isJardin"), rs.getFloat("surfaceJardin"),
								   	   rs.getBoolean("isMeuble"), rs.getBoolean("isTerrain"),
									   rs.getFloat("surfaceTerrain"), rs.getBoolean("isEscalier"),
									   rs.getBoolean("isCave"), rs.getBoolean("isSousSol"),
									   rs.getBoolean("isCour"), rs.getFloat("surfaceCour"),
									   rs.getBoolean("isBalcon"), rs.getFloat("surfaceBalcon"),
									   rs.getBoolean("isTerrasse"), rs.getFloat("surfaceTerrasse"),
									   rs.getString("descriptionMeuble"));
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

	public String[] getBienPartiel(int idBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String[] returnValue = new String[2]; // Pour stocker id et type

	    // Connexion à la base de données
	    try {
	        con = DriverManager.getConnection(URL, LOGIN, PASS);
	        ps = con.prepareStatement("SELECT idBien, typeBien, surfaceBien, adresse, ville FROM BIEN WHERE idBien = ?");
	        ps.setInt(1, idBien);

	        // Exécution de la requête
	        rs = ps.executeQuery();
	        
	        // Si une ligne est retournée
	        if (rs.next()) {
	            returnValue[0] = rs.getString("idBien"); // Récupération de id
	            returnValue[1] = rs.getString("typeBien"); // Récupération de type
	            returnValue[2] = rs.getString("surfaceBien"); // Récupération de type
	            returnValue[3] = rs.getString("adresse"); // Récupération de type
	            returnValue[4] = rs.getString("ville"); // Récupération de type


	        }
	    } catch (Exception ee) {
	        ee.printStackTrace();
	    } finally {
	        // Fermeture des ressources
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
	
	public String getBienId(int idBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String returnValue = null; // Pour stocker l'ID

	    try {
	        con = DriverManager.getConnection(URL, LOGIN, PASS);
	        ps = con.prepareStatement("SELECT idBien FROM BIEN WHERE idBien = ?");
	        ps.setInt(1, idBien);

	        // Exécution de la requête
	        rs = ps.executeQuery();
	        
	        // Si une ligne est retournée
	        if (rs.next()) {
	            returnValue = rs.getString("idBien"); // Récupération de l'ID
	        }
	    } catch (Exception ee) {
	        ee.printStackTrace();
	    } finally {
	        // Fermeture des ressources
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
	
	public String getBienType(int idBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String returnValue = null; // Pour stocker l'ID

	    try {
	        con = DriverManager.getConnection(URL, LOGIN, PASS);
	        ps = con.prepareStatement("SELECT typeBien FROM BIEN WHERE idBien = ?");
	        ps.setInt(1, idBien);

	        // Exécution de la requête
	        rs = ps.executeQuery();
	        
	        // Si une ligne est retournée
	        if (rs.next()) {
	            returnValue = rs.getString("typeBien"); // Récupération de l'ID
	        }
	    } catch (Exception ee) {
	        ee.printStackTrace();
	    } finally {
	        // Fermeture des ressources
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

	
	public String getBienSurface(int idBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String returnValue = null; // Pour stocker l'ID

	    try {
	        con = DriverManager.getConnection(URL, LOGIN, PASS);
	        ps = con.prepareStatement("SELECT surfaceBien FROM BIEN WHERE idBien = ?");
	        ps.setInt(1, idBien);

	        // Exécution de la requête
	        rs = ps.executeQuery();
	        
	        // Si une ligne est retournée
	        if (rs.next()) {
	            returnValue = rs.getString("surfaceBien"); // Récupération de l'ID
	        }
	    } catch (Exception ee) {
	        ee.printStackTrace();
	    } finally {
	        // Fermeture des ressources
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
	
	public String getBienAdresse(int idBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String returnValue = null; // Pour stocker l'ID

	    try {
	        con = DriverManager.getConnection(URL, LOGIN, PASS);
	        ps = con.prepareStatement("SELECT numRue, typeRue, nomRue FROM BIEN WHERE idBien = ?");
	        ps.setInt(1, idBien);

	        // Exécution de la requête
	        rs = ps.executeQuery();
	        
	        // Si une ligne est retournée
	        if (rs.next()) {
	        	 returnValue = rs.getString("numRue") + " " + rs.getString("typeRue") + " " + rs.getString("nomRue"); }
	    } catch (Exception ee) {
	        ee.printStackTrace();
	    } finally {
	        // Fermeture des ressources
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
	
	public String getBienVille(int idBien) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String returnValue = null; // Pour stocker l'ID

	    try {
	        con = DriverManager.getConnection(URL, LOGIN, PASS);
	        ps = con.prepareStatement("SELECT ville FROM BIEN WHERE idBien = ?");
	        ps.setInt(1, idBien);

	        // Exécution de la requête
	        rs = ps.executeQuery();
	        
	        // Si une ligne est retournée
	        if (rs.next()) {
	            returnValue = rs.getString("ville"); // Récupération de l'ID
	        }
	    } catch (Exception ee) {
	        ee.printStackTrace();
	    } finally {
	        // Fermeture des ressources
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
				returnValue.add(new Bien(rs.getInt("idBien"), rs.getString("typeBien"), 
										 rs.getFloat("surfaceBien"), rs.getInt("codePostal"),
										 rs.getBoolean("isMaisonIndividuelle"), rs.getBoolean("isAppartement"),
										 rs.getInt("nombreChambre"), rs.getInt("anneeConstruction"),
										 rs.getInt("arrondissement"), rs.getString("ville"),
										 rs.getInt("numAppartement"), rs.getInt("numEtage"),
										 rs.getInt("numRue"), rs.getString("typeRue"),
										 rs.getString("nomRue"), rs.getString("nomResidence"),
										 rs.getBoolean("isChauffageIndividuel"), rs.getString("typeChauffage"),
							             rs.getBoolean("isJardin"), rs.getFloat("surfaceJardin"),
										 rs.getBoolean("isMeuble"), rs.getBoolean("isTerrain"),
										 rs.getFloat("surfaceTerrain"), rs.getBoolean("isEscalier"),
										 rs.getBoolean("isCave"), rs.getBoolean("isSousSol"),
										 rs.getBoolean("isCour"), rs.getFloat("surfaceCour"),
										 rs.getBoolean("isBalcon"), rs.getFloat("surfaceBalcon"),
										 rs.getBoolean("isTerrasse"), rs.getFloat("surfaceTerrasse"),
										 rs.getString("descriptionMeuble")));
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
	/*
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
	*/
}
