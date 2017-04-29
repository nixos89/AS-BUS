package customBeans;

import java.util.ArrayList;
import java.util.List;

import managers.PolasciManager;
import model.Grad;

public class SviGradovi {

	private List<Grad> sviGradovi= new ArrayList<>();

	public SviGradovi() {		
			sviGradovi=PolasciManager.sviGradovi();		
	}

	public List<Grad> getSviGradovi() {
		return sviGradovi;
	}

	public void setSviGradovi(List<Grad> sviGradovi) {
		this.sviGradovi = sviGradovi;
	}
	
	
	
	
	
}