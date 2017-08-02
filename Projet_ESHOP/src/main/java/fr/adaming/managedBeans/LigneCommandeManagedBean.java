package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.LigneCommande;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name = "liMB")
@RequestScoped
public class LigneCommandeManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// attributs utilisés par la vue
	private LigneCommande ligneCommande;
	private List<LigneCommande> liste;

	@ManagedProperty(value = "#{lignecommandeServiceBean}")
	private ILigneCommandeService liService;

	public void setLiService(ILigneCommandeService liService) {
		this.liService = liService;
	}

	public LigneCommandeManagedBean() {
		super();
		this.ligneCommande = new LigneCommande();
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public List<LigneCommande> getListe() {
		return liste;
	}

	public void setListe(List<LigneCommande> liste) {
		this.liste = liste;
	}

	// méthodes Métiers
	public String ajouterLigneCommande() {

		// appel de la méthode service
		liService.add(this.ligneCommande);

		this.liste = liService.getAll();
		return "index";
	}

	public String rechercheLigneCommande() {

		this.ligneCommande = liService.getById(this.ligneCommande.getIdLigne());

		return "recherche";
	}

	public String modifierLigneCommande() {

		liService.update(this.ligneCommande);

		this.liste = liService.getAll();

		return "index";
	}

	public String supprimerLigneCommande() {

		liService.delete(this.ligneCommande.getIdLigne());

		this.liste = liService.getAll();

		return "index";

	}
}
