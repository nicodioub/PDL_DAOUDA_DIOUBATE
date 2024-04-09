package model;
/**
 * Classe representant un Employe 
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Employe {
	
	/**
	 * Identifiant de l'employe
	 */
	protected int idEmploye;
	
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
	 * @param idEmploye : identifiant quelconque
	 * @param nomUtilisateur : nom d'utilisateur quelconque
	 * @param motDePasse : mot de passe quelconque
	 */
	public Employe (int idEmploye, String nomUtilisateur, String motDePasse)
	{
		this.idEmploye = idEmploye;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
	}
	
	/**
	 * getter de l'attribut idEmploye
	 * 
	 * @return l'attribut idEmploye
	 */
	public int getIdEmploye () {
		return idEmploye;
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
