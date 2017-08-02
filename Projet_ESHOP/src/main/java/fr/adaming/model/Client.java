package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private Long idClient;

	private String nomClient;
	private String adresse;
	private String email;
	private String tel;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Commande> listeCommandes;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Long idClient, String nomClient, String adresse, String email, String tel,
			List<Commande> listeCommandes) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.listeCommandes = listeCommandes;
	}

	public Client(String nomClient, String adresse, String email, String tel, List<Commande> listeCommandes) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.listeCommandes = listeCommandes;
	}

	public Client(String nomClient, String adresse, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	@Override
	public String toString() {
		return "Client [" + (idClient != null ? "idClient=" + idClient + ", " : "")
				+ (nomClient != null ? "nomClient=" + nomClient + ", " : "")
				+ (adresse != null ? "adresse=" + adresse + ", " : "") + (email != null ? "email=" + email + ", " : "")
				+ (tel != null ? "tel=" + tel + ", " : "")
				+ (listeCommandes != null ? "listeCommandes=" + listeCommandes : "") + "]";
	}

}
