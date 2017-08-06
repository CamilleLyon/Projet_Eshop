package fr.adaming.managedBeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class viewMB {

	private String orientation = "horizontal";

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
}
