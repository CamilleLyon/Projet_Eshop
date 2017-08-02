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
@Table(name="lignecommandes")
public class LigneCommande implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_l")
	private Long idLigne;
	private int quantite;
	private Long prix;

	@ManyToOne
	@JoinColumn(name = "commande_id", referencedColumnName = "id_co")
	private Commande commande;

	@ManyToOne
	@JoinColumn(name = "produit_id", referencedColumnName = "id_p")
	private Produit produit;

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(Long idLigne, int quantite, Long prix, Commande commande, Produit produit) {
		super();
		this.idLigne = idLigne;
		this.quantite = quantite;
		this.prix = prix;
		this.commande = commande;
		this.produit = produit;
	}

	public LigneCommande(int quantite, Long prix, Commande commande, Produit produit) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.commande = commande;
		this.produit = produit;
	}

	public LigneCommande(int quantite, Long prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	public Long getIdLigne() {
		return idLigne;
	}

	public void setIdLigne(Long idLigne) {
		this.idLigne = idLigne;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "LigneCommande [" + (idLigne != null ? "idLigne=" + idLigne + ", " : "") + "quantite=" + quantite + ", "
				+ (prix != null ? "prix=" + prix + ", " : "") + (commande != null ? "commande=" + commande + ", " : "")
				+ (produit != null ? "produit=" + produit : "") + "]";
	}

}
