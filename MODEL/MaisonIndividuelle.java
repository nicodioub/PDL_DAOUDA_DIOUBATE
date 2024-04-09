package model;
/**
 * Classe representant une maison individuelle (extension de BienImmobilier)
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class MaisonIndividuelle {
	
	/**
	 * Permet de savoir si la maison individuelle a une cave ou pas
	 */
	private boolean cave;
	
	/**
	 * Permet de savoir si la maison individuelle a un sous-sol ou pas
	 */
	private boolean sous_sol;
	
	/**
	 * Permet de savoir si la maison individuelle a une cour ou pas
	 */
	private boolean cour;
	
	/**
	 * Permet de savoir si la maison individuelle a un jardin ou pas
	 */
	private boolean jardin;
	
	/**
	 * Permet de savoir si la maison individuelle a un terrain ou pas
	 */
	private boolean terrain;
	
	/**
	 * Surface de la cour de la maison individuelle
	 */
	private float surfaceCour;
	
	/**
	 * Surface du jardin de la maison individuelle
	 */
	private float surfaceJardin;
	
	/**
	 * Surface du terrain de la maison individuelle
	 */
	private float surfaceTerrain;
	
	
	/**
	 * Constructeur de la classe MaisonIndividuelle
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
	 * @param cave : valeur true si la maison a une cave
	 * @param sous_sol : valeur true si la maison a un sous-sol
	 * @param cour : valeur true si la maison a une cour
	 * @param jardin : valeur true si la maison a un jardin
	 * @param terrain : valeur true si la maison a un terrain 
	 * @param surfaceCour : surface quelconque
	 * @param surfaceJardin : surface quelconque
	 * @param surfaceTerrain : surface quelconque
	 */
	public MaisonIndividuelle (String ville, String arrondissement, String numRue, String typeRue, String nomRue,
			String type, String residence, float surface, int nombreChambres, String descriptionMeubles,
			boolean meuble, boolean balcon, boolean terrasse, float surfaceTerrasse, int anneeConstruction,
			String typeChauffage, boolean cave, boolean sous_sol, boolean cour, boolean jardin, boolean terrain, float surfaceCour, float surfaceJardin, float surfaceTerrain)
	{
		// super(ville, arrondissement, numRue, typeRue, nomRue, type, residence, surface, nombreChambres, descriptionMeubles,
		// 	  meuble, balcon, terrasse, surfaceTerrasse, anneeConstruction, typeChauffage);
		this.cave = cave;
		this.sous_sol = sous_sol;
		this.cour = cour;
		this.jardin = jardin;
		this.terrain = terrain;
		this.surfaceCour = surfaceCour;
		this.surfaceJardin = surfaceJardin;
		this.surfaceTerrain = surfaceTerrain;
	}
	
	
	/**
	 * getter de l'attribut cave
	 * 
	 * @return l'attribut cave
	 */
	public boolean aUneCave() {
		return cave;
	}
	
	
	/**
	 * getter de l'attribut sous_sol
	 * 
	 * @return l'attribut sous_sol
	 */
	public boolean aUnSousSol() {
		return sous_sol;
	}
	
	
	/**
	 * getter de l'attribut cour
	 * 
	 * @return l'attribut cour
	 */
	public boolean aUneCour() {
		return cour;
	}
	
	
	/**
	 * getter de l'attribut jardin
	 * 
	 * @return l'attribut jardin
	 */
	public boolean aUnJardin() {
		return jardin;
	}
	
	
	/**
	 * getter de l'attribut terrain
	 * 
	 * @return l'attribut terrain
	 */
	public boolean aUnTerrain() {
		return terrain;
	}
	
	
	/**
	 * getter de l'attribut surfaceCour
	 * 
	 * @return l'attribut surfaceCour
	 */
	public float getSurfaceCour() {
		return surfaceCour;
	}
	
	
	/**
	 * getter de l'attribut surfaceJardin
	 * 
	 * @return l'attribut surfaceJardin
	 */
	public float getSurfaceJardin() {
		return surfaceJardin;
	}
	
	
	/**
	 * getter de l'attribut surfaceTerrain
	 * 
	 * @return l'attribut surfaceTerrain
	 */
	public float getSurfaceTerrain() {
		return surfaceTerrain;
	}
	
	/**
	 * setter de l'attribut surfaceCour
	 * 
	 * @param surfaceCour : nouvelle valeur pour la surface de la cour
	 */
	public void setSurfaceCour(float surfaceCour) {
		this.surfaceCour = surfaceCour;
	}
	
	/**
	 * setter de l'attribut surfaceJardin
	 * 
	 * @param surfaceJardin : nouvelle valeur pour la surface du jardin
	 */
	public void setSurfaceJardin(float surfaceJardin) {
		this.surfaceJardin = surfaceJardin;
	}
	
	/**
	 * setter de l'attribut surfaceTerrain
	 * 
	 * @param surfaceTerrain : nouvelle valeur pour la surface du terrain
	 */
	public void setSurfaceTerrain(float surfaceTerrain) {
		this.surfaceTerrain = surfaceTerrain;
	}
	
	
	/**
	 * affiche les informations sur une maison individuelle (bien immobilier)
	 */
	public void display() {
	// 	super.display();
		System.out.print("\nCave : ");
		if (cave == true)
			System.out.print("Oui");
		else
			System.out.print("Non");
		System.out.print("\nSous-sol : ");
		if (sous_sol == true)
			System.out.print("Oui");
		else
			System.out.print("Non");
		System.out.print("\nCour : ");
		if (cour == true) {
			System.out.print("Oui");
			System.out.println("Surface de la cour : " + surfaceCour + " m2");
		}
		else
			System.out.print("Non");
		System.out.print("\nJardin : ");
		if (jardin == true) {
			System.out.print("Oui");
			System.out.println("Surface du jardin : " + surfaceJardin + " m2");
		}
		else
			System.out.print("Non");
		System.out.print("\nTerrain : ");
		if (terrain == true) {
			System.out.print("Oui");
			System.out.println("Surface du terrain : " + surfaceTerrain + " m2");
		}
		else
			System.out.print("Non");
	}
	
	
}
