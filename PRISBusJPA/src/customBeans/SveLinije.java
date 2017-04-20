package customBeans;

import java.util.ArrayList;
import java.util.List;

import managers.PolasciManager;
import model.Linija;

public class SveLinije {

	private List<Linija> sveLinije = new ArrayList<>();
	
	public SveLinije(){
		sveLinije= PolasciManager.sveLinije();
	}

	public List<Linija> getSveLinije() {
		return sveLinije;
	}

	public void setSveLinije(List<Linija> sveLinije) {
		this.sveLinije = sveLinije;
	}
	
	
}
