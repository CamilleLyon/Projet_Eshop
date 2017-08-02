package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@ManagedBean(name = "clMB")
@RequestScoped
public class ClientManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// attributs utilisés par la vue
	private Client client;
	private List<Client> liste;

	@ManagedProperty(value = "#{clientServiceBean}")
	private IClientService clService;

	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	public ClientManagedBean() {
		super();

		this.client = new Client();
	}

	// @PostConstruct // cette annotation veut dire que la méthode sera exécutée
	// après l'instanciation du managed bean
	public void init() {

		this.liste = clService.getAll();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListe() {
		return liste;
	}

	public void setListe(List<Client> liste) {
		this.liste = liste;
	}

	// méthodes Métiers
	public String ajouterClient() {

		// appel de la méthode service
		clService.add(this.client);

		this.liste = clService.getAll();
		return "index";
	}

	public String rechercheClient() {

		this.client = clService.getByName(this.client.getNomClient());

		return "recherche";
	}

	public String modifierClient() {

		clService.update(this.client);

		this.liste = clService.getAll();

		return "index";
	}

	public String supprimerClient() {

		clService.delete(this.client.getIdClient());

		this.liste = clService.getAll();

		return "index";

	}

}
