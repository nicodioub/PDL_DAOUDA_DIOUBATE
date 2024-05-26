package dao;

/**
 * Classe d'acces a la base de donnees
 * 
 * @author Ilyas DAOUDA + Nicolas DIOUBATE
 * @version 1.0
 * */
public class ConnectionDAO {
	/**
	 * Parametres de connexion a la base de donnees oracle
	 * URL, LOGIN et PASS sont des constantes
	 */
	// À utiliser si vous êtes sur une machine personnelle :
	final static String URL   = "jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl";
	
	// À utiliser si vous êtes sur une machine de l'école :
	// final static String URL   = "jdbc:oracle:thin:@//srvoracledb.intranet.int:1521/orcl.intranet.int";
	

	final static String LOGIN = "C##BDD3_8";   
	final static String PASS  = "BDD38";   
	
	/**
	 * Constructor
	 * 
	 */
	public ConnectionDAO() {
		// chargement du pilote de bases de donnees
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
}
