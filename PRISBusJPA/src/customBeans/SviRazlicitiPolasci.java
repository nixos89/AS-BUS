package customBeans;

import java.util.ArrayList;
import java.util.List;

import managers.PolasciManager;
import model.Grad;

public class SviRazlicitiPolasci {

	private List<Grad> sviRazlicitiPolasci = new ArrayList<Grad>();
	
	public SviRazlicitiPolasci(){
		sviRazlicitiPolasci = new PolasciManager().sviRazlicitiPolasci();
	}

	public List<Grad> getSviRazlicitiPolasci() {
		return sviRazlicitiPolasci;
	}

	public void setSviRazlicitiPolasci(List<Grad> sviRazlicitiPolasci) {
		this.sviRazlicitiPolasci = sviRazlicitiPolasci;
	}
	
	
}
