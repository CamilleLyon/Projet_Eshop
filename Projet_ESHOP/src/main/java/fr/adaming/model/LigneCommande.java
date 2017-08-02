package fr.adaming.model;

public class LigneCommande {

	private Long idLigne;
	private int quantite;
	private Long prix;

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(Long idLigne, int quatite, Long prix) {
		super();
		this.idLigne = idLigne;
		this.quantite = quatite;
		this.prix = prix;
	}

	public LigneCommande(int quatite, Long prix) {
		super();
		this.quantite = quatite;
		this.prix = prix;
	}

	public Long getIdLigne() {
		return idLigne;
	}

	public void setIdLigne(Long idLigne) {
		this.idLigne = idLigne;
	}

	public int getQuatite() {
		return quantite;
	}

	public void setQuatite(int quatite) {
		this.quantite = quatite;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneCommande [quatite=" + quantite + ", prix=" + prix + "]";
	}

}
