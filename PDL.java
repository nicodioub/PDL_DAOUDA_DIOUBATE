import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EmployeDAO;
import dao.BienDAO;
import gui.Accueil;
import gui.AddProperty;
import gui.MainInterface;
import model.Employe;
import model.Bien;

/**
 * Programme principal
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */

public class PDL {
	
	public static void main(String[] args) throws SQLException {
		
		boolean authentified = false;
	    boolean windowClosed = false;
		EmployeDAO employeDAO = new EmployeDAO();
		BienDAO bienDAO = new BienDAO();
		Bien bien;
		ArrayList<Employe> listeEmployes = new ArrayList<Employe>();
	    listeEmployes = employeDAO.getList();
    	Accueil Window1 = new Accueil("Logiciel de gestion DD",1400,750);
    	Window1.setVisible(true);
    	boolean wasErrorDisplayed = false;
	    
		//Partie connexion de l'employe	    
	    while (authentified == false && !windowClosed) {
	    	
	    	// Attendre que l'utilisateur clique sur 'Connexion'
	    	while (Window1.isConnected() == false && !windowClosed) {
	    		try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	
	    	// Vérifier si la fenêtre a été fermée par l'utilisateur
	        if (!Window1.isVisible()) {
	            windowClosed = true;
	            break;
	        }
	    	
	    	// Recuperer les entrees de l'utilisateur
	    	String login = Window1.getLogin();
	    	String password = Window1.getPassword();
	    	
	    	// Réinitialiser les champs de texte
            // tWindow.cleanTextField();
	    	
	    	// Comparer les entrees aux donnees de la BDD
	    	for (int i=0; i<listeEmployes.size();i++) {
				if(listeEmployes.get(i).getNomUtilisateur().equals(login) && listeEmployes.get(i).getMotDePasse().equals(password)) {
					authentified = true;
					break;
				}
			}
	    	if (authentified == false && wasErrorDisplayed == false) {
	    		JOptionPane.showMessageDialog(null, "Login ou mot de passe incorrect. Veuillez reessayer !", "Erreur d'authentification", JOptionPane.ERROR_MESSAGE);
	    		wasErrorDisplayed = true;
	    	}
	    }
    	if(authentified && !windowClosed) {
    		JOptionPane.showMessageDialog(null, "Binvenue dans DynastyEight", "Authentification reussie", JOptionPane.INFORMATION_MESSAGE);
    		Window1.dispose();
    	}
    	
    	MainInterface Window2 = new MainInterface("Logiciel de gestion DD",1400,800);
    	Window2.setVisible(true);
    	
    	while (Window2.addPropertyClicked() == false) {
    		try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	AddProperty Window3 = new AddProperty("Logiciel de gestion DD",1400,800);		
    	Window3.setVisible(true);
    	
    	while (Window3.enregistrerClicked() == false) {
    		while (Window1.isConnected() == false && !windowClosed) {
    			
	    		try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    		
	    		bien = new Bien (4, Window3.getVille(), Integer.parseInt(Window3.getArrondissement()), Integer.parseInt(Window3.getNumRue()), 
	    				         Window3.getTypeVoie(), Window3.getNomRue(), Window3.getTypeBien(), 
	    				         Window3.getNomResidence(), Float.parseFloat(Window3.getSurfaceBien()), 
	    				         Integer.parseInt(Window3.getNombreChambres()), Window3.getDescriptionMeubles(), 
	    				         Window3.isMeuble(), Window3.aBalcon(), Window3.aTerrasse(), Float.parseFloat(Window3.getSurfaceTerrasse()), 
	    				         Float.parseFloat(Window3.getSurfaceBalcon()), Integer.parseInt(Window3.getAnneeConstruction()), 
	    				         Window3.getTypeChauffage(), Window3.isAppartement(), !Window3.isAppartement());
	    		bienDAO.addBien(bien);
	    	}
    	}
	}

}
