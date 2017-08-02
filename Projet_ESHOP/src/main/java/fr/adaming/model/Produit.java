package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produits")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_p")
	private Long idProduit;

	private String designation;
	private String description;
	private double prix;
	private int quantite;
	private boolean selectionne;
	private String photo;

	@ManyToOne
	@JoinColumn(name = "categorie_id", referencedColumnName = "id_ca")
	private Categorie categorie;

	@ManyToOne
	@JoinColumn(name = "commande_id", referencedColumnName = "id_co")
	private Commande commande;

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(Long idProduit, String designation, String description, double prix, int quantite,
			boolean selectionne, String photo, Categorie categorie, Commande commande) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
		this.categorie = categorie;
		this.commande = commande;
	}

	public Produit(String designation, String description, double prix, int quantite, boolean selectionne, String photo,
			Categorie categorie, Commande commande) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
		this.categorie = categorie;
		this.commande = commande;
	}

	public Produit(String designation, String description, double prix, int quantite, boolean selectionne,
			String photo) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Produit [" + (idProduit != null ? "idProduit=" + idProduit + ", " : "")
				+ (designation != null ? "designation=" + designation + ", " : "")
				+ (description != null ? "description=" + description + ", " : "") + "prix=" + prix + ", quantite="
				+ quantite + ", selectionne=" + selectionne + ", " + (photo != null ? "photo=" + photo + ", " : "")
				+ (categorie != null ? "categorie=" + categorie + ", " : "")
				+ (commande != null ? "commande=" + commande : "") + "]";
	}

}
