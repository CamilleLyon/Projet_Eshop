package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Commande;
import fr.adaming.service.ICommandeService;

@ManagedBean(name = "coMB")
@RequestScoped
public class CommandeManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	// attributs utilisés par la vue
		private Commande commande;
		private List<Commande> liste;

		@ManagedProperty(value = "#{commandeServiceBean}")
		private ICommandeService coService;

		public void setCoService(ICommandeService coService) {
			this.coService = coService;
		}

		public CommandeManagedBean() {
			super();
			this.commande=new Commande();
		}
		public void init() {

			this.liste = coService.getAll();
		}

		public Commande getCommande() {
			return commande;
		}

		public void setCommande(Commande commande) {
			this.commande = commande;
		}

		public List<Commande> getListe() {
			return liste;
		}

		public void setListe(List<Commande> liste) {
			this.liste = liste;
		}
		
		// méthodes Métiers
		public String ajouterCommande() {

			// appel de la méthode service
			coService.add(this.commande);

			this.liste = coService.getAll();
			return "index";
		}

		public String rechercheCommande() {

			this.commande = coService.getById(this.commande.getIdCommande());

			return "recherche";
		}

		public String modifierCommande() {

			coService.update(this.commande);

			this.liste = coService.getAll();

			return "index";
		}

		public String supprimerCommande() {

			coService.delete(this.commande.getIdCommande());

			this.liste = coService.getAll();

			return "index";

		}
}
