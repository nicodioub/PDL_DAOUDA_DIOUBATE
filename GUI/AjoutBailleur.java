package gui;

import javax.swing.*;
import dao.*;
import model.*;
import java.awt.*;
import java.awt.event.*;

public class AjoutBailleur extends JFrame {
	
	private JPanel jlBackground;
    private JButton enregistrer;
    private boolean enregistrerButton = false;
	private Container container;
	
		
    // Zone de texte pour le nom du Bailleur
    private JTextField nomBailleur = new JTextField("Nom du Bailleur");
    
    // Zone de texte pour le prénom du Bailleur
    private JTextField prenomBailleur = new JTextField("Prénom du Bailleur");
    
    // Zone de texte pour l'adresse du Bailleur
    private JTextField adresse = new JTextField("Adresse du Bailleur");
    
    // Zone de texte pour le mail du Bailleur
    private JTextField emailBailleur = new JTextField("Email du Bailleur");
    
    // Zone de texte pour le numéro du Bailleur
    private JTextField numeroBailleur = new JTextField("Numéro du Bailleur");
    
    // Zone de texte pour l'id du Bien associé au Bailleur
    private JTextField idBien = new JTextField("Id du bien");
    
    

	public AjoutBailleur (String title, int width, int height  ) {
			
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	       
	    jlBackground = new JPanel();
		this.setContentPane(jlBackground);
		enregistrer = new JButton("Enregistrer");
		container = this.getContentPane();
		container.setLayout(null); // Définir le layout sur null pour permettre le positionnement absolu
			
		
	    nomBailleur.setBounds(100,90,150,30);
	    prenomBailleur.setBounds(100,130,150,30);
	    adresse.setBounds(100,170,150,30);
	    emailBailleur.setBounds(100,210,150,30);
	    numeroBailleur.setBounds(100,250,150,30);
	    idBien.setBounds(100,410,150,30);
	
	    enregistrer.setBounds(300, 650, 150, 30);
	      
	    
	    // Ajout d'un écouteur de focus au champ de texte du nom du Bailleur
	    nomBailleur.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            // Efface le texte indicatif lorsque le champ de texte obtient le focus
	            if (nomBailleur.getText().equals("Nom du Bailleur")) {
	            	nomBailleur.setText("");
	            }
	        }
	
	        @Override
	        public void focusLost(FocusEvent e) {
	            // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	            if (nomBailleur.getText().isEmpty()) {
	            	nomBailleur.setText("Nom du Bailleur");
	            }
	        }
	    });
	    
	    // Ajout d'un écouteur de focus au champ de texte du prénom du Bailleur
	    prenomBailleur.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            // Efface le texte indicatif lorsque le champ de texte obtient le focus
	            if (prenomBailleur.getText().equals("Prénom du Bailleur")) {
	            	prenomBailleur.setText("");
	            }
	        }
	
	        @Override
	        public void focusLost(FocusEvent e) {
	            // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	            if (prenomBailleur.getText().isEmpty()) {
	            	prenomBailleur.setText("Prénom du Bailleur");
	            }
	        }
	    });
	    
	    // Ajout d'un écouteur de focus au champ de texte du numéro du Bailleur
	    numeroBailleur.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            // Efface le texte indicatif lorsque le champ de texte obtient le focus
	            if (numeroBailleur.getText().equals("Numéro du Bailleur")) {
	            	numeroBailleur.setText("");
	            }
	        }
	
	        @Override
	        public void focusLost(FocusEvent e) {
	            // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	            if (numeroBailleur.getText().isEmpty()) {
	            	numeroBailleur.setText("Numéro du Bailleur");
	            }
	        }
	    });
	    
	    // Ajout d'un écouteur de focus au champ de texte de l'adresse du Bailleur
	    adresse.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            // Efface le texte indicatif lorsque le champ de texte obtient le focus
	            if (adresse.getText().equals("Adresse du Bailleur")) {
	            	adresse.setText("");
	            }
	        }
	
	        @Override
	        public void focusLost(FocusEvent e) {
	            // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	            if (adresse.getText().isEmpty()) {
	            	adresse.setText("Adresse du Bailleur");
	            }
	        }
	    });
	    
	    // Ajout d'un écouteur de focus au champ de texte de l'email du Bailleur
	    emailBailleur.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            // Efface le texte indicatif lorsque le champ de texte obtient le focus
	            if (emailBailleur.getText().equals("Email du Bailleur")) {
	            	emailBailleur.setText("");
	            }
	        }
	
	        @Override
	        public void focusLost(FocusEvent e) {
	            // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	            if (emailBailleur.getText().isEmpty()) {
	            	emailBailleur.setText("Email du Bailleur");
	            }
	        }
	    });
	    
	    // Ajout d'un écouteur de focus au champ de texte de l'id du bien
	    idBien.addFocusListener(new FocusListener() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            // Efface le texte indicatif lorsque le champ de texte obtient le focus
	            if (idBien.getText().equals("Id du bien")) {
	            	idBien.setText("");
	            }
	        }
	
	        @Override
	        public void focusLost(FocusEvent e) {
	            // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	            if (idBien.getText().isEmpty()) {
	            	idBien.setText("Id du bien");
	            }
	        }
	    });
	
	       
	    container.add(nomBailleur);
	    container.add(prenomBailleur);
	    container.add(adresse);
	    container.add(emailBailleur);
	    container.add(numeroBailleur);
	    container.add(idBien);
	    container.add(enregistrer);
	    jlBackground.setBackground(Color.BLACK);
			
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);		
			
			
		enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enregistrerButton = true;

		    	int test = 1; //Variable qui vérifie que tous les champs sont remplis
		    	
		    	if (nomBailleur.getText().equals("Nom du Bailleur")) {
		    		JOptionPane.showMessageDialog(null, "Vous n'avez pas rempli le champ 'Nom du Bailleur' !", "Erreur de remplissage", JOptionPane.ERROR_MESSAGE);
		    		test = 0;
		    	}
		    	else if (prenomBailleur.getText().equals("Prénom du Bailleur")) {
		    		JOptionPane.showMessageDialog(null, "Vous n'avez pas rempli le champ 'Prénom du Bailleur' !", "Erreur de remplissage", JOptionPane.ERROR_MESSAGE);
		    		test = 0;
		    	}
		    	else if (adresse.getText().equals("Adresse du Bailleur")) {
		    		JOptionPane.showMessageDialog(null, "Vous n'avez pas rempli le champ 'Adresse du Bailleur' !", "Erreur de remplissage", JOptionPane.ERROR_MESSAGE);
		    		test = 0;
		    	}
		    	else if (emailBailleur.getText().equals("Email du Bailleur")) {
		    		JOptionPane.showMessageDialog(null, "Vous n'avez pas rempli le champ 'Email du Bailleur' !", "Erreur de remplissage", JOptionPane.ERROR_MESSAGE);
		    		test = 0;
		    	}
		    	else if (numeroBailleur.getText().equals("Numéro du Bailleur")) {
		    		JOptionPane.showMessageDialog(null, "Vous n'avez pas rempli le champ 'Numéro du Bailleur' !", "Erreur de remplissage", JOptionPane.ERROR_MESSAGE);
		    		test = 0;
		    	}
		    	else if (idBien.getText().equals("Id du bien")) {
		    		JOptionPane.showMessageDialog(null, "Vous n'avez pas rempli le champ 'Id du bien' !", "Erreur de remplissage", JOptionPane.ERROR_MESSAGE);
		    		test = 0;
		    	}
	    	
		    	if (test == 1) {
		    	Bailleur Bailleur = new Bailleur(0, defaultText(nomBailleur.getText()),
		    										defaultText(prenomBailleur.getText()), 
		    										defaultText(adresse.getText()), 
		    										defaultText(emailBailleur.getText()),
		    										defaultText(numeroBailleur.getText()),
		    										convertTextToInt(idBien.getText(), "Id du bien"));	    	
		    	BailleurDAO BailleurDAO = new BailleurDAO();			    	
				BailleurDAO.addBailleur(Bailleur);
				JOptionPane.showMessageDialog(null, "Le Bailleur a été correctement ajouté à la base de données !", "Message de confirmation", JOptionPane.INFORMATION_MESSAGE);
		    	}
			}
		});
	}

	public boolean enregistrerClicked() {
		return enregistrerButton;
	}
	
	/**
	 * Permet de recuperer le nom du Bailleur
	 */
	public String getNomBailleur() {
		return nomBailleur.getText();
	}
	
	/**
	 * Permet de recuperer le prénom du Bailleur
	 */
	public String getPrenomBailleur() {
		return prenomBailleur.getText();
	}
	
	/**
	 * Permet de recuperer le numero du Bailleur
	 */
	public String getNumeroBailleur() {
		return numeroBailleur.getText();
	}
	
	/**
	 * Permet de recuperer l'email du Bailleur
	 */
	public String getEmailBailleur() {
		return emailBailleur.getText();
	}
	
	/**
	 * Permet de recuperer l'adresse du Bailleur
	 */
	public String getAdresse() {
		return adresse.getText();
	}
	
	/**
	 * Permet de recuperer l'id du bien
	 */
	public String getIdBien() {
		return idBien.getText();
	}
	
	/**
	 * Permet de convertir des entiers de String à int
	 * 
	 * @param text : un entier en String
	 * 
	 * @return sa valeur en int
	 */
	public int convertTextToInt(String text, String text1) {
		if (text.equals(text1))
			return 0;
		else
			return Integer.parseInt(text);
	}
	
	/**
	 * Permet d'afficher un texte par défaut si certains champs ne sont pas remplis
	 * 
	 * @param text : un entier en String
	 * 
	 * @return le texte par défaut
	 */
	public String defaultText(String text) {
		if (text == null || text.equals(""))
			text = "Non renseigné";
		return text;
	}

}
