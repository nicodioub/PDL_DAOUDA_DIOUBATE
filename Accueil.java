package gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Accueil extends JFrame{
	
	// Attributs de la classe
	
	// private JLabel jlName;
	// private JLabel jlColor;
	private JLabel loginText;
	private JLabel passwordText;
	private JLabel jlPicture;
	private JButton connexion;
	private JPanel jlBackground;
	private Container container;
	private JTextField login;
	private JPasswordField password; // Adding JPasswordField here
	private boolean connected;



	 
	// Paramètre de la fenêtre 
	public Accueil (String title, int width, int height  ) {
		
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
        //  int x = (width - buttonWidth) / 2; // Calcul des coordonnées x pour centrer le JButton horizontalement
        // int y = (height - buttonHeight) / 2; // Calcul des coordonnées y pour centrer le JButton verticalement
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
				
		// jlColor = new JLabel();
        
		// Set de la couleur du fond
		
		jlBackground.setBackground(Color.BLACK);
		
		
		jlPicture.setIcon(new ImageIcon("C:\\Users\\Ilyas DAOUDA\\Downloads\\dinasty.png"));
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\Ilyas DAOUDA\\Downloads\\dinasty.png");
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
		
		// Ajout d'un écouteur d'action du bouton 'Connexion'
		connexion.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
		        connected = true;
		    }
		});

	}

	/**
	 * Permet de recuperer le login
	 * 
	 * @return le login
	 */
	public String getLogin () {
		return login.getText();
	}
	
	/**
	 * Permet de recuperer le password
	 * 
	 * @return le password
	 */
	public String getPassword() {
		return new String (password.getPassword());
	}
	
	 /**
     * Vide les champs de texte
     */
    public void cleanTextField() {
    	SwingUtilities.invokeLater(() -> {
            login.setText("");
        });
        SwingUtilities.invokeLater(() -> {
            password.setText("");
        });

    }
	
	/**
	 * Permet de verifier si l'utilisateur a clique sur 'Connexion'
	 * 
	 * @return l'attribut connected
	 */
	public boolean isConnected() {
		return connected;
	}

}
