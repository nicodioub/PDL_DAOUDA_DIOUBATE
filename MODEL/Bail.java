package model;
import java.util.*;

/**
 * Classe representant un bail
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Bail {
	
	/**
	 * id du Bail
	 */
	private int idBail;
	
	/**
	 * id du Garant
	 */
	private int idGarant;
	
	/**
	 * id du Bailleur
	 */
	private int idBailleur;
	
	/**
	 * id du Locataire
	 */
	private int idLocataire;
	
	/**
	 * Duree du bail (en mois)
	 */
	private int duree;
	
	/**
	 * Type du bail
	 */
	private String type;
	
	/**
	 * Date de debut du bail
	 */
	private Date dateDebut;
	
	/**
	 * Date de fin du bail
	 */
	private Date dateFin;
	
	/**
	 * Montant du loyer
	 */
	private float montantLoyer;
	
	/**
	 * Frais d'agence
	 */
	private float fraisAgence;
	
	/**
	 * Charges du bail
	 */
	private float charges;
	
	/**
	 * Montant de la caution
	 */
	private float montantCaution;
	
	/**
	 * Date d'échéance
	 */
	private Date dateEcheance;
	
	/**
	 * Frequence de revision du loyer
	 */
	private int frequenceRevisionLoyer;
	
	
	/**
	 * Constructeur de la classe Bail
	 * 
	 * @param duree : duree quelconque
	 * @param type : type quelconque
	 * @param dateDebut : date de debut quelconque
	 * @param dateFin : date de fin quelconque 
	 * @param montantLoyer : montant quelconque
	 * @param fraisAgence : valeur quelconque
	 * @param charges : valeur quelconque
	 * @param montantCaution : valeur quelconque
	 * @param frequenceRevisionLoyer : frequence quelconque
	 * @param presenceGarant : valeur true si la bail a un garant
	 * @param garant : un garant 
	 */
	public Bail (int idBail, int idBailleur, int idLocataire, int idGarant, int duree, String type, Date dateDebut, 
				 Date dateFin, Date dateEcheance, float montantLoyer, float fraisAgence, float charges, 
				 float montantCaution, int frequenceRevisionLoyer)
	{
		this.idBail = idBail;
		this.idBailleur = idBailleur;
		this.idLocataire = idLocataire;
		this.idGarant = idGarant;
		this.duree = duree;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montantLoyer = montantLoyer;
		this.fraisAgence = fraisAgence;
		this.charges = charges;
		this.montantCaution = montantCaution;
		this.frequenceRevisionLoyer = frequenceRevisionLoyer;
	}
	
	/**
	 * getter de l'attribut idBail
	 * 
	 * @return l'attribut idBail
	 */
	public int getIdBail( ) {
		return idBail;
	}
	
	/**
	 * getter de l'attribut idGarant
	 * 
	 * @return l'attribut idGarant
	 */
	public int getIdGarant( ) {
		return idGarant;
	}
	
	/**
	 * getter de l'attribut idBailleur
	 * 
	 * @return l'attribut iBailleur
	 */
	public int getIdBailleur( ) {
		return idBailleur;
	}
	
	/**
	 * getter de l'attribut idLocataire
	 * 
	 * @return l'attribut idLocataire
	 */
	public int getIdLocataire( ) {
		return idLocataire;
	}
	
	
	/**
	 * getter de l'attribut duree
	 * 
	 * @return l'attribut duree
	 */
	public int getDuree( ) {
		return duree;
	}
	
	/**
	 * getter de l'attribut type
	 * 
	 * @return l'attribut type
	 */
	public String getType( ) {
		return type;
	}
	
	/**
	 * getter de l'attribut dateDebut
	 * 
	 * @return l'attribut dateDebut
	 */
	public Date getDateDebut( ) {
		return dateDebut;
	}
	
	/**
	 * getter de l'attribut dateFin
	 * 
	 * @return l'attribut dateFin
	 */
	public Date getDateFin( ) {
		return dateFin;
	}
	
	/**
	 * getter de l'attribut dateEcheance
	 * 
	 * @return l'attribut dateEcheance
	 */
	public Date getDateEcheance( ) {
		return dateEcheance;
	}
	
	/**
	 * getter de l'attribut montantLoyer
	 * 
	 * @return l'attribut montantLoyer
	 */
	public float getMontantLoyer( ) {
		return montantLoyer;
	}
	
	/**
	 * getter de l'attribut montantCaution
	 * 
	 * @return l'attribut montantCaution
	 */
	public float getMontantCaution( ) {
		return montantCaution;
	}
	
	/**
	 * getter de l'attribut fraisAgence
	 * 
	 * @return l'attribut fraisAgence
	 */
	public float getFraisAgence( ) {
		return fraisAgence;
	}
	
	/**
	 * getter de l'attribut charges
	 * 
	 * @return l'attribut charges
	 */
	public float getCharges( ) {
		return charges;
	}
	
	/**
	 * getter de l'attribut frequenceRevisionLoyer
	 * 
	 * @return l'attribut frequenceRevisionLoyer
	 */
	public int getFrequenceRevisionLoyer( ) {
		return frequenceRevisionLoyer;
	}
	
	
	/**
	 * affiche les informations sur un bail
	 */
	/*
	public void display() {
		System.out.print("\nBailleur : \n" + bailleur);
		System.out.print("\nDuree : " + duree + " mois" + "\nType : " + type);
		System.out.print("\nDate de debut : " + dateDebut + "\nDate de fin : " + dateFin);
		System.out.print("\nMontant du loyer : " + montantLoyer + " euros");
		System.out.print("\nMontant de la caution : " + montantCaution + " euros");
		System.out.print("\nFrais d'agence : " + fraisAgence + " euros");
		System.out.print("\nCharges : " + charges + " euros");
		System.out.print("\nFrequence de revision du loyer : " + frequenceRevisionLoyer);
		System.out.print("\nGarant : ");
		if (presenceGarant == true) {
			System.out.print("Oui");
			garant.display();
		}
		else
			System.out.print("Non");
		if (listeLocataires.size() > 0) {
			for(int i=0; i<listeLocataires.size(); i++) {
				System.out.print("\nLocataire n°" + (i+1) + ": ");
				listeLocataires.get(i).display();
				
			}
		}
	}
	*/
}
