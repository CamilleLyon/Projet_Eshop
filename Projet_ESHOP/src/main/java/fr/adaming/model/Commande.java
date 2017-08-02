package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_co")
	private Long idCommande;

	private Date dateCommande;

	@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
	private List<Produit> listeProduits;

	private LigneCommande lcom;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id_cl")
	private Client client;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Long idCommande, Date dateCommande, List<Produit> listeProduits, LigneCommande lcom,
			Client client) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.listeProduits = listeProduits;
		this.lcom = lcom;
		this.client = client;
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	public LigneCommande getLcom() {
		return lcom;
	}

	public void setLcom(LigneCommande lcom) {
		this.lcom = lcom;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Commande [" + (idCommande != null ? "idCommande=" + idCommande + ", " : "")
				+ (dateCommande != null ? "dateCommande=" + dateCommande + ", " : "")
				+ (listeProduits != null ? "listeProduits=" + listeProduits + ", " : "")
				+ (lcom != null ? "lcom=" + lcom + ", " : "") + (client != null ? "client=" + client : "") + "]";
	}

}
