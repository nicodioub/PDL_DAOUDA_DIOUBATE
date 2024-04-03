/**
 * Classe representant un Employe (extension de personne)
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Employe extends Personne {
	
	/**
	 * Nom d'utilisateur d'un employe
	 */
	private String nomUtilisateur;
	
	/**
	 * Mot de passe d'un employe
	 */
	private String motDePasse;
	
	/**
	 * Constructeur de la classe Bailleur
	 * 
	 * @param unNom : nom quelconque
	 * @param unPrenom : prenom quelconque
	 * @param unEmail : email quelconque
	 * @param unNumero : numero quelconque
	 * @param nomUtilisateur : nom d'utilisateur quelconque
	 * @param motDePasse : mot de passe quelconque
	 */
	public Employe (String unNom, String unPrenom, String unEmail, String unNumero, String nomUtilisateur, String motDePasse)
	{
		super(unNom, unPrenom, unEmail, unNumero);
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
	}
	
	/**
	 * getter de l'attribut nomUtilisateur
	 * 
	 * @return l'attribut nomUtilisateur
	 */
	public String getNomUtilisateur( ) {
		return nomUtilisateur;
	}
	
	
	/**
	 * getter de l'attribut motDePasse
	 * 
	 * @return l'attribut motDePasse
	 */
	public String getMotDePasse( ) {
		return motDePasse;
	}
	
	/**
	 * setter de l'attribut nomUtilisateur
	 * 
	 * @param nomUtilisateur : le nouveau nom d'utilisateur
	 */
	public void setNomUtilisateur (String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	
	/**
	 * setter de l'attribut motDePasse
	 * 
	 * @param motDePasse : le nouveau nom d'utilisateur
	 */
	public void setMotDePasse (String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
