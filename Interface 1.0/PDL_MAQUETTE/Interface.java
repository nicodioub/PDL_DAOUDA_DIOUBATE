import javax.swing.JFrame;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.JButton;
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
import javax.swing.JPanel;

public class Interface extends JFrame{
	
	// Attribut de notre interface 
	
	private JLabel jlName;
	private JLabel jlColor;
	private JLabel loginText;
	private JLabel passwordText;
	private JLabel jlPicture;
	private JButton connexion;
	private JPanel jlBackground;
	private Container container;
    private JTextField login;
    
    private JPasswordField password; // Adding JPasswordField here



	 
	// Paramètre de la fenêtre 
	public Interface (String title, int width, int height  ) {
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Instanciation 
		login = new JTextField();
		
		jlBackground = new JPanel();
		this.setContentPane(jlBackground);
		jlPicture = new JLabel();
		loginText = new JLabel("Login : ");
		passwordText = new JLabel("Password :");
		connexion = new JButton("Connexion");
        password = new JPasswordField();

		
		container = this.getContentPane();
        container.setLayout(null); // Définir le layout sur null pour permettre le positionnement absolu


        int buttonWidth = 100; // Largeur du JButton
        int buttonHeight = 30; // Hauteur du JButton
        int x = (width - buttonWidth) / 2; // Calcul des coordonnées x pour centrer le JButton horizontalement
        int y = (height - buttonHeight) / 2; // Calcul des coordonnées y pour centrer le JButton verticalement
        connexion.setBounds(500, 500, buttonWidth, buttonHeight);
        
		container.add(connexion);
		

		// Ajout d'un JTextField avec des coordonnées absolues
		login.setBounds(500, 400, 200, 30); // Positionnement du JTextField à (100, 100) avec une largeur de 200 et une hauteur de 30
		container.add(login);
		
		
		loginText.setBounds(450, 400, 200, 30);
		passwordText.setBounds(428,450,200,30);
		loginText.setForeground(Color.WHITE);
		passwordText.setForeground(Color.WHITE);
		container.add(passwordText);
        container.add(loginText);

        password.setBounds(500, 450, 200, 30);
        container.add(password);
				
		jlColor = new JLabel();
		// Set de la couleur du fond
		
		jlBackground.setBackground(Color.BLACK);
		
		
		jlPicture.setIcon(new ImageIcon("C:\\Users\\NICO\\Desktop\\Nico\\ESIGELEC\\1A\\PDL\\dinasty.png"));
		 ImageIcon imageIcon = new ImageIcon("C:\\Users\\NICO\\Desktop\\Nico\\ESIGELEC\\1A\\PDL\\dinasty.png");
	     Image image = imageIcon.getImage();

	        // Redimensionnement de l'image
	     Image scaledImage = image.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
	     ImageIcon scaledImageIcon = new ImageIcon(scaledImage);	
	     
	     
	     int imageWidth = imageIcon.getIconWidth();
	     int imageHeight = imageIcon.getIconHeight();

	        // Positionnement de l'image au centre de la fenêtre
	      int imageDinastyx = (width - imageWidth -150 ) ;
	      int imageDinastyy = (height - imageHeight -150);
	      jlPicture.setBounds(imageDinastyx, imageDinastyy, imageWidth, imageHeight);
	      
	      
	    jlPicture.setIcon(scaledImageIcon);

		container.add(jlPicture);
		 
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		connexion.addActionListener(new ActionListener() {
			
		    public void actionPerformed(ActionEvent e) {
		        // Récupérer le texte saisi dans le champ login
		        String loginText = login.getText();
		        // Récupérer le mot de passe saisi dans le champ password
		        char[] passwordChars = password.getPassword();
		        String passwordText = new String(passwordChars);
		        // Afficher le texte dans la console
		        
		        if (loginText.equals("login") && passwordText.equals("username")) {
		        	Interface2 window2 = new Interface2("Logiciel de gestion DD",1400,750);
		        	dispose(); // Close the login interface
		        	
		        }
		        
		    }
		    
		    
		}
		
		

);

	}

	 
	            
	

}
