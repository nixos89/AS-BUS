package customBeans;

import java.util.Map;

import managers.PrevoznikManager;
import model.Prevoznik;

public class NajboljeOcenjeniPrevoznici {

	private Map<Prevoznik, Double> najboljeOcenjeniPrevoznici;

	public NajboljeOcenjeniPrevoznici() {		
		najboljeOcenjeniPrevoznici = PrevoznikManager.najboljeOcenjeniPrevoznici();
	} 

	public Map<Prevoznik, Double> getNajboljeOcenjeniPrevoznici() {
		return najboljeOcenjeniPrevoznici;
	}

	public void setNajboljeOcenjeniPrevoznici(Map<Prevoznik, Double> najboljeOcenjeniPrevoznici) {
		this.najboljeOcenjeniPrevoznici = najboljeOcenjeniPrevoznici;
	}
	
	
}
