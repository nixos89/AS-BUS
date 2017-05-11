package managers;

import javax.persistence.EntityManager;

import model.Polazak;
import model.Putnik;

public class RezervacijaKarteManager {

	public boolean rezervisiKartu(int idpolaska, int brkarata, Putnik putnik){		
		try {
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Polazak polazak= em.find(Polazak.class, idpolaska);	
			
			int brojMesta=polazak.getPrevoznik().getBrmesta();
			int brprodatihkarata=polazak.getBrprodatihkarata();
			int ukKarata=brprodatihkarata + brkarata;
			if( ukKarata <= brojMesta){
				System.out.println("usao u if");
				polazak.setBrprodatihkarata(ukKarata);
				polazak.getPutniks().add(putnik);				
				putnik.getPolazaks().add(polazak);
				em.merge(polazak);
				em.merge(putnik);
				em.getTransaction().commit();
				em.close();
				return true;
			}
			em.close();
			return false;
		} catch (Exception e) {			
			e.printStackTrace();
			return false;			
		}		
	}
}
