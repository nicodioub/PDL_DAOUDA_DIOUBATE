import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EmployeDAO;
import gui.Accueil;
import model.Employe;

/**
 * Programme principal
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */

public class PDL {
	
	public static void main(String[] args) throws SQLException {
		
		boolean authentified = false;
		EmployeDAO employeDAO = new EmployeDAO();
		ArrayList<Employe> listeEmployes = new ArrayList<Employe>();
	    listeEmployes = employeDAO.getList();
    	Accueil tWindow = new Accueil("Logiciel de gestion DD",1400,750);
    	tWindow.setVisible(true);
    	boolean wasErrorDisplayed = false;
	    
		//Partie connexion de l'employe	    
	    while (authentified == false) {
	    	
	    	// Attendre que l'utilisateur clique sur 'Connexion'
	    	while (tWindow.isConnected() == false) {
	    		try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	
	    	// Recuperer les entrees de l'utilisateur
	    	String login = tWindow.getLogin();
	    	String password = tWindow.getPassword();
	    	
	    	 // Réinitialiser les champs de texte
            tWindow.cleanTextField();
	    	
	    	// Comparer les entrees aux donnees de la BDD
	    	for (int i=0; i<listeEmployes.size();i++) {
				if(listeEmployes.get(i).getNomUtilisateur().equals(login) && listeEmployes.get(i).getMotDePasse().equals(password)) {
					authentified = true;
					break;
				}
			}
	    	if (authentified == false && wasErrorDisplayed == false) {
	    		JOptionPane.showMessageDialog(null, "Login ou mot de passe incorrect", "Erreur d'authentification", JOptionPane.ERROR_MESSAGE);
	    		wasErrorDisplayed = true;
	    	}
	    	
	    }
	   
		tWindow.dispose();
		
	}

}
