package model;
/**
 * Classe representant une personne
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Personne {
	
	/**
	 * Nom d'une personne
	 */
	protected String nom;
	
	/**
	 * Prenom(s) d'une personne
	 */
	protected String prenom;
	
	/**
	 * Adresse email d'une personne
	 */
	protected String email;
	
	/**
	 * Numero de telephone d'une personne
	 */
	protected String numero;
	
	
	/**
	 * Constructeur de la classe Personne
	 * 
	 * @param unNom : nom quelconque
	 * @param unPrenom : prenom quelconque
	 * @param unEmail : email quelconque
	 * @param unNumero : numero quelconque
	 */
	public Personne (String unNom, String unPrenom, String unEmail, String unNumero)
	{
		nom = unNom;
		prenom = unPrenom;
		email = unEmail;
		numero = unNumero;
	}

	/**
	 * getter de l'attribut nom
	 * 
	 * @return l'attribut nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * getter de l'attribut prenom
	 * 
	 * @return l'attribut prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * getter de l'attribut email
	 * 
	 * @return l'attribut email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * getter de l'attribut numero
	 * 
	 * @return l'attribut numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * setter de l'attribut numero
	 * 
	 * @param numero : nouvelle valeur pour le numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * setter de l'attribut email
	 * 
	 * @param email : nouvelle valeur pour l'email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * setter de l'attribut nom
	 * 
	 * @param nom : nouvelle valeur pour le nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * setter de l'attribut prenom
	 * 
	 * @param prenom : nouvelle valeur pour le prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
		
	/**
	 * affiche les informations sur une personne
	 */
	public void display() {
		System.out.print("Nom : " + nom + "\nPrenom : " + prenom);
		System.out.println("Email : ");
		if (email == null)
			System.out.print("Pas d'adresse email enregistree");
		else
			System.out.print(email);
		System.out.println("Numero de telephone : ");
		if (numero == null)
			System.out.print("Pas de numero enregistre");
		else
			System.out.print(numero);
	}
}
