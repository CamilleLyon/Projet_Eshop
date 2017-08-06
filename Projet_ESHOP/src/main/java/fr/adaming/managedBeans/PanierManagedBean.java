package fr.adaming.managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Produit;

@ManagedBean(name="paMB")
@SessionScoped
public class PanierManagedBean {

    private ProduitManagedBean p = new ProduitManagedBean();
    
    public List<Produit> findAll(){
    	return this.p.getListe();
    }

    public String orderBy(Produit p){
    	return "panier";
    }
}


