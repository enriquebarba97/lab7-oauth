
package aiss.model.facebook;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Paging implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = -7307874555330985480L;
	private Cursors cursors;
	public Cursors getCursors() {
		return cursors;
	}
	public void setCursors(Cursors cursors) {
		this.cursors = cursors;
	}
	}
