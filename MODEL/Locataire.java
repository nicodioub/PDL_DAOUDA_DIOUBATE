package model;
/**
 * Classe representant un Locataire (extension de personne)
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Locataire extends Personne{

	/**
	 * Permet de savoir si le locataire est une societe ou non
	 */
	private boolean societe;
	
	/**
	 * Raison sociale d'un locataire (si c'est une entreprise)
	 */
	private String raisonSociale;
	
	/**
	 * Bail auquel le locataire est associe
	 */
	private Bail bail;
	
	/**
	 * Bien immobilier auquel le locataire est associé
	 */
	private Bien bienImmobilier;
	
	/**
	 * Constructeur de la classe Bailleur
	 * 
	 * @param unNom : nom quelconque
	 * @param unPrenom : prenom quelconque
	 * @param unEmail : email quelconque
	 * @param unNumero : numero quelconque
	 * @param societe : valeur true si le locataire est une societe 
	 * @param raisonSociale : raison sociale quelconque
	 * @param bail : un bail
	 * @param bienImmobilier : un bien immobilier
	 */
	public Locataire (String unNom, String unPrenom, String unEmail, String unNumero, boolean societe, String raisonSociale,
			Bail bail, Bien bienImmobilier)
	{
		super(unNom, unPrenom, unEmail, unNumero);
		this.societe = societe;
		this.raisonSociale = raisonSociale;
		this.bail = bail;
		this.bienImmobilier = bienImmobilier;
	}
	
	
	/**
	 * getter de l'attribut societe
	 * 
	 * @return l'attribut societe
	 */
	public boolean isSociete() {
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
	@Override
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
}
