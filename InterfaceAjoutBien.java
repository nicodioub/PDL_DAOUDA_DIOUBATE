
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class InterfaceAjoutBien extends JFrame {
	
	private JPanel jlBackground;
	private JLabel jlColor;
	private JButton enregistrer;
	private Container container;
    private JTextField typeBien;// mettre ca en menu déroulant
    // Mettre tous les boolean en true or false avec des points 
    private JTextField surfaceBien;
    // faire deux pages différentes si il s'agit d'un appartement ou d'une maison 
    private JTextField isMaisonIndividuelle;
    private JTextField isAppartement;
    private JTextField nombreChambre;
    private JTextField anneeConstruction;
    private JTextField arrondissement;
    private JTextField ville;
    private JTextField numAppartement;
    private JTextField numEtage;
    private JTextField numRue;
    private JTextField typeRue;
    private JTextField nomRue;
    private JTextField nomResidence;
    private JTextField isChauffageIndividuel;
    private JTextField typeChauffage;
    private JTextField isJardin;
    private JTextField surfaceJardin;
    private JTextField isMeuble;
    private JTextField isTerrain;
    private JTextField surfaceTerrain;
    private JTextField isEscalier;
    private JTextField isCave;
    private JTextField isSousSol;
    private JTextField isCour;
    private JTextField surfaceCour;
    private JTextField isBalcon;
    private JTextField surfaceBalcon;
    private JTextField isTerrasse;
    private JTextField descriptionMeuble;



public InterfaceAjoutBien (String title, int width, int height  ) {
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int buttonWidth = 100; // Largeur du JButton
        int buttonHeight = 30; // Hauteur du JButton
        
        
        typeBien = new JTextField("Type Bien");
        surfaceBien = new JTextField("Surface Bien");
        isMaisonIndividuelle = new JTextField("Maison"); // mettre quelque chose à choic unique (oui/non)
        isAppartement = new JTextField("Appartement");
        nombreChambre = new JTextField("Nombre de chambre");
        anneeConstruction = new JTextField("Annee de construction");
        arrondissement = new JTextField("Arrondissement");
        ville = new JTextField("Ville");
        numAppartement = new JTextField("numero d'appartement");
        numEtage = new JTextField("numero etage");
        numRue = new JTextField("numero rue");
        typeRue = new JTextField("Type de rue");
        nomRue = new JTextField("Nom rue");
        nomResidence = new JTextField("Nom de la résidence");
        numEtage = new JTextField("numero etage");
        isChauffageIndividuel = new JTextField("Chauffage Individuelle");
        typeChauffage = new JTextField("type de chauffage");
        isJardin = new JTextField("Jardin ");
        surfaceJardin = new JTextField("surface jardin");
        isMeuble = new JTextField("Meuble");
        isTerrain = new JTextField("Terrain");
        surfaceTerrain = new JTextField("surface terrain");
        isEscalier = new JTextField("Escalier");
        isCave = new JTextField("Cave");
        numEtage = new JTextField("numero etage");
        isSousSol = new JTextField("Sous-sol");
        isCour = new JTextField("Cour");
        surfaceCour = new JTextField("surface cour ");
        isBalcon = new JTextField("Balcon");
        surfaceBalcon = new JTextField("surface balcon");
        isTerrasse = new JTextField("Terrasse");
        descriptionMeuble = new JTextField("description Meuble");




        
        
		jlBackground = new JPanel();
		this.setContentPane(jlBackground);
		enregistrer = new JButton("Enregistrer");
		container = this.getContentPane();
		
		
		
	    //table.setBackground(Color.BLACK); // Change to desired color

		
        
		 //scrollPane.getViewport().setBackground(Color.BLACK); // Change to desired color

	        
		container.setLayout(null); // Définir le layout sur null pour permettre le positionnement absolu
        typeBien.setBounds(100,50,150,30);
        surfaceBien.setBounds(100,90,150,30);
        isMaisonIndividuelle.setBounds(100,130,150,30);
        isAppartement.setBounds(100,170,150,30);
        nombreChambre.setBounds(100,210,150,30);
        anneeConstruction.setBounds(100,250,150,30);
        arrondissement.setBounds(100,290,150,30);
        ville.setBounds(100,330,150,30);
        numAppartement.setBounds(100,370,150,30);
        numEtage.setBounds(100,410,150,30);
        
        numRue.setBounds(100,450,150,30);
        typeRue.setBounds(100,490,150,30);
        nomRue.setBounds(100,530,150,30);
        nomResidence.setBounds(100,570,150,30);
        isChauffageIndividuel.setBounds(100,610,150,30);
        typeChauffage.setBounds(100,650,150,30);
        
        isJardin.setBounds(300,50,150,30);
        surfaceJardin.setBounds(300,90,150,30);
        isMeuble.setBounds(300,130,150,30);
        isTerrain.setBounds(300,170,150,30);
        surfaceTerrain.setBounds(300,210,150,30);
        isEscalier.setBounds(300,250,150,30);
        isCave.setBounds(300,290,150,30);
        isSousSol.setBounds(300,330,150,30);
        isCour.setBounds(300,370,150,30);
        surfaceCour.setBounds(300,410,150,30);
        isBalcon.setBounds(300,450,150,30);
        surfaceBalcon.setBounds(300,490,150,30);
        isTerrasse.setBounds(300,530,150,30);
        descriptionMeuble.setBounds(300,570,150,30);
        enregistrer.setBounds(300, 650, 150, 30);

        
        
        container.add(numRue);
        container.add(typeRue);
        container.add(nomRue);
        container.add(nomResidence);
        container.add(isChauffageIndividuel);
        container.add(typeChauffage);
        container.add(isJardin);
        container.add(surfaceJardin);
        container.add(isMeuble);
        container.add(isTerrain);
        container.add(surfaceTerrain);
        container.add(isEscalier);
        container.add(isCave);
        container.add(isSousSol);
        container.add(isCour);
        container.add(surfaceCour);
        container.add(isBalcon);
        container.add(surfaceBalcon);
        container.add(isTerrasse);
        container.add(descriptionMeuble);
        container.add(surfaceBien);
        container.add(isMaisonIndividuelle);
        container.add(isAppartement);
        container.add(nombreChambre);
        container.add(anneeConstruction);
        container.add(arrondissement);
        container.add(ville);
        container.add(numAppartement);
        container.add(numEtage);
        container.add(typeBien);
        container.add(enregistrer);
		jlBackground.setBackground(Color.BLACK);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		enregistrer.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String typeBienText = typeBien.getText();
		    	String surfaceBienText = surfaceBien.getText();
		    	String isMaisonIndividuelleText = isMaisonIndividuelle.getText();
		    	String isAppartementText = isAppartement.getText();
		    	String nombreChambreText = nombreChambre.getText();
		    	String anneeConstructionText = anneeConstruction.getText();
		    	String arrondissementText = arrondissement.getText();
		    	String villeText = ville.getText();
		    	String numAppartementText = numAppartement.getText();
		    	String numEtageText = numEtage.getText();
		    	String numRueText = numRue.getText();
		    	String typeRueText = typeRue.getText();
		    	String nomRueText = nomRue.getText();
		    	String nomResidenceText = nomResidence.getText();
		    	String isChauffageIndividuelText = isChauffageIndividuel.getText();
		    	String typeChauffageText = typeChauffage.getText();
		    	String isJardinText = isJardin.getText();
		    	String surfaceJardinText = surfaceJardin.getText();
		    	String isMeubleText = isMeuble.getText();
		    	String isTerrainText = isTerrain.getText();
		    	String surfaceTerrainText = surfaceTerrain.getText();
		    	String isEscalierText = isEscalier.getText();
		    	String isCaveText = isCave.getText();
		    	String isSousSolText = isSousSol.getText();
		    	String isCourText = isCour.getText();
		    	String surfaceCourText = surfaceCour.getText();
		    	String isBalconText = isBalcon.getText();
		    	String surfaceBalconText = surfaceBalcon.getText();
		    	String isTerrasseText = isTerrasse.getText();
		    	String descriptionMeubleText = descriptionMeuble.getText();


		        
		
		    }
		});

}

}

