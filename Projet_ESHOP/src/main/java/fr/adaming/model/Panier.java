package fr.adaming.model;

public class Panier {
	
	private Produit produit;
	private int quantite;
	
	// Constructeur vide
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructeur attributs
	public Panier(Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}

	// Getter et setter
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	} 
	
	
	

}
