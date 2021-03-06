package fr.adaming.managedBeans;

/**
 * M�thodes managed bean !
 * @author Projet Camille
 */
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

	// attributs utilis�s par la vue
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

	@PostConstruct
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

	// m�thodes M�tiers
	public String ajouterClient() {

		// appel de la m�thode service
		clService.add(this.client);

		this.liste = clService.getAll();
		return "ajoutClient";
	}

	public String rechercheClient() {

		this.client = clService.getByName(this.client.getNomClient());

		return "rechercheClient";
	}

	public String modifierClient() {

		clService.update(this.client);

		this.liste = clService.getAll();

		return "modificationClient";
	}

	public String supprimerClient() {

		clService.delete(this.client.getIdClient());

		this.liste = clService.getAll();

		return "suppressionClient";

	}

}
