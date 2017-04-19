package customBeans;

import java.util.ArrayList;
import java.util.List;

import managers.JPAUtils;
import managers.PolasciManager;
import model.Vrstapolaska;

public class SveVrstePolazaka {

	private List<Vrstapolaska> sveVrstePolazaka = new ArrayList<Vrstapolaska>();
	
	public SveVrstePolazaka(){
		try{
			sveVrstePolazaka = new PolasciManager().sveVrstePolazaka(JPAUtils.getEntityManager());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Vrstapolaska> getSveVrstePolazaka() {
		return sveVrstePolazaka;
	}

	public void setSveVrstePolazaka(List<Vrstapolaska> sveVrstePolazaka) {
		this.sveVrstePolazaka = sveVrstePolazaka;
	}
	
	
}
