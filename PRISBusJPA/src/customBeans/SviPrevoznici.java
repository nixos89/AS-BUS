package customBeans;

import java.util.ArrayList;
import java.util.List;

import managers.PolasciManager;
import model.Prevoznik;

public class SviPrevoznici {

	private List<Prevoznik> sviPrevoznici = new ArrayList<>();
	
	public SviPrevoznici() {
		sviPrevoznici = PolasciManager.sviPrevoznici();
	}

	public List<Prevoznik> getSviPrevoznici() {
		return sviPrevoznici;
	}

	public void setSviPrevoznici(List<Prevoznik> sviPrevoznici) {
		this.sviPrevoznici = sviPrevoznici;
	}
	
	
}
