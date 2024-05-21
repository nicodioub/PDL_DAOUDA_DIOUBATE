package model;
/**
 * Classe representant un Locataire
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Bailleur {

	/*
	 * Id du bailleur
	 */
	private int idBailleur; 
	
	/*
	 * Adresse d'un bailleur
	 */
	private String adresse;
	
	/**
	 * Bien immobilier auquel le bailleur est associé
	 */	
	private int idBien;
	
	/**
	 * Nom d'un bailleur
	 */
	private String nomBailleur;
	
	/**
	 * Prénom d'un bailleur
	 */
	private String prenomBailleur;
	
	/*
	 * Numéro d'un bailleur
	 */
	private String numeroBailleur;
	
	/*
	 * Email d'un bailleur
	 */
	private String emailBailleur;
	
	/**
	 * Constructeur de la classe Bailleur
	 * 
	 * @param idBailleur : id du Bailleur
	 * @param nomBailleur : nom quelconque
	 * @param prenomBailleur : prenom quelconque
	 * @param emailBailleur : email quelconque
	 * @param numeroBailleur : numero quelconque
	 * @param adresse : adresse quelconque
	 */
	public Bailleur (int idBailleur, String nomBailleur, String prenomBailleur, String adresse, 
					  String emailBailleur, String numeroBailleur, int idBien)
	{
		this.idBailleur = idBailleur;
		this.nomBailleur  = nomBailleur;
		this.prenomBailleur = prenomBailleur;
		this.emailBailleur = emailBailleur;
		this.numeroBailleur = numeroBailleur;
		this.idBien  = idBien;
		this.adresse = adresse ; 
	}
	
	
	/**
	 * getter de l'attribut idBailleur
	 * 
	 * @return : l'attribut idBailleur
	 */
	public int getIdBailleur() {
		return idBailleur;
	}
	
	/**
	 * getter de l'attribut idBien
	 * 
	 * @return : l'attribut idBien
	 */
	public int getIdBien() {
		return idBien;
	}
	
	/**
	 * getter de l'attribut adresse
	 * 
	 * @return l'attribut adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * getter de l'attribut nomBailleur
	 * 
	 * @return l'attribut nomBailleur
	 */
	public String getNomBailleur() {
		return nomBailleur;
	}
	
	/**
	 * getter de l'attribut prenomBailleur
	 * 
	 * @return l'attribut prenomBailleur
	 */
	public String getPrenomBailleur() {
		return prenomBailleur;
	}
	
	/**
	 * getter de l'attribut numeroBailleur
	 * 
	 * @return l'attribut numeroBailleur
	 */
	public String getNumeroBailleur() {
		return numeroBailleur;
	}
	
	/**
	 * getter de l'attribut emailBailleur
	 * 
	 * @return l'attribut emailBailleur
	 */
	public String getEmailBailleur() {
		return emailBailleur;
	}
	
	
	
	
	
	
	public void setAdresse(String adresse2) {
		adresse = adresse2;
	}
	
	public void setIdBailleur(int idBailleur) {
		this.idBailleur = idBailleur;
	}
	

	/**
	 * affiche les informations sur un locataire (personne)
	 */
	/*
	public void display() {
		super.display();
		System.out.print("\nSociete : ");
		if (societe == true) {
			System.out.print("Oui");
			System.out.print("\nRaison sociale : " + raisonSociale);
		}
		else
			System.out.print("Non");
	}
	*/
}
