import java.util.*;

/**
 * Classe representant un Bailleur (extension de personne)
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Bailleur extends Personne{
	
	/**
	 * Liste des baux associes a un bailleur
	 */
	private ArrayList<Bail> listeBaux;
	
	/**
	 * Constructeur de la classe Bailleur
	 * 
	 * @param unNom : nom quelconque
	 * @param unPrenom : prenom quelconque
	 * @param unEmail : email quelconque
	 * @param unNumero : numero quelconque
	 * @param listeBaux : liste de baux
	 */
	public Bailleur (String unNom, String unPrenom, String unEmail, String unNumero)
	{
		super(unNom, unPrenom, unEmail, unNumero);
		listeBaux  = new ArrayList<Bail>();
	}
	
	/**
	 * permet d'ajouter un bail à la liste
	 * 
	 * @param unBail : objet de type Bail
	 */
	public void addBail (Bail unBail) {
		listeBaux.add(unBail);
	}
	
}
