package fr.adaming.view;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="viewMB")
public class MegaMenuView {
	
	 private String orientation = "horizontal";
	 
	    public String getOrientation() {
	        return orientation;
	    }
	 
	    public void setOrientation(String orientation) {
	        this.orientation = orientation;
	    }
	}
