package model;
/**
 * Classe representant un Locataire
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Locataire {

	/**
	 * Permet de savoir si le locataire est une societe ou non
	 */
	private boolean societe;
	
	/*
	 * Id du locataire
	 */
	private int idLocataire; 
	
	/**
	 * Raison sociale d'un locataire (si c'est une entreprise)
	 */
	private String raisonSociale;
	
	/*
	 * Adresse d'un locataire (si c'est une entreprise)
	 */
	private String adresse;
	
	/**
	 * Bien immobilier auquel le locataire est associé
	 */	
	private int idBien;
	
	/**
	 * Nom d'un locataire
	 */
	private String nomLocataire;
	
	/**
	 * Prénom d'un locataire
	 */
	private String prenomLocataire;
	
	/*
	 * Numéro d'un locataire
	 */
	private String numeroLocataire;
	
	/*
	 * Email d'un locataire
	 */
	private String emailLocataire;
	
	/**
	 * Constructeur de la classe Bailleur
	 * 
	 * @param idLocataaire : id du Locataire
	 * @param nomLocataire : nom quelconque
	 * @param prenomLocataire : prenom quelconque
	 * @param emailLocataire : email quelconque
	 * @param numeroLocataire : numero quelconque
	 * @param societe : valeur true si le locataire est une societe 
	 * @param raisonSociale : raison sociale quelconque
	 * @param idBien : un bien immobilier auquel est rattaché le locataire
	 */
	public Locataire (int idLocataire, String nomLocataire, String prenomLocataire, String adresse, 
					  String emailLocataire, String numeroLocataire, boolean societe, String raisonSociale, 
					  int idBien)
	{
		this.idLocataire = idLocataire;
		this.nomLocataire = nomLocataire;
		this.prenomLocataire = prenomLocataire;
		this.emailLocataire = emailLocataire;
		this.numeroLocataire = numeroLocataire;
		this.societe = societe;
		this.raisonSociale = raisonSociale;
		this.idBien  = idBien;
		this.adresse = adresse ; 
	}
	
	
	/**
	 * getter de l'attribut idLocataire
	 * 
	 * @return : l'attribut idLocataire
	 */
	public int getIdLocataire() {
		return idLocataire;
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
	 * getter de l'attribut societe
	 * 
	 * @return : l'attribut societe
	 */
	public boolean getSociete() {
		return societe;
	}

	/**
	 * getter de l'attribut raisonSociale
	 * 
	 * @return l'attribut raisonSociale
	 */
	public String getRaisonSociale() {
		return raisonSociale;
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
	 * getter de l'attribut nomLocataire
	 * 
	 * @return l'attribut nomLocataire
	 */
	public String getNomLocataire() {
		return nomLocataire;
	}
	
	/**
	 * getter de l'attribut prenomLocataire
	 * 
	 * @return l'attribut prenomLocataire
	 */
	public String getPrenomLocataire() {
		return prenomLocataire;
	}
	
	/**
	 * getter de l'attribut numeroLocataire
	 * 
	 * @return l'attribut numeroLocataire
	 */
	public String getNumeroLocataire() {
		return numeroLocataire;
	}
	
	/**
	 * getter de l'attribut emailLocataire
	 * 
	 * @return l'attribut emailLocataire
	 */
	public String getEmailLocataire() {
		return emailLocataire;
	}
	
	
	
	
	
	
	public void setAdresse(String adresse2) {
		adresse = adresse2;
	}
	
	public void setIdLocataire(int idLocataire) {
		this.idLocataire = idLocataire;
	}

	/**
	 * setter de l'attribut raisonSociale
	 * 
	 * @param raisonSociale : nouvelle raison sociale
	 */
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
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
