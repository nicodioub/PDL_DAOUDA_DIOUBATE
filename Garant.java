/**
 * Classe representant un Garant (extension de personne)
 * 
 * @author DAOUDA Ilyas + DIOUBATE Nicolas
 * @version 1.0
 */
public class Garant extends Personne {
	
	/**
	 * Adresse du garant
	 */
	private String adresse;
	
	/**
	 * Constructeur de la classe Garant
	 * 
	 * @param unNom : nom quelconque
	 * @param unPrenom : prenom quelconque
	 * @param adresse : adresse quelconque
	 */
	public Garant (String unNom, String unPrenom, String adresse)
	{
		super(unNom, unPrenom, null, null);
		this.adresse = adresse;
	}
	
	
	/**
	 * getter de l'attribut adresse
	 * 
	 * @return l'attribut adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * setter de l'attribut adresse
	 * 
	 * @param adresse : nouvelle valeur pour l'adresse du garant
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * affiche les informations sur un garant (personne)
	 */
	@Override
	public void display() {
		super.display();
		System.out.println("Adresse : ");
		if (adresse == null)
			System.out.print("Pas d'adresse enregistree");
		else
			System.out.print(adresse);
	}

}
