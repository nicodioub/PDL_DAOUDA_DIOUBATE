import java.util.*;

/**
 * Classe representant un bien immobilier
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class BienImmobilier {
	
	/**
	 * Ville du bien
	 */
	protected String ville;
	
	/**
	 * Arrondissement du bien
	 */
	protected String arrondissement;
	
	/**
	 * Numero de la rue du bien
	 */
	protected String numRue;
	
	/**
	 * Type de la rue du bien
	 */
	protected String typeRue;
	
	/**
	 * Nom de la rue du bien
	 */
	protected String nomRue;
	
	/**
	 * Type du bien
	 */
	protected String type;
	
	/**
	 * Residence du bien
	 */
	protected String residence;
	
	/**
	 * Surface du bien
	 */
	protected float surface;
	
	/**
	 * Nombre de chambres du bien
	 */
	protected int nombreChambres;
	
	/**
	 * Description des meubles du bien
	 */
	protected String descriptionMeubles;
	
	/**
	 * Permet de savoir si le bien est meuble ou pas
	 */
	protected boolean meuble;
	
	/**
	 * Permet de savoir si le bien possede un balcon ou pas
	 */
	protected boolean balcon;
	
	/**
	 * Permet de savoir si le bien possede une terrasse ou pas
	 */
	protected boolean terrasse;
	
	/**
	 * Surface de la terrasse du bien
	 */
	protected float surfaceTerrasse;
	
	/**
	 * Annee de construction du bien
	 */
	protected int anneeConstruction;
	
	/**
	 * Type de chauffage du bien
	 */
	protected String typeChauffage;
	
	/**
	 * Liste des locataires du bien
	 */
	protected ArrayList<Locataire> listeLocataires;
	
	
	/**
	 * Constructeur de la classe BienImmobilier
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
	 */
	public BienImmobilier (String ville, String arrondissement, String numRue, String typeRue, String nomRue,
			String type, String residence, float surface, int nombreChambres, String descriptionMeubles,
			boolean meuble, boolean balcon, boolean terrasse, float surfaceTerrasse, int anneeConstruction,
			String typeChauffage) {
		this.ville = ville;
		this.arrondissement = arrondissement;
		this.numRue = numRue;
		this.typeRue = typeRue;
		this.nomRue = nomRue;
		this.type = type;
		this.residence = residence;
		this.surface = surface;
		this.nombreChambres = nombreChambres;
		this.descriptionMeubles = descriptionMeubles;
		this.meuble = meuble;
		this.balcon = balcon;
		this.terrasse = terrasse;
		this.surfaceTerrasse = surfaceTerrasse;
		this.anneeConstruction = anneeConstruction;
		this.typeChauffage = typeChauffage;
		listeLocataires = new ArrayList<Locataire>();
	}


	/**
	 * getter de l'attribut ville
	 * 
	 * @return l'attribut ville
	 */
	public String getVille() {
		return ville;
	}

	
	/**
	 * setter de l'attribut ville
	 * 
	 * @param ville : nouvelle valeur pour la ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * getter de l'attribut arrondissement
	 * 
	 * @return l'attribut arrondissement
	 */
	public String getArrondissement() {
		return arrondissement;
	}

	
	/**
	 * setter de l'attribut arrondissement
	 * 
	 * @param arrondissement : nouvelle valeur pour l'arrondissement
	 */
	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}

	/**
	 * getter de l'attribut numRue
	 * 
	 * @return l'attribut numRue
	 */
	public String getNumRue() {
		return numRue;
	}

	
	/**
	 * setter de l'attribut numRue
	 * 
	 * @param numRue : nouvelle valeur pour le numero de rue
	 */
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	/**
	 * getter de l'attribut typeRue
	 * 
	 * @return l'attribut typeRue
	 */
	public String getTypeRue() {
		return typeRue;
	}

	
	/**
	 * setter de l'attribut typeRue
	 * 
	 * @param typeRue : nouvelle valeur pour le type de rue
	 */
	public void setTypeRue(String typeRue) {
		this.typeRue = typeRue;
	}

	/**
	 * getter de l'attribut nomRue
	 * 
	 * @return l'attribut nomRue
	 */
	public String getNomRue() {
		return nomRue;
	}

	
	/**
	 * setter de l'attribut nomRue
	 * 
	 * @param nomRue : nouvelle valeur pour le nom de rue
	 */
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	/**
	 * getter de l'attribut type
	 * 
	 * @return l'attribut type
	 */
	public String getType() {
		return type;
	}

	
	/**
	 * setter de l'attribut type
	 * 
	 * @param type : nouvelle valeur pour le type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getter de l'attribut residence
	 * 
	 * @return l'attribut residence
	 */
	public String getResidence() {
		return residence;
	}

	
	/**
	 * setter de l'attribut residence
	 * 
	 * @param residence : nouvelle valeur pour la residence
	 */
	public void setResidence(String residence) {
		this.residence = residence;
	}

	/**
	 * getter de l'attribut surface
	 * 
	 * @return l'attribut surface
	 */
	public float getSurface() {
		return surface;
	}

	
	/**
	 * setter de l'attribut surface
	 * 
	 * @param surface : nouvelle valeur pour la surface
	 */
	public void setSurface(float surface) {
		this.surface = surface;
	}

	/**
	 * getter de l'attribut nombreChambres
	 * 
	 * @return l'attribut nombreChambres
	 */
	public int getNombreChambres() {
		return nombreChambres;
	}

	
	/**
	 * setter de l'attribut nombreChambres
	 * 
	 * @param nombreChambres : nouvelle valeur pour le nombre de chambres
	 */
	public void setNombreChambres(int nombreChambres) {
		this.nombreChambres = nombreChambres;
	}

	/**
	 * getter de l'attribut descriptionMeubles
	 * 
	 * @return l'attribut descriptionMeubles
	 */
	public String getDescriptionMeubles() {
		return descriptionMeubles;
	}

	
	/**
	 * setter de l'attribut descriptionMeubles
	 * 
	 * @param descriptionMeubles : nouvelle valeur pour la description des meubles
	 */
	public void setDescriptionMeubles(String descriptionMeubles) {
		this.descriptionMeubles = descriptionMeubles;
	}

	/**
	 * getter de l'attribut meuble
	 * 
	 * @return l'attribut meuble
	 */
	public boolean isMeuble() {
		return meuble;
	}


	/**
	 * getter de l'attribut balcon
	 * 
	 * @return l'attribut balcon
	 */
	public boolean aUnBalcon() {
		return balcon;
	}


	/**
	 * getter de l'attribut terrasse
	 * 
	 * @return l'attribut terrasse
	 */
	public boolean aUneTerrasse() {
		return terrasse;
	}

	/**
	 * getter de l'attribut surfaceTerrasse
	 * 
	 * @return l'attribut surfaceTerrasse
	 */
	public float getSurfaceTerrasse() {
		return surfaceTerrasse;
	}

	
	/**
	 * setter de l'attribut surfaceTerrasse
	 * 
	 * @param surfaceTerrasse : nouvelle valeur pour la surface de la terrasse
	 */
	public void setSurfaceTerrasse(float surfaceTerrasse) {
		this.surfaceTerrasse = surfaceTerrasse;
	}

	/**
	 * getter de l'attribut anneeConstruction
	 * 
	 * @return l'attribut anneeConstruction
	 */
	public int getAnneeConstruction() {
		return anneeConstruction;
	}

	
	/**
	 * setter de l'attribut anneeConstruction
	 * 
	 * @param anneeConstruction : nouvelle valeur pour l'annee de construction
	 */
	public void setAnneeConstruction(int anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}

	/**
	 * getter de l'attribut typeChauffage
	 * 
	 * @return l'attribut typeChauffage
	 */
	public String getTypeChauffage() {
		return typeChauffage;
	}

	
	/**
	 * setter de l'attribut typeChauffage
	 * 
	 * @param typeChauffage : nouvelle valeur pour le type de chauffage
	 */
	public void setTypeChauffage(String typeChauffage) {
		this.typeChauffage = typeChauffage;
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
	 * affiche les informations sur un bien immobilier
	 */
	public void display() {
		System.out.println("\nVille : " + ville + "\nArrondissement : " + arrondissement);
		System.out.print("\nNumero de rue : " + numRue + "\nType de rue : " + typeRue);
		System.out.print("\nNom de rue : " + nomRue + "\nType : " + type);
		System.out.print("\nResidence : " + residence + "\nSurface : " + surface + " m2");
		System.out.print("\nNombre de chambres : " + nombreChambres + "\nDescription des meubles : " + descriptionMeubles);
		System.out.print("\nMeubles : ");
		if (meuble == true)
			System.out.print("Oui");
		else
			System.out.print("Non");
		System.out.print("\nBalcon : ");
		if (balcon == true)
			System.out.print("Oui");
		else
			System.out.print("Non");
		System.out.print("\nTerrasse : ");
		if (terrasse == true) {
			System.out.print("Oui");
			System.out.println("Surface de la terrasse : " + surfaceTerrasse + " m2");
		}
		else
			System.out.print("Non");
		System.out.print("\nAnnee de construction : " + anneeConstruction + "\nType de chauffage : " + typeChauffage);
		System.out.println("\nLocataire (s) : ");
		if (listeLocataires.size() > 0) {
			for(int i=0; i<listeLocataires.size(); i++) {
				System.out.print("\nLocataire n°" + (i+1) + ": ");
				listeLocataires.get(i).display();
				
			}
		}
	}
	

}
