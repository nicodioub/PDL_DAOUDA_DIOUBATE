package model;
/**
 * Classe representant un appartement (extension de BienImmobilier)
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Appartement {
	
	/**
	 * Permet de savoir si l'appartement a un escalier ou pas
	 */
	private boolean escalier;
	
	/**
	 * Permet de savoir si l'appartement a un chauffage individuel ou pas
	 */
	private boolean chauffageIndividuel;
	
	/**
	 * Etage auquel se situe l'appartement
	 */
	private int etage;
	
	/**
	 * Numéro de l'appartement
	 */
	private int numAppartement;
	
	
	/**
	 * Constructeur de la classe Appartement
	 * 
	 * @param ville : ville quelconque
	 * @param arrondissement : arrondissement quelconque
	 * @param numRue : numero de rue quelconque
	 * @param typeRue : type de rue quelconque
	 * @param nomRue : nom de rue quelconque
	 * @param type : type de bien quelconque
	 * @param residence : nom de residence quelconque
	 * @param surface : surface quelconque
	 * @param nombreChambres : nombre quelconque
	 * @param descriptionMeubles : description quelconque
	 * @param estMeuble : valeur true si le bien est meuble
	 * @param aUnBalcon : valeur true si le bien a un balcon
	 * @param aUneTerrasse : valeur true si le bien a une terrasse
	 * @param surfaceTerrasse : surface quelconque
	 * @param anneeConsctruction : annee quelconque
	 * @param typeChauffage : type de chauffage quelconque
	 * @param escalier : valeur true si l'appartement a un escalier
	 * @param chauffageIndividuel : valeur true si l'appartement a un chauffage individuelle
	 * @param etage : valeur d'etage quelconque
	 * @param numAppartement : valeur quelconque
	 */
	public Appartement (String ville, String arrondissement, String numRue, String typeRue, String nomRue,
			String type, String residence, float surface, int nombreChambres, String descriptionMeubles,
			boolean meuble, boolean balcon, boolean terrasse, float surfaceTerrasse, int anneeConstruction,
			String typeChauffage, boolean escalier, boolean chauffageIndividuel, int etage, int numAppartement)
	{
		// super(ville, arrondissement, numRue, typeRue, nomRue, type, residence, surface, nombreChambres, descriptionMeubles,
		// 	  meuble, balcon, terrasse, surfaceTerrasse, anneeConstruction, typeChauffage);
		this.escalier = escalier;
		this.chauffageIndividuel = chauffageIndividuel;
		this.etage = etage;
		this.numAppartement = numAppartement;
	}
	
	
	/**
	 * getter de l'attribut etage
	 * 
	 * @return l'attribut etage
	 */
	public int getEtage() {
		return etage;
	}
	
	
	/**
	 * getter de l'attribut numAppartement
	 * 
	 * @return l'attribut numAppartement
	 */
	public int getNumAppartement() {
		return numAppartement;
	}
	
	
	/**
	 * getter de l'attribut escalier
	 * 
	 * @return l'attribut escalien
	 */
	public boolean aUnEscalier() {
		return escalier;
	}
	
	
	/**
	 * getter de l'attribut chauffageIndividuel
	 * 
	 * @return l'attribut chauffageIndividuel
	 */
	public boolean aChauffageIndividuel() {
		return chauffageIndividuel;
	}
	
	/**
	 * setter de l'attribut etage
	 * 
	 * @param surfaceTerrain : nouvelle valeur pour l'etage
	 */
	public void setEtage(int etage) {
		this.etage = etage;
	}
	
	/**
	 * setter de l'attribut numAppartement
	 * 
	 * @param numAppartement : nouvelle valeur pour le numero d'appartement
	 */
	public void setNumAppartement(int numAppartement) {
		this.numAppartement = numAppartement;
	}
	
	
	/**
	 * affiche les informations sur un appartement (bien immobilier)
	 */
	public void display() {
		// super.display();
		System.out.print("\nChauffage individuel : ");
		if (chauffageIndividuel == true)
			System.out.print("Oui");
		else
			System.out.print("Non");
		System.out.print("\nEscalier : ");
		if (escalier == true)
			System.out.print("Oui");
		else
			System.out.print("Non");
		System.out.print("\nEtage : " + etage);
		System.out.print("\nNuméro d'appartement : " + numAppartement);
		
	}

}
