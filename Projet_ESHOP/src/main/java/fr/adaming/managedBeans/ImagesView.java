package fr.adaming.managedBeans;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class ImagesView {

	private List<String> images;
	private String depotImgs = "C:/Users/INTI-0218/Pictures/";

	/**
	 *          * retourne une liste contenant les noms des images a afficher  
	 *        * @return          
	 */
	public List<String> getImages() {
		images = new ArrayList<String>();
		for (int i = 1; i < 12; i++) {
			String nameImage = i + ".jpg";
			images.add(nameImage);
		}
		return images;
	}

	public StreamedContent getImageItem() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (context.getRenderResponse()) {
				return new DefaultStreamedContent();
			} else {
				String name = context.getExternalContext().getRequestParameterMap().get("nameImage");
				File imgFile = new File(depotImgs + name);
				StreamedContent ds = new DefaultStreamedContent(new FileInputStream(imgFile), "image/jpg");
				return ds;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}