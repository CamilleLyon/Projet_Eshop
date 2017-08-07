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

/**
 * Déclaration des attributs, getters/setters et constructeurs pour la classe
 * Client
 * 
 * @author Projet Camille
 *
 */
@Entity
@Table(name = "clients")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Attributs du Client
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	/**
	 * id du client
	 */
	private Long idClient;

	/**
	 * nom du client
	 */
	private String nomClient;
	/**
	 * adresse du client
	 */
	private String adresse;
	/**
	 * email du client
	 */
	private String email;
	/**
	 * telephone du cllient
	 */
	private String tel;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	/**
	 * list des commandes du client
	 */
	private List<Commande> listeCommandes;

	/**
	 * Constructeur vide
	 */
	public Client() {
		super();

	}

	/**
	 * Constructeur avec tous les arguments
	 * 
	 * @param idClient
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 * @param listeCommandes
	 */
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

	/**
	 * Constructeur sans id
	 * 
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 * @param listeCommandes
	 */
	public Client(String nomClient, String adresse, String email, String tel, List<Commande> listeCommandes) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.listeCommandes = listeCommandes;
	}

	/**
	 * Constructeur sans id ni liste de commandes
	 * 
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 */
	public Client(String nomClient, String adresse, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	/**
	 * Getters et setters des attibuts
	 * 
	 * @return
	 */
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
