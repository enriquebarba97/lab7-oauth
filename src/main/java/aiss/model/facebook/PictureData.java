package aiss.model.facebook;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown=true)
public class PictureData implements Serializable{
	private Boolean is_silhouette;
	private String url;
	public Boolean getIs_silhouette() {
		return is_silhouette;
	}
	public void setIs_silhouette(Boolean is_silhouette) {
		this.is_silhouette = is_silhouette;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
