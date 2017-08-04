package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "prMB")
@RequestScoped
public class ProduitManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produit produit;
	private List<Produit> liste;

	@ManagedProperty(value = "#{produitServiceBean}")
	private IProduitService pService;

	public void setpService(IProduitService pService) {
		this.pService = pService;
	}

	public ProduitManagedBean() {
		super();
		this.produit = new Produit();
	}

	@PostConstruct
	public void init() {

		this.liste = pService.getAll();
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Produit> getListe() {
		return liste;
	}

	public void setListe(List<Produit> liste) {
		this.liste = liste;
	}

	// méthodes Métiers
	public String ajouterProduit() {

		// appel de la méthode service
		pService.add(this.produit);

		this.liste = pService.getAll();
		return "index";
	}

	public String rechercheProduit() {

		this.produit = pService.getByName(this.produit.getDesignation());

		return "recherche";
	}

	public String modifierProduit() {

		pService.update(this.produit);

		this.liste = pService.getAll();

		return "index";
	}

	public String supprimerProduit() {

		pService.delete(this.produit.getIdProduit());

		this.liste = pService.getAll();

		return "index";

	}

}