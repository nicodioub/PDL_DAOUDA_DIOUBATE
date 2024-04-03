import java.util.*;

/**
 * Classe representant un bail
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Bail {
	
	/**
	 * Bailleur du bail
	 */
	private Bailleur bailleur;
	
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
	 * Frequence de revision du loyer
	 */
	private String frequenceRevisionLoyer;
	
	/**
	 * Permet de savoir si le bail presente un garant ou non
	 */
	private boolean presenceGarant;
	
	/**
	 * Garant du bail
	 */
	private Garant garant;
	
	/**
	 * Liste des locataires du bien associe au bail
	 */
	private ArrayList<Locataire> listeLocataires;
	
	
	/**
	 * Constructeur de la classe Bail
	 * 
	 * @param bailleur : un bailleur
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
	public Bail (Bailleur bailleur, int duree, String type, Date dateDebut, Date dateFin, float montantLoyer,
			     float fraisAgence, float charges, float montantCaution, String frequenceRevisionLoyer, boolean presenceGarant,
			     Garant garant)
	{
		this.bailleur = bailleur;
		this.duree = duree;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montantLoyer = montantLoyer;
		this.fraisAgence = fraisAgence;
		this.charges = charges;
		this.montantCaution = montantCaution;
		this.frequenceRevisionLoyer = frequenceRevisionLoyer;
		this.presenceGarant = presenceGarant;
		this.garant = garant;
		listeLocataires = new ArrayList<Locataire>();
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
	 * setter de l'attribut duree
	 * 
	 * @param nomUtilisateur : la nouvelle duree
	 */
	public void setDuree (int duree) {
		this.duree = duree;
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
	 * setter de l'attribut type
	 * 
	 * @param nomUtilisateur : le nouveau type
	 */
	public void setType (String type) {
		this.type = type;
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
	 * setter de l'attribut dateDebut
	 * 
	 * @param dateDebut : la nouvelle date
	 */
	public void setDateDebut (Date dateDebut) {
		this.dateDebut = dateDebut;
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
	 * setter de l'attribut dateFin
	 * 
	 * @param dateFin : la nouvelle date
	 */
	public void setDateFin (Date dateFin) {
		this.dateFin = dateFin;
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
	 * setter de l'attribut montantLoyer
	 * 
	 * @param montantLoyer : le nouveau montant
	 */
	public void setMontantLoyer (float montantLoyer) {
		this.montantLoyer = montantLoyer;
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
	 * setter de l'attribut montantCaution
	 * 
	 * @param montantCaution : le nouveau montant
	 */
	public void setMontantCaution (float montantCaution) {
		this.montantCaution = montantCaution;
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
	 * setter de l'attribut fraisAgence
	 * 
	 * @param fraisAgence : la nouvelle valeur des frais
	 */
	public void setFraisAgence (float fraisAgence) {
		this.fraisAgence = fraisAgence;
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
	 * setter de l'attribut charges
	 * 
	 * @param charges : la nouvelle valeur des charges
	 */
	public void setCharges (float charges) {
		this.charges = charges;
	}
	
	/**
	 * getter de l'attribut frequenceRevisionLoyer
	 * 
	 * @return l'attribut frequenceRevisionLoyer
	 */
	public String getFrequenceRevisionLoyer( ) {
		return frequenceRevisionLoyer;
	}
	
	/**
	 * setter de l'attribut frequenceRevisionLoyer
	 * 
	 * @param frequenceRevisionLoyer : la nouvelle frequence
	 */
	public void setFrequenceRevisionLoyer (String frequenceRevisionLoyer) {
		this.frequenceRevisionLoyer = frequenceRevisionLoyer;
	}
	
	/**
	 * getter de l'attribut presenceGarant
	 * 
	 * @return l'attribut presenceGarant
	 */
	public boolean aGarant() {
		return presenceGarant;
	}
	
	/**
	 * permet d'ajouter un locataire à la liste
	 * 
	 * @param unBail : objet de type Locataire
	 */
	public void addLocataire (Locataire unLocataire) {
		listeLocataires.add(unLocataire);
	}
	
	
	/**
	 * affiche les informations sur un bail
	 */
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

}
