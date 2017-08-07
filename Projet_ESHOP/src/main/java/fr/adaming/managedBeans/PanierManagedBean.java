package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Panier;
import fr.adaming.service.IPanierService;

@ManagedBean(name = "paMB")
@RequestScoped
public class PanierManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Panier panier;
	private List<Panier> liste;

	@ManagedProperty(value = "#{panierServiceBean}")
	private IPanierService paService;

	public void setPaService(IPanierService paService) {
		this.paService = paService;
	}

	public PanierManagedBean() {
		super();
		this.panier = new Panier();
	}

	public void init() {

		this.liste = paService.getAll();
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public List<Panier> getListe() {
		return liste;
	}

	public void setListe(List<Panier> liste) {
		this.liste = liste;
	}

	public String ajouterPanier() {

		// appel de la méthode service
		paService.add(this.panier);

		this.liste = paService.getAll();
		return "index";
	}

	public String recherchePanier() {

		this.panier = paService.getById(this.panier.getIdPanier());

		return "recherche";
	}

	public String modifierPanier() {

		paService.update(this.panier);

		this.liste = paService.getAll();

		return "index";
	}

	public String supprimerPanier() {

		paService.delete(this.panier.getIdPanier());

		this.liste = paService.getAll();

		return "index";

	}
}
