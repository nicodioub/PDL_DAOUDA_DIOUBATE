package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterfaceBail extends JFrame {
	
	private JPanel jlBackground;
	private JLabel jlColor;
	private JButton ajoutBien;
	private JButton Bien;
	private JButton Locataire;
	private JButton Bail;
	private JButton Bailleur;

	private Container container;

	private AddProperty window;
	
	private boolean addPropertyButton = false;


	public MainInterfaceBail(String title, int width, int height  ) {
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int buttonWidth = 100; // Largeur du JButton
        int buttonHeight = 30; // Hauteur du JButton
        
        

		jlBackground = new JPanel();
		this.setContentPane(jlBackground);
		Bien = new JButton("Bien");
		Locataire = new JButton("Locataire");
		ajoutBien = new JButton("+ Créer un bail ");
		Bail = new JButton("Bail");
		Bailleur = new JButton("Bailleur");
		container = this.getContentPane();
		
		String[] columnNames = {"id Bail ", "id Bailleur ","id Locataire","type"}; // a changer pour a
		
		Object[][] data = {
				
		};
		JTable table = new JTable(data, columnNames);
		
	    //table.setBackground(Color.BLACK); // Change to desired color

		
		JScrollPane scrollPane = new JScrollPane(table);
        
		 //scrollPane.getViewport().setBackground(Color.BLACK); // Change to desired color

	        
		container.setLayout(null); // Définir le layout sur null pour permettre le positionnement absolu
        
		scrollPane.setBounds(0, 100, 1400, 600); // Adjust bounds as needed
        ajoutBien.setBounds(1200, 50, 150, buttonHeight);
	    Bien.setBounds(500,50  , 100, 30);
	    Locataire.setBounds(600,50,100,30);
	    Bail.setBounds(700,50,100,30);
	    Bailleur.setBounds(800,50,100,30);
	    
        container.add(ajoutBien);
        container.add(Bien);
        container.add(Locataire);
        container.add(Bail);
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
		
		
		Bailleur.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			    	addPropertyButton = true;
			    	MainInterfaceBailleur Window10 = new MainInterfaceBailleur("Logiciel de gestion DD", 1400,800);
			    	Window10.setVisible(true);
			        dispose(); // Ferme l'interface 2
			    }
			
		});
		
		Bien.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			    	addPropertyButton = true;
			    	MainInterface Window1 = new MainInterface("Logiciel de gestion DD", 1400,800);
			    	Window1.setVisible(true);
			        dispose(); // Ferme l'interface 2
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
