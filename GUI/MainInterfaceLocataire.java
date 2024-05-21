package gui;
import  dao.*;
import javax.swing.*;
import java.awt.*;
import model.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainInterfaceLocataire extends JFrame {
	
	private JPanel jlBackground;
	private JLabel jlColor;
	private JButton ajoutLocataire;
	private JButton Bien;
	private JButton Locataire;
	private JButton Bail;
	private JButton ajoutGarant;
	private JButton Bailleur;


	private Container container;

	private AddProperty window;
	
	private boolean addPropertyButton = false;


	public MainInterfaceLocataire (String title, int width, int height  ) {
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int buttonWidth = 100; // Largeur du JButton
        int buttonHeight = 30; // Hauteur du JButton
        
        LocataireDAO locataireInfo = new LocataireDAO();

		jlBackground = new JPanel();
		this.setContentPane(jlBackground);
		Bien = new JButton("Bien");
		Bailleur = new JButton("Bailleur");
		Locataire = new JButton("Locataire");
		ajoutLocataire= new JButton("+ Ajouter un locataire");
		Bail = new JButton("Bail");
		ajoutGarant = new JButton("+ Ajout Garant");
		container = this.getContentPane();
		

		String[] columnNames = {"id", "Nom","Prénom","adresse","email"};
		
		List<Object[]> dataList = new ArrayList<>();

		for (int i = 1; i < locataireInfo.getMaxIdLocataire(); i++) {
		    dataList.add(new Object[] {
		        locataireInfo.getLocataireId(i),
		        locataireInfo.getLocataireNom(i),
		        locataireInfo.getLocatairePrenom(i),
		        locataireInfo.getLocataireAdresse(i),
		        locataireInfo.getLocataireEmail(i)
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
        
		scrollPane.setBounds(0, 100, 1400, 600); // Adjust bounds as needed
        ajoutLocataire.setBounds(1150, 50, 200, buttonHeight);
	    Bien.setBounds(500,50  , 100, 30);
	    Locataire.setBounds(600,50,100,30);
	    Bail.setBounds(700,50,100,30);
	    ajoutGarant.setBounds(950,50,200,buttonHeight);
	    Bailleur.setBounds(800,50,100,30);

	    
        container.add(ajoutLocataire);
        container.add(Bien);
        container.add(Locataire);
        container.add(Bail);
        container.add(ajoutGarant);
        container.add(Bailleur);
        container.add(scrollPane);
		jlBackground.setBackground(Color.BLACK);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		ajoutLocataire.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	addPropertyButton = true;
		    	AjoutLocataire Window5 = new AjoutLocataire("Logiciel de gestion DD", 1400,800);
		    	Window5.setVisible(true);
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
		
		ajoutGarant.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			    	addPropertyButton = true;
			    	AjoutGarant Window4 = new AjoutGarant("Logiciel de gestion DD", 1400,800);
			    	Window4.setVisible(true);
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
