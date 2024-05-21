package gui;
import dao.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends JFrame {
	
	private JPanel jlBackground;
	private JLabel jlColor;
	private JButton ajoutBien;
	private JButton Bien;
	private JButton Locataire;
	private JButton Bail;
	private JButton modifier;
	private JButton Bailleur;
	private JButton supprimer;


	private Container container;

	private AddProperty window;
	
	private boolean addPropertyButton = false;


	public MainInterface (String title, int width, int height  ) {
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int buttonWidth = 100; // Largeur du JButton
        int buttonHeight = 30; // Hauteur du JButton
        
        BienDAO bienInfo = new BienDAO();

		jlBackground = new JPanel();
		this.setContentPane(jlBackground);
		Bien = new JButton("Bien");
		Locataire = new JButton("Locataire");
		modifier = new JButton("Modifier");
        JFrame frame = new JFrame("Supprimer une valeur de la base de données");

		supprimer = new JButton("Supprimer");

		ajoutBien = new JButton("+ Ajouter un bien");
		Bail = new JButton("Bail");
		container = this.getContentPane();
		Bailleur = new JButton("Bailleur");


		
		String[] columnNames = {"id", "type","surface","adresse","ville"};
		
		List<Object[]> dataList = new ArrayList<>();

		for (int i = 1; i < bienInfo.getMaxIdBien(); i++) {
		    dataList.add(new Object[] {
		        bienInfo.getBienId(i),
		        bienInfo.getBienType(i),
		        bienInfo.getBienSurface(i),
		        bienInfo.getBienAdresse(i),
		        bienInfo.getBienVille(i)
		    });
		}

		// Convertir la liste en un tableau à deux dimensions
		Object[][] data = new Object[dataList.size()][];
		for (int i = 0; i < dataList.size(); i++) {
		    data[i] = dataList.get(i);
		}
		
		
			
			

		JTable table = new JTable(data, columnNames);
		
	    //table.setBackground(Color.BLACK); // Change to desired color

		
		JScrollPane scrollPane = new JScrollPane(table);
        
		 //scrollPane.getViewport().setBackground(Color.BLACK); // Change to desired color

	        
		container.setLayout(null); // Définir le layout sur null pour permettre le positionnement absolu
        
		scrollPane.setBounds(10, 100, 1390, 600); // Adjust bounds as needed
        ajoutBien.setBounds(1200, 50, 150, buttonHeight);
	    Bien.setBounds(500,50  , 100, 30);
	    Locataire.setBounds(600,50,100,30);
	    Bail.setBounds(700,50,100,30);
	    modifier.setBounds(50,650,100,30);
	    supprimer.setBounds(200,650,100,30);
	    Bailleur.setBounds(800,50,100,30);
        frame.setSize(300, 200);


	    
        container.add(ajoutBien);
        container.add(Bien);
        container.add(Locataire);
        container.add(Bail);
        container.add(modifier);
        container.add(supprimer);
        container.add(Bailleur);

       


        container.add(scrollPane);
		jlBackground.setBackground(Color.BLACK);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		ajoutBien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	addPropertyButton = true;
		    	AddProperty Window3 = new AddProperty("Logiciel de gestion DD",1400,800);		
		        dispose(); // Ferme l'interface 2
		        
		        
		        
		    }
		});
		
		Locataire.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			    	addPropertyButton = true;
			    	MainInterfaceLocataire Window6 = new MainInterfaceLocataire("Logiciel de gestion DD", 1400,800);
			    	Window6.setVisible(true);
			        dispose(); // Ferme l'interface 2
			    }
			
		});
		
		Bail.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			    	addPropertyButton = true;
			    	MainInterfaceBail Window7 = new MainInterfaceBail("Logiciel de gestion DD", 1400,800);
			    	Window7.setVisible(true);
			        dispose(); // Ferme l'interface 2
			    }
			
		});
		
		
		Bailleur.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			    	addPropertyButton = true;
			    	MainInterfaceBailleur Window10 = new MainInterfaceBailleur("Logiciel de gestion DD", 1400,800);
			    	Window10.setVisible(true);
			        dispose(); // Ferme l'interface 2
			    }
			
		});
		supprimer.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			    	addPropertyButton = true;
			    	// Afficher une boîte de dialogue pour entrer l'ID de la valeur à supprimer
	                String id = JOptionPane.showInputDialog(frame, "Entrez l'ID de la valeur à supprimer:");

	                // Vérifier si l'utilisateur a entré quelque chose
	                if (id != null && !id.isEmpty()) {
	                    // Supprimer la valeur de la base de données (action factice ici)
	                    // Remplacez cette étape par la suppression réelle de la valeur dans votre base de données
	                    // Exemple : database.deleteValue(id);

	                    // Afficher un message indiquant que la valeur a été supprimée avec succès
	                	int idInt = Integer.parseInt(id);
	                	JOptionPane.showMessageDialog(frame, "La valeur avec l'ID " + id + " a été supprimée de votre base de données.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
	                	bienInfo.deleteBien(idInt);
	                	MainInterface Window1 = new MainInterface("Logiciel de gestion DD", 1400,800);
				    	Window1.setVisible(true);
				        dispose(); // Ferme l'interface 2
	                } else {
	                    // Afficher un message si l'utilisateur a annulé l'entrée ou n'a rien entré
	                    JOptionPane.showMessageDialog(frame, "Suppression annulée.", "Information", JOptionPane.INFORMATION_MESSAGE);
	                }
			    	
			    }
			
		});
		
		

        
       
		
		modifier.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			    	addPropertyButton = true;
			    	 // Afficher une boîte de dialogue pour entrer l'ID de la valeur à modifier
	                String id = JOptionPane.showInputDialog(null, "Quelle bien voulez-vous modifier ?\nSaisissez son ID :");

	                // Vérifier si l'utilisateur a entré quelque chose
	                if (id != null && !id.isEmpty()) {
	                    int idInt = Integer.parseInt(id);
	                    
	                    String typeDeBien = "Type de bien";
	                    String surface = "Surface";
	                    String codePostal = "Code postal";
	                    String numeroEtage = "Numéro d'étage";
	                    String numeroRue = "Numéro de rue";
	                    String typeRue = "Type de rue";
	                    String nomRue = "Nom de rue";
	                    String nomResidence = "Nom de résidence";
	                    String typeChauffage = "Type de chauffage";
	                    String surfaceJardin = "Surface de jardin";
	                    String surfaceTerrain = "Surface de terrain";
	                    String surfaceCour = "Surface de cour";
	                    String surfaceBalcon = "Surface de balcon";
	                    String surfaceTerrasse = "Surface de terrasse";
	                    String descriptionMeuble = "Description meuble";


	                    // Afficher un menu avec des boutons radio pour choisir quel composant modifier
	                    String[] components = {
	                    	    
	                    	    surface,
	                    	    codePostal,
	                    	    numeroEtage,
	                    	    numeroRue,
	                    	    typeRue,
	                    	    nomRue,
	                    	    nomResidence,
	                    	    typeChauffage,
	                    	    surfaceJardin,
	                    	    surfaceTerrain,
	                    	    surfaceCour,
	                    	    surfaceBalcon,
	                    	    surfaceTerrasse,
	                    	    descriptionMeuble
	                    	};
	                    
	                    String component = (String) JOptionPane.showInputDialog(null, "Choisissez le composant à modifier :", 
	                        "Modifier Composant", JOptionPane.QUESTION_MESSAGE, null, components, components[0]);

	                    if (component != null && !component.isEmpty()) {
	                        // Afficher une boîte de dialogue pour entrer la nouvelle valeur
	                        String newValue = JOptionPane.showInputDialog(null, "Entrez la nouvelle valeur pour " + component + " :");
	                        int newValueInt = Integer.parseInt(newValue);
	                        // Vérifier si l'utilisateur a entré quelque chose
	                        if (newValue != null && !newValue.isEmpty()) {
	                        	
	                        	
	                        	    if (component.equals(typeDeBien)) {
	                        	        bienInfo.updateTypeDeBien(idInt, newValue);
	                        	    } else if (component.equals(surface)) {
	                        	        bienInfo.updateSurface(idInt, newValueInt);
	                        	    } else if (component.equals(codePostal)) {
	                        	        bienInfo.updateCodePostal(idInt, newValueInt);
	                        	    } else if (component.equals(numeroEtage)) {
	                        	        bienInfo.updateNumEtage(idInt, newValueInt);
	                        	    } else if (component.equals(numeroRue)) {
	                        	        bienInfo.updateNumRue(idInt, newValueInt);
	                        	    } else if (component.equals(typeRue)) {
	                        	        bienInfo.updateTypeRue(idInt, newValue);
	                        	    } else if (component.equals(nomRue)) {
	                        	        bienInfo.updateNomRue(idInt, newValue);
	                        	    } else if (component.equals(nomResidence)) {
	                        	        bienInfo.updateNomResidence(idInt, newValue);
	                        	    } else if (component.equals(typeChauffage)) {
	                        	        bienInfo.updateTypeChauffage(idInt, newValue);
	                        	    } else if (component.equals(surfaceJardin)) {
	                        	        bienInfo.updateSurfaceJardin(idInt, newValueInt);
	                        	    } else if (component.equals(surfaceTerrain)) {
	                        	        bienInfo.updatesurfaceTerrain(idInt, newValueInt);
	                        	    } else if (component.equals(surfaceCour)) {
	                        	        bienInfo.updateSurfaceCour(idInt, newValueInt);
	                        	    } else if (component.equals(surfaceBalcon)) {
	                        	        bienInfo.updateSurfaceBalcon(idInt, newValueInt);
	                        	    } else if (component.equals(surfaceTerrasse)) {
	                        	        bienInfo.updateSurfaceTerasse(idInt, newValueInt);
	                        	    } else if (component.equals(descriptionMeuble)) {
	                        	        bienInfo.updateDescriptionMeuble(idInt, newValue);
	                        	    }
	                        	
	                            // Modifier la valeur de la base de données (action factice ici)
	                            // Remplacez cette étape par la modification réelle de la valeur dans votre base de données
	                            // Exemple : database.updateValue(idInt, component, newValue);

	                            // Afficher un message indiquant que la valeur a été modifiée avec succès
	                            JOptionPane.showMessageDialog(null, "La valeur de " + component + " pour le bien avec l'ID " + id + 
	                                " a été modifiée en " + newValue + ".", "Modification réussie", JOptionPane.INFORMATION_MESSAGE);

	                            // Appel à la méthode de modification de votre objet bienInfo
	                           // bienInfo.updateBien(null)

	                            // Actualiser l'interface principale
	                            MainInterface window1 = new MainInterface("Logiciel de gestion DD", 1400, 800);
	                            window1.setVisible(true);
	                            dispose(); // Ferme l'interface actuelle
	                        } else {
	                            // Afficher un message si l'utilisateur a annulé l'entrée ou n'a rien entré
	                            JOptionPane.showMessageDialog(null, "Modification annulée.", "Information", JOptionPane.INFORMATION_MESSAGE);
	                        }
	                    } else {
	                        // Afficher un message si l'utilisateur a annulé la sélection du composant
	                        JOptionPane.showMessageDialog(null, "Modification annulée.", "Information", JOptionPane.INFORMATION_MESSAGE);
	                    }
	                } else {
	                    // Afficher un message si l'utilisateur a annulé l'entrée ou n'a rien entré
	                    JOptionPane.showMessageDialog(null, "Modification annulée.", "Information", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }
		});
		}
	
	
	/**
	 * Permet de verifier si l'utilisateur a clique sur 'Ajouter bail'
	 * 
	 * @return l'attribut addPropertyButton
	 */
	public boolean addPropertyClicked() {
		return addPropertyButton;
	}
	
	

}
