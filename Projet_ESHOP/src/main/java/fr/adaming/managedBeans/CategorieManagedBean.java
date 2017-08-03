package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "caMB")
@RequestScoped
public class CategorieManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Categorie categorie;
	private List<Categorie> liste;

	@ManagedProperty(value = "#{categorieServiceBean}")
	private ICategorieService caService;

	public void setCaService(ICategorieService caService) {
		this.caService = caService;
	}

	public CategorieManagedBean() {
		super();
		this.categorie = new Categorie();
	}

	public void init() {

		this.liste = caService.getAll();
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Categorie> getListe() {
		return liste;
	}

	public void setListe(List<Categorie> liste) {
		this.liste = liste;
	}

	// méthodes Métiers
	public String ajouterCategorie() {

		// appel de la méthode service
		caService.add(this.categorie);

		this.liste = caService.getAll();
		return "index";
	}

	public String rechercheCategorie() {

		this.categorie = caService.getByName(this.categorie.getNomCategorie());

		return "recherche";
	}

	public String modifierCategorie() {

		caService.update(this.categorie);

		this.liste = caService.getAll();

		return "index";
	}

	public String supprimerCategorie() {

		caService.delete(this.categorie.getIdCategorie());

		this.liste = caService.getAll();

		return "index";

	}

}
