package customBeans;

import java.util.ArrayList;
import java.util.List;

import managers.JPAUtils;
import managers.PolasciManager;
import model.Polazak;

public class SviPolasci {
	
	private List<Polazak> sviPolasci = new ArrayList<Polazak>();
	
	public SviPolasci(){
		try{
			sviPolasci = new PolasciManager().sviPolasci(JPAUtils.getEntityManager());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Polazak> getSviPolasci() {
		return sviPolasci;
	}

	public void setSviPolasci(List<Polazak> sviPolasci) {
		this.sviPolasci = sviPolasci;
	}
	
	
}
