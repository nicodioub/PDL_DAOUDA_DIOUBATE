package model;
import java.util.*;

/**
 * Classe representant un bien immobilier
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Bien {
	
	/**
	 * Identifiant du bien
	 */
	protected int idBien;
	
	/**
	 * Ville du bien
	 */
	protected String ville;
	
	/**
	 * Arrondissement du bien
	 */
	protected int arrondissement;
	
	/**
	 * Numero de la rue du bien
	 */
	protected int numRue;
	
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
	 * Surface du balcon du bien
	 */
	protected float surfaceBalcon;
	
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
	 * Permet de savoir si le bien est une maison individuelle ou pas
	 */
	protected boolean maisonIndividuelle;
	
	/**
	 * Permet de savoir si le bien est un appartement ou pas
	 */
	protected boolean appartement;
	
	// Attributs propre a une maison individuelle
	
	/**
	 * Permet de savoir si la maison individuelle a une cave ou pas
	 */
	protected boolean cave;
	
	/**
	 * Permet de savoir si la maison individuelle a un sous-sol ou pas
	 */
	protected boolean sous_sol;
	
	/**
	 * Permet de savoir si la maison individuelle a une cour ou pas
	 */
	protected boolean cour;
	
	/**
	 * Permet de savoir si la maison individuelle a un jardin ou pas
	 */
	protected boolean jardin;
	
	/**
	 * Permet de savoir si la maison individuelle a un terrain ou pas
	 */
	protected boolean terrain;
	
	/**
	 * Surface de la cour de la maison individuelle
	 */
	protected float surfaceCour;
	
	/**
	 * Surface du jardin de la maison individuelle
	 */
	protected float surfaceJardin;
	
	/**
	 * Surface du terrain de la maison individuelle
	 */
	protected float surfaceTerrain;
	
	// Attributs propres a un appartement

	/**
	 * Permet de savoir si l'appartement a un escalier ou pas
	 */
	protected boolean escalier;
	
	/**
	 * Permet de savoir si l'appartement a un chauffage individuel ou pas
	 */
	protected boolean chauffageIndividuel;
	
	/**
	 * Etage auquel se situe l'appartement
	 */
	protected int etage;
	
	/**
	 * Numéro de l'appartement
	 */
	protected int numAppartement;
	
	/**
	 * Liste des locataires du bien
	 */
	protected ArrayList<Locataire> listeLocataires;
	
	
	/**
	 * Constructeur de la classe BienImmobilier
	 * 
	 * @param idBien : identifiant quelconque
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
	 * @param maisonIndividuelle : valeur true si le bien est une maison individuelle
	 * @param appartement : valeur true si le bien est un appartement
	 * @param cave : valeur true si la maison a une cave
	 * @param sous_sol : valeur true si la maison a un sous-sol
	 * @param cour : valeur true si la maison a une cour
	 * @param jardin : valeur true si la maison a un jardin
	 * @param terrain : valeur true si la maison a un terrain 
	 * @param surfaceCour : surface quelconque
	 * @param surfaceJardin : surface quelconque
	 * @param surfaceTerrain : surface quelconque
	 * @param surfaceBalcon : surface quelconque
	 * @param escalier : valeur true si l'appartement a un escalier
	 * @param chauffageIndividuel : valeur true si l'appartement a un chauffage individuelle
	 * @param etage : valeur d'etage quelconque
	 * @param numAppartement : valeur quelconque
	 */
	public Bien (int idBien, String ville, int arrondissement, int numRue, String typeRue, String nomRue,
			String type, String residence, float surface, int nombreChambres, String descriptionMeubles,
			boolean meuble, boolean balcon, boolean terrasse, float surfaceTerrasse, float surfaceBalcon, 
			int anneeConstruction,
			String typeChauffage, boolean appartement, boolean maisonIndividuelle) {
		if (appartement==true && maisonIndividuelle==false) {
			this.idBien = idBien;
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
			this.surfaceBalcon = surfaceBalcon;
			this.anneeConstruction = anneeConstruction;
			this.typeChauffage = typeChauffage;
			this.appartement = appartement;
			this.maisonIndividuelle = maisonIndividuelle;
		}
	}
	
	/**
	 * getter de l'attribut idBien
	 * 
	 * @return l'attribut idBien
	 */
	public int getIdBien () {
		return idBien;
	}
	
	/**
	 * Permet de modifier les attributs d'un appartement
	 */
	public void setAppartement(boolean escalier, boolean chauffageIndividuel, 
			                   int etage, int numAppartement) {
		if (appartement==false && maisonIndividuelle==true ) {
			this.escalier = escalier;
			this.chauffageIndividuel = chauffageIndividuel;
			this.etage = etage;
			this.numAppartement = numAppartement;
			cave = false;
			sous_sol = false;
			cour = false;
			jardin = false;
			terrain = false;
			surfaceCour = 0;
			surfaceJardin = 0;
			surfaceTerrain = 0;
		}
	}
	
	/**
	 * Permet de modifier les attributs d'une maison individuelle
	 */
	public void setMaisonIndividuelle(boolean cave, boolean sous_sol, boolean cour, 
			                          boolean jardin, boolean terrain, float surfaceCour, 
			                          float surfaceJardin, float surfaceTerrain) {
		this.cave = cave;
		this.sous_sol = sous_sol;
		this.cour = cour;
		this.jardin = jardin;
		this.terrain = terrain;
		this.surfaceCour = surfaceCour;
		this.surfaceJardin = surfaceJardin;
		this.surfaceTerrain = surfaceTerrain;
		escalier = false;
		chauffageIndividuel = false;
		etage = 0;
		numAppartement = 0;
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
	public int getArrondissement() {
		return arrondissement;
	}

	
	/**
	 * setter de l'attribut arrondissement
	 * 
	 * @param arrondissement : nouvelle valeur pour l'arrondissement
	 */
	public void setArrondissement(int arrondissement) {
		this.arrondissement = arrondissement;
	}

	/**
	 * getter de l'attribut numRue
	 * 
	 * @return l'attribut numRue
	 */
	public int getNumRue() {
		return numRue;
	}

	
	/**
	 * setter de l'attribut numRue
	 * 
	 * @param numRue : nouvelle valeur pour le numero de rue
	 */
	public void setNumRue(int numRue) {
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
	 * getter de l'attribut surfaceBalcon
	 * 
	 * @return l'attribut surfaceBalcon
	 */
	public float getSurfaceBalcon() {
		return surfaceBalcon;
	}

	
	/**
	 * setter de l'attribut surfaceBalcon
	 * 
	 * @param surfaceBalcon : nouvelle valeur pour la surface du balcon
	 */
	public void setSurfaceBalcon(float surfaceBalcon) {
		this.surfaceBalcon = surfaceBalcon;
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
	 * getter de l'attribut maisonIndividuelle
	 * 
	 * @return l'attribut maisonIndividuelle
	 */
	public boolean isMaisonIndividuelle() {
		return maisonIndividuelle;
	}
	
	/**
	 * getter de l'attribut appartement
	 * 
	 * @return l'attribut appartement
	 */
	public boolean isAppartement() {
		return appartement;
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
		System.out.println("Identifiant du bien : " + idBien);
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
		if (listeLocataires.size() > 0) {
			System.out.println("\nLocataire (s) : ");
			for(int i=0; i<listeLocataires.size(); i++) {
				System.out.print("\nLocataire n°" + (i+1) + ": ");
				listeLocataires.get(i).display();
				
			}
		}
		if (appartement==false && maisonIndividuelle==true ) {
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
		if (appartement==true && maisonIndividuelle==false ) {
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
	

}
