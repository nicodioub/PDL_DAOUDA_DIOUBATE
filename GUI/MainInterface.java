package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends JFrame {
	
	private JPanel jlBackground;
	private JLabel jlColor;
	private JButton ajoutBien;
	private JButton Bien;

	private Container container;

	private AddProperty window;
	
	private boolean addPropertyButton = false;


	public MainInterface (String title, int width, int height  ) {
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int buttonWidth = 100; // Largeur du JButton
        int buttonHeight = 30; // Hauteur du JButton
        
        

		jlBackground = new JPanel();
		this.setContentPane(jlBackground);
		Bien = new JButton("Bien");
		ajoutBien = new JButton("+ Ajouter un bien");
		container = this.getContentPane();
		
		String[] columnNames = {"id", "type","Locataire","Bailleur","Adresse"};
		
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

	    
        container.add(ajoutBien);
        container.add(Bien);
        container.add(scrollPane);
		jlBackground.setBackground(Color.BLACK);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		ajoutBien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	addPropertyButton = true;
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
