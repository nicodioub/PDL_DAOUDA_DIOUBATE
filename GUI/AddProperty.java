package gui;

import javax.swing.*;
import dao.*;
import model.*;
import java.awt.*;
import java.awt.event.*;

public class AddProperty extends JFrame {
	
	private JPanel jlBackground;
	private JButton enregistrer;
	private Container container;
	
	private boolean enregistrerButton = false;
	
	private String typeBienChoisi;
	private String typeChauffageChoisi;
	private String choixMeubleOuNon;
	private String choixCaveOuNon;
	private String choixBalconOuNon;
	private String choixTerrasseOuNon;
	private String choixSousSolOuNon;
	private String choixCourOuNon;
	private String choixJardinOuNon;
	private String choixTerrainOuNon;
	private String choixEscalierOuNon;
	private String typeVoieChoisi;
	private String choixAppartOuMaison;
	private String choixChauffageIndividuelOuNon;
	
	//
	// Création du menu de types de bien
	String[] typesChauffage = {"Type de chauffage", "Chauffage électrique", "Chaudière", "Poêle", "Chauffage au bois", "Pompe à chaleur", "Radiateur à eau chaude", "Plancher chauffant à eau chaude", "Plancher/plafond rayonnant", "Système de régulation et de programmation"};
    private JComboBox<String> menuTypesChauffage = new JComboBox<>(typesChauffage);
    
    // Création du menu de types de chauffage
 	String[] typesBien = {"Type de bien", "Studio", "T1", "T2", "T3", "T4", "T5", "Duplex", "Triplex", "Souplex", "Loft"};
    private JComboBox<String> menuTypesBien = new JComboBox<>(typesBien);
    
    // Création du menu pour indiquer si le bien est meuble ou pas
  	String[] choixMenuMeuble = {"Indicateur meublé ou non", "Oui", "Non"};
    private JComboBox<String> menuMeuble = new JComboBox<>(choixMenuMeuble);
    
    // Création du menu pour indiquer si le bien a une cave ou pas
   	String[] choixMenuCave = {"Présence de cave", "Oui", "Non"};
    private JComboBox<String> menuCave = new JComboBox<>(choixMenuCave);
    
    // Création du menu pour indiquer si le bien a un sous-sol ou pas
   	String[] choixMenuSousSol = {"Présence de sous-sol", "Oui", "Non"};
    private JComboBox<String> menuSousSol = new JComboBox<>(choixMenuSousSol);
    
    // Création du menu pour indiquer si le bien a une cour ou pas
   	String[] choixMenuCour = {"Présence de cour", "Oui", "Non"};
    private JComboBox<String> menuCour = new JComboBox<>(choixMenuCour);
    
    // Création du menu pour indiquer si le bien a un jardin ou pas
   	String[] choixMenuJardin = {"Présence de jardin", "Oui", "Non"};
    private JComboBox<String> menuJardin = new JComboBox<>(choixMenuJardin);
    
    // Création du menu pour indiquer si le bien a un terrain ou pas
   	String[] choixMenuTerrain = {"Présence de terrain", "Oui", "Non"};
    private JComboBox<String> menuTerrain = new JComboBox<>(choixMenuTerrain);
    
    // Création du menu pour indiquer si le bien a un escalier ou pas
   	String[] choixMenuEscalier = {"Présence d'escalier", "Oui", "Non"};
    private JComboBox<String> menuEscalier = new JComboBox<>(choixMenuEscalier);
    
    // Création du menu pour indiquer si le bien a un escalier ou pas
   	String[] choixMenuBalcon = {"Présence de balcon", "Oui", "Non"};
    private JComboBox<String> menuBalcon = new JComboBox<>(choixMenuBalcon);
    
    // Création du menu pour indiquer si le bien a un escalier ou pas
   	String[] choixMenuTerrasse = {"Présence de terrasse", "Oui", "Non"};
    private JComboBox<String> menuTerrasse = new JComboBox<>(choixMenuTerrasse);
    
    // Création du menu de types de voie
  	String[] typesVoie = {"Type de voie", "Allée", "Avenue", "Boulevard", "Chemin", "Impasse", "Route", "Rue", "Ruelle"};
    private JComboBox<String> menuTypesVoie = new JComboBox<>(typesVoie);
    
    // Création du menu de choix appartement/maison individuelle
   	String[] choixMenuAppartOuMaison = {"Appartement/Maison individuelle", "Appartement", "Maison individuelle"};
    private JComboBox<String> menuAppartOuMaison = new JComboBox<>(choixMenuAppartOuMaison);

    // Création du menu de choix chauffage individuel
   	String[] choixChauffageIndividuel = {"Chauffage Individuel", "Oui", "Non"};
    private JComboBox<String> menuChauffageIndividuel = new JComboBox<>(choixChauffageIndividuel);
    
    
    
    // Zone de texte pour la surface du bien 
    private JTextField surfaceBien = new JTextField("Surface du bien");
    
    // Zone de texte pour la surface de la cour du bien 
    private JTextField surfaceCour = new JTextField("Surface de la cour");
    
    // Zone de texte pour la surface du jardin du bien 
    private JTextField surfaceJardin = new JTextField("Surface du jardin");
    
    // Zone de texte pour la surface du terrain du bien 
    private JTextField surfaceTerrain = new JTextField("Surface du terrain");
    
    // Zone de texte pour la surface balcon 
    private JTextField surfaceBalcon= new JTextField("Surface du balcon");
    
    // Zone de texte pour la surface de la terrasse 
    private JTextField surfaceTerrasse = new JTextField("Surface de la terrasse");
    
    // Zone de texte pour l'annee de construction
    private JTextField anneeConstruction = new JTextField("Année de construction");
    
    // Zone de texte pour le nombre de chambres 
    private JTextField nombreChambres = new JTextField("Nombre de chambres");
    
    // Zone de texte pour la ville 
    private JTextField ville = new JTextField("Ville");
    
    // Zone de texte pour l'arrondissement 
    private JTextField arrondissement = new JTextField("Arrondissement");
    
    // Zone de texte pour le nom de la rue
    private JTextField nomRue = new JTextField("Nom de la rue");
    
    // Zone de texte pour le nom de la residence
    private JTextField nomResidence = new JTextField("Nom de la résidence");
    
    // Zone de texte pour la description des meubles
    private JTextField descriptionMeubles = new JTextField("Description des meubles");
    
    // Zone de texte pour le numero d'étage
    private JTextField numEtage = new JTextField("Numéro d'étage");
    
    // Zone de texte pour le numero d'appartement
    private JTextField numAppartement = new JTextField("Numéro d'appartement");
    
    // Zone de texte pour le numero de rue
    private JTextField numRue = new JTextField("Numéro de la rue");
    
    // Zone de texte pour le code postal
    private JTextField codePostal = new JTextField("Code postal");;  
    

	public AddProperty (String title, int width, int height) {
			
			this.setTitle(title);
			this.setSize(width, height);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
			
			jlBackground = new JPanel();
			this.setContentPane(jlBackground);
			enregistrer = new JButton("Enregistrer");
			container = this.getContentPane();			
			container.setLayout(null); // Définir le layout sur null pour permettre le positionnement absolu
			
	        menuAppartOuMaison.setBounds(100,50,275,30);
	        menuTypesBien.setBounds(100,90,275,30);
	        surfaceBien.setBounds(100,130,275,30);
	        nomResidence.setBounds(100,170,275,30);
	        nombreChambres.setBounds(100,210,275,30);
	        arrondissement.setBounds(100,250,275,30);
	        codePostal.setBounds(100,290,275,30);
	        ville.setBounds(100,330,275,30);
	        numRue.setBounds(100,370,275,30);	        
	        menuTypesVoie.setBounds(100,410,275,30);
	        nomRue.setBounds(100,450,275,30);
	        menuTypesChauffage.setBounds(100,490,275,30);
	        menuTerrasse.setBounds(100,530,275,30);
	        surfaceTerrasse.setBounds(100,570,275,30);
	        menuBalcon.setBounds(100,610,275,30);
	        surfaceBalcon.setBounds(100,650,275,30);
	        
	        menuMeuble.setBounds(400,50,275,30);
	        descriptionMeubles.setBounds(400,90,275,30);
	        anneeConstruction.setBounds(400,130,275,30);	        
	        numAppartement.setBounds(400,170,275,30);
	        numEtage.setBounds(400,210,275,30);
	        menuEscalier.setBounds(400,250,275,30);
	        menuChauffageIndividuel.setBounds(400,290,275,30);
	        menuCave.setBounds(400,330,275,30);
	        menuSousSol.setBounds(400,370,275,30);
	        menuCour.setBounds(400,410,275,30);
	        surfaceCour.setBounds(400,450,275,30);
	        menuJardin.setBounds(400,490,275,30);
	        surfaceJardin.setBounds(400,530,275,30);
	        menuTerrain.setBounds(400,570,275,30);
	        surfaceTerrain.setBounds(400,610,275,30);
	        
	        enregistrer.setBounds(100, 690, 275, 30);
	        
	        // Définir un rendu personnalisé pour le choix chauffage individuel ou non
	        menuChauffageIndividuel.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                choixChauffageIndividuelOuNon = (String) value;
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuChauffageIndividuel.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	            	choixChauffageIndividuelOuNon = (String) menuChauffageIndividuel.getSelectedItem();
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour le type de bien
	        menuTypesBien.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                String choixTypeBien = (String) value;
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuTypesBien.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                typeBienChoisi = (String) menuTypesBien.getSelectedItem();
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour le type de chauffage
	        menuTypesChauffage.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuTypesChauffage.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                typeChauffageChoisi = (String) menuTypesChauffage.getSelectedItem();
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur meuble
	        menuMeuble.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuMeuble.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixMeubleOuNon = (String) menuMeuble.getSelectedItem();
	                
	                // Activer ou désactiver le champ de texte en fonction de la sélection dans le menu déroulant
	                if (choixMeubleOuNon.equals("Oui")) {
	                    descriptionMeubles.setEnabled(true);
	                } else {
	                	descriptionMeubles.setEnabled(false);
	                }
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur cave
	        menuCave.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuCave.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixCaveOuNon = (String) menuCave.getSelectedItem();
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur balcon
	        menuBalcon.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuBalcon.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixBalconOuNon = (String) menuBalcon.getSelectedItem();
	                
	                // Activer ou désactiver le champ de texte en fonction de la sélection dans le menu déroulant
	                if (choixBalconOuNon.equals("Oui")) {
	                    surfaceBalcon.setEnabled(true);
	                } else {
	                	surfaceBalcon.setEnabled(false);
	                }
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur terrasse
	        menuTerrasse.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuTerrasse.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixTerrasseOuNon = (String) menuTerrasse.getSelectedItem();
	                
	                // Activer ou désactiver le champ de texte en fonction de la sélection dans le menu déroulant
	                if (choixTerrasseOuNon.equals("Oui")) {
	                    surfaceTerrasse.setEnabled(true);
	                } else {
	                	surfaceTerrasse.setEnabled(false);
	                }
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur sous-sol
	        menuSousSol.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuSousSol.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixSousSolOuNon = (String) menuSousSol.getSelectedItem();
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur cour
	        menuCour.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuCour.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixCourOuNon = (String) menuCour.getSelectedItem();
	                
	                // Activer ou désactiver le champ de texte en fonction de la sélection dans le menu déroulant
	                if (choixCourOuNon.equals("Oui")) {
	                    surfaceCour.setEnabled(true);
	                } else {
	                	surfaceCour.setEnabled(false);
	                }
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur jardin
	        menuJardin.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuJardin.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixJardinOuNon = (String) menuJardin.getSelectedItem();
	                
	                // Activer ou désactiver le champ de texte en fonction de la sélection dans le menu déroulant
	                if (choixJardinOuNon.equals("Oui")) {
	                    surfaceJardin.setEnabled(true);
	                } else {
	                	surfaceJardin.setEnabled(false);
	                }
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur terrain
	        menuTerrain.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuTerrain.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixTerrainOuNon = (String) menuTerrain.getSelectedItem();
	                
	                // Activer ou désactiver le champ de texte en fonction de la sélection dans le menu déroulant
	                if (choixTerrainOuNon.equals("Oui")) {
	                    surfaceTerrain.setEnabled(true);
	                } else {
	                	surfaceTerrain.setEnabled(false);
	                }
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour l'indicateur escalier
	        menuEscalier.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuEscalier.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixEscalierOuNon = (String) menuEscalier.getSelectedItem();
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant pour le type de voie
	        menuTypesVoie.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuTypesVoie.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                typeVoieChoisi = (String) menuTypesVoie.getSelectedItem();
	            }
	        });
	        
	        // Définir un rendu personnalisé pour le menu déroulant poir le choix appartement/maison
	        menuAppartOuMaison.setRenderer(new DefaultListCellRenderer() {
	            @Override
	            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	                
	                // Afficher le texte d'information en gras et en gris
	                if (index == 0) {
	                    label.setFont(label.getFont().deriveFont(Font.BOLD));
	                    label.setForeground(Color.GRAY);
	                }
	                
	                return label;
	            }
	        });
	
	        // Ajout d'un écouteur d'événements pour détecter la sélection d'un élément
	        menuAppartOuMaison.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Récupérer l'élément sélectionné et l'afficher
	                choixAppartOuMaison = (String) menuAppartOuMaison.getSelectedItem();
	                
	                // Activer ou désactiver des champ de texte en fonction de la sélection dans le menu déroulant
	                if (choixAppartOuMaison.equals("Maison individuelle")) {
	                    menuSousSol.setEnabled(true);
	                    menuCave.setEnabled(true);
	                    menuCour.setEnabled(true);
	                    menuJardin.setEnabled(true);
	                    menuTerrain.setEnabled(true);
	                    surfaceCour.setEnabled(true);
	                    surfaceJardin.setEnabled(true);
	                    surfaceTerrain.setEnabled(true);
	                    menuEscalier.setEnabled(false);
	                    numEtage.setEnabled(false);
	                    numAppartement.setEnabled(false);
	                    menuChauffageIndividuel.setEnabled(false);
	                } 
	                if (choixAppartOuMaison.equals("Appartement")) {
	                	menuSousSol.setEnabled(false);
	                	menuCave.setEnabled(false);
	                    menuCour.setEnabled(false);
	                    menuJardin.setEnabled(false);
	                    menuTerrain.setEnabled(false);
	                    surfaceCour.setEnabled(false);
	                    surfaceJardin.setEnabled(false);
	                    surfaceTerrain.setEnabled(false);
	                    menuEscalier.setEnabled(true);
	                    numEtage.setEnabled(true);
	                    numAppartement.setEnabled(true);
	                    menuChauffageIndividuel.setEnabled(true);
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de la surface du bien
	        surfaceBien.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (surfaceBien.getText().equals("Surface du bien")) {
	                    surfaceBien.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (surfaceBien.getText().isEmpty()) {
	                    surfaceBien.setText("Surface du bien");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de la surface de la cour
	        surfaceCour.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (surfaceCour.getText().equals("Surface de la cour")) {
	                    surfaceCour.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (surfaceCour.getText().isEmpty()) {
	                    surfaceCour.setText("Surface de la cour");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de la surface du terrain
	        surfaceTerrain.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (surfaceTerrain.getText().equals("Surface du terrain")) {
	                	surfaceTerrain.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (surfaceTerrain.getText().isEmpty()) {
	                	surfaceTerrain.setText("Surface du terrain");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de la surface du jardin
	        surfaceJardin.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (surfaceJardin.getText().equals("Surface du jardin")) {
	                	surfaceJardin.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (surfaceJardin.getText().isEmpty()) {
	                	surfaceJardin.setText("Surface du jardin");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de la surface de la terrasse
	        surfaceTerrasse.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (surfaceTerrasse.getText().equals("Surface de la terrasse")) {
	                	surfaceTerrasse.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (surfaceTerrasse.getText().isEmpty()) {
	                	surfaceTerrasse.setText("Surface de la terrasse");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de la surface du balcon
	        surfaceBalcon.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (surfaceBalcon.getText().equals("Surface du balcon")) {
	                	surfaceBalcon.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (surfaceBalcon.getText().isEmpty()) {
	                	surfaceBalcon.setText("Surface du balcon");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de l'annee de construction
	        anneeConstruction.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (anneeConstruction.getText().equals("Année de construction")) {
	                	anneeConstruction.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (anneeConstruction.getText().isEmpty()) {
	                	anneeConstruction.setText("Année de construction");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte du nombre de chambres
	        nombreChambres.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (nombreChambres.getText().equals("Nombre de chambres")) {
	                	nombreChambres.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (nombreChambres.getText().isEmpty()) {
	                	nombreChambres.setText("Nombre de chambres");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de la ville
	        ville.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (ville.getText().equals("Ville")) {
	                	ville.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (ville.getText().isEmpty()) {
	                	ville.setText("Ville");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de l'arrondissement
	        arrondissement.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (arrondissement.getText().equals("Arrondissement")) {
	                	arrondissement.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (arrondissement.getText().isEmpty()) {
	                	arrondissement.setText("Arrondissement");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte du nom de la rue
	        nomRue.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (nomRue.getText().equals("Nom de la rue")) {
	                	nomRue.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (nomRue.getText().isEmpty()) {
	                	nomRue.setText("Nom de la rue");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte du nom de la residence
	        nomResidence.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (nomResidence.getText().equals("Nom de la résidence")) {
	                	nomResidence.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (nomResidence.getText().isEmpty()) {
	                	nomResidence.setText("Nom de la résidence");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte de la description des meubles
	        descriptionMeubles.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (descriptionMeubles.getText().equals("Description des meubles")) {
	                	descriptionMeubles.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (descriptionMeubles.getText().isEmpty()) {
	                	descriptionMeubles.setText("Description des meubles");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte du numero d'étage
	        numEtage.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (numEtage.getText().equals("Numéro d'étage")) {
	                	numEtage.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (numEtage.getText().isEmpty()) {
	                	numEtage.setText("Numéro d'étage");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte du numero d'appartement
	        numAppartement.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (numAppartement.getText().equals("Numéro d'appartement")) {
	                	numAppartement.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (numAppartement.getText().isEmpty()) {
	                	numAppartement.setText("Numéro d'appartement");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte du numero de rue
	        numRue.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (numRue.getText().equals("Numéro de la rue")) {
	                	numRue.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (numRue.getText().isEmpty()) {
	                	numRue.setText("Numéro de la rue");
	                }
	            }
	        });
	        
	        // Ajout d'un écouteur de focus au champ de texte du code postal
	        codePostal.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Efface le texte indicatif lorsque le champ de texte obtient le focus
	                if (codePostal.getText().equals("Code postal")) {
	                	codePostal.setText("");
	                }
	            }
	
	            @Override
	            public void focusLost(FocusEvent e) {
	                // Restaure le texte indicatif si le champ de texte est vide lorsqu'il perd le focus
	                if (codePostal.getText().isEmpty()) {
	                	codePostal.setText("Code postal");
	                }
	            }
	        });
	        
	        container.add(codePostal);
	        container.add(menuTypesChauffage);
	        container.add(menuTypesBien);
	        container.add(numRue);
	        container.add(menuTypesVoie);
	        container.add(nomRue);
	        container.add(nomResidence);
	        container.add(menuChauffageIndividuel);
	        container.add(menuJardin);
	        container.add(surfaceJardin);
	        container.add(menuMeuble);
	        container.add(menuTerrain);
	        container.add(surfaceTerrain);
	        container.add(menuEscalier);
	        container.add(menuCave);
	        container.add(menuSousSol);
	        container.add(menuCour);
	        container.add(surfaceCour);
	        container.add(menuBalcon);
	        container.add(surfaceBalcon);
	        container.add(surfaceTerrasse);
	        container.add(menuTerrasse);
	        container.add(descriptionMeubles);
	        container.add(surfaceBien);
	        container.add(menuAppartOuMaison);
	        container.add(nombreChambres);
	        container.add(anneeConstruction);
	        container.add(arrondissement);
	        container.add(ville);
	        container.add(numAppartement);
	        container.add(numEtage);
	        container.add(enregistrer);
			jlBackground.setBackground(Color.BLACK);
	
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			
			enregistrer.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	enregistrerButton = true;
			    	
			    	if (choixAppartOuMaison == null || choixMeubleOuNon == null || choixEscalierOuNon == null || choixBalconOuNon == null || choixTerrasseOuNon == null)
			    		JOptionPane.showMessageDialog(null, "Certaines informations sont manquantes. Veuillez reessayer !", "Erreur de remplissage", JOptionPane.ERROR_MESSAGE);
			    	
			    	else {
			    	Bien bien = new Bien(0, defaultText(typeBienChoisi), convertTextToFloat(surfaceBien.getText(), "Surface du bien"),
			    						 convertTextToInt(codePostal.getText(), "Code postal"), !isAppartement(), isAppartement(),
			    						 convertTextToInt(nombreChambres.getText(), "Nombre de chambres"), convertTextToInt(anneeConstruction.getText(), "Année de construction"),
			    						 convertTextToInt(arrondissement.getText(), "Arrondissement"), ville.getText(),
			    						 convertTextToInt(numAppartement.getText(), "Numéro d'appartement"), convertTextToInt(numEtage.getText(), "Numéro d'étage"),
			    						 convertTextToInt(numRue.getText(), "Numéro de la rue"), defaultText(typeVoieChoisi),
			    						 nomRue.getText(), nomResidence.getText(), getChauffageIndividuel(),
			    						 defaultText(typeChauffageChoisi), aJardin(), convertTextToFloat(surfaceJardin.getText(), "Surface du jardin"),
			    						 estMeuble(), aTerrain(), convertTextToFloat(surfaceTerrain.getText(), "Surface du terrain"),
			    						 aEscalier(), aCave(), aSousSol(), aCour(), convertTextToFloat(surfaceCour.getText(), "Surface de la cour"),
			    						 aBalcon(), convertTextToFloat(surfaceBalcon.getText(), "Surface du balcon"), aTerrasse(),
			    						 convertTextToFloat(surfaceTerrasse.getText(), "Surface de la terrasse"), descriptionMeubles.getText());			    	
			    	BienDAO bienDAO= new BienDAO();			    	
			    	bienDAO.addBien(bien);
			    	}
			    	
			    	}
			});
	
	}
	
	/**
	 * Permet de verifier si l'utilisateur a clique sur 'Ajouter bail'
	 * 
	 * @return l'attribut addPropertyButton
	 */
	public boolean enregistrerClicked() {
		return enregistrerButton;
	}
	
	/**
	 * Permer de recuperer le type de bien choisi
	 * 
	 * return l'attribut typeBienChoisi
	 */
	public String getTypeBien() {
		return typeBienChoisi;
	}
	
	/**
	 * Permet de recuperer la surface du bien
	 */
	public String getSurfaceBien() {
		return surfaceBien.getText();
	}
	
	/**
	 * Permet de savoir si le bien est un appartement
	 */
	public boolean isAppartement() {
		if (choixAppartOuMaison.equals("Appartement"))
			return true;
		else
			return false;
	}
	
	/**
	 * Permet de recuperer le nombre de chambres
	 */
	public String getNombreChambres() {
		return nombreChambres.getText();
	}
	
	/**
	 * Permet de recuperer la description des meubles
	 */
	public String getDescriptionMeubles() {
		return descriptionMeubles.getText();
	}
	
	/**
	 * Permet de recuperer l'annee de construction
	 */
	public String getAnneeConstruction() {
		return anneeConstruction.getText();
	}
	
	/**
	 * Permet de recuperer l'arrondissement
	 */
	public String getArrondissement() {
		return arrondissement.getText();
	}
	
	/**
	 * Permet de recuperer la ville
	 */
	public String getVille() {
		return ville.getText();
	}
	
	/**
	 * Permet de recuperer le numero de la rue
	 */
	public String getNumRue() {
		return numRue.getText();
	}
	
	/**
	 * Permet de recuperer le type de voie
	 */
	public String getTypeVoie() {
		return typeVoieChoisi;
	}
	
	/**
	 * Permet de recuperer le nom de la rue
	 */
	public String getNomRue() {
		return nomRue.getText();
	}
	
	/**
	 * Permet de recuperer le nom de la résidence
	 */
	public String getNomResidence() {
		return nomResidence.getText();
	}
	
	/**
	 * Permet de recuperer le type de chauffage
	 */
	public String getTypeChauffage() {
		return typeChauffageChoisi;
	}
	
	/**
	 * Permet de savoir si le bien est meuble ou pas
	 */
	public boolean isMeuble() {
		if (choixMeubleOuNon.equals("Oui"))
			return true;
		else
			return false;
	}
	
	/**
	 * Permet de savoir si le bien a une cave
	 */
	public boolean aCave() {
		if (choixCaveOuNon == null)
			return false;
		else if (choixCaveOuNon.equals("Non"))
			return false;
		else
			return true;
	}
	
	/**
	 * Permet de savoir si le bien a une cour
	 */
	public boolean aCour() {
		if (choixCourOuNon == null)
			return false;
		if (choixCourOuNon.equals("Non"))
			return false;
		else
			return true;
	}
	
	/**
	 * Permet de savoir si le bien a un sous-sol
	 */
	public boolean aSousSol() {
		if (choixSousSolOuNon == null)
			return false;
		if (choixSousSolOuNon.equals("Non"))
			return false;
		else
			return true;
	}
	
	/**
	 * Permet de savoir si le bien a un balcon
	 */
	public boolean aBalcon() {
		if (choixBalconOuNon.equals("Oui"))
			return true;
		else
			return false;
	}
	
	/**
	 * Permet de savoir si le bien a une terrasse
	 */
	public boolean aTerrasse() {
		if (choixTerrasseOuNon.equals("Oui"))
			return true;
		else
			return false;
	}
	
	/**
	 * Permet de recuperer la surface du balcon
	 */
	public String getSurfaceBalcon() {
		return surfaceBalcon.getText();
	}
	
	/**
	 * Permet de recuperer la surface de la terrasse
	 */
	public String getSurfaceTerrasse() {
		return surfaceTerrasse.getText();
	}
	
	/**
	 * Permet de savoir si le chauffage est individuel ou non
	 */
	public boolean getChauffageIndividuel() {
		if (choixChauffageIndividuelOuNon.equals("Oui"))
			return true;
		else
			return false;
	}
	
	/**
	 * Permet de savoir si le bien a un jardin
	 */
	public boolean aJardin() {
		if (choixJardinOuNon == null)
			return false;
		else if (choixJardinOuNon.equals("Non"))
			return false;
		else
			return true;
	}
	
	/**
	 * Permet de savoir si le bien a un escalier
	 */
	public boolean aEscalier() {
		if (choixEscalierOuNon.equals("Oui"))
			return true;
		else
			return false;
	}
	
	/**
	 * Permet de savoir si le bien a un terrain
	 */
	public boolean aTerrain() {
		if (choixTerrainOuNon == null)
			return false;
		else if (choixTerrainOuNon.equals("Non"))
			return false;
		else
			return true;
	}
	
	/**
	 * Permet de savoir si le bien est meublé
	 */
	public boolean estMeuble() {
		if (choixMeubleOuNon.equals("Oui"))
			return true;
		else
			return false;
	}
	
	/**
	 * Permet de convertir des réels de String à float
	 * 
	 * @param text : un réel en String
	 * 
	 * @return sa valeur en float
	 */
	public float convertTextToFloat(String text, String text1) {
		if (text.equals(text1))
			return 0;
		else
			return Float.parseFloat(text);
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
