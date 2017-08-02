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
@RequestScoped // le conteneur web va instancier un nouveau � chaque fois que je
				// quitte la page
public class ClientManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// attributs utilis�s par la vue
	private Client client;
	private List<Client> liste;

	@ManagedProperty(value = "#{employeServiceBean}")
	private IClientService clService;

	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	public ClientManagedBean() {
		super();

		this.client = new Client();
	}

	@PostConstruct // cette annotation veut dire que la m�thode sera ex�cut�e
	// apr�s l'instanciation du managed bean
	public void init() {

		this.liste = clService.getAllClient();

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
			clService.addClient(this.client);

			this.liste = clService.getAllClient();
			return "index";
		}
}
