package managers;

import java.util.Date;

import javax.persistence.EntityManager;

import model.Polazak;
import model.Prodaja;
import model.Putnik;
import model.Radnik;

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
				putnik.setBrkarata(putnik.getBrkarata()+1);					
				polazak.setBrprodatihkarata(ukKarata);		
				em.merge(putnik);
				em.merge(polazak);
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
	}//rezervisiKartu
	
	public Prodaja prodajKartu(int idpolaska, int brkarata, Radnik radnik){		
		try {
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Polazak polazak= em.find(Polazak.class, idpolaska);				
			int brojMesta=polazak.getPrevoznik().getBrmesta();
			int brprodatihkarata=polazak.getBrprodatihkarata();
			int ukKarata=brprodatihkarata + brkarata;
			if( ukKarata <= brojMesta){	
				Prodaja prodaja = new Prodaja();
				prodaja.setDatumprodaje(new Date());
				prodaja.setPolazak(polazak);
				prodaja.setRadnik(radnik);
				em.persist(prodaja);
				em.getTransaction().commit();
				em.close();
				return prodaja;
			}
			em.close();
			return null;
		} catch (Exception e) {			
			e.printStackTrace();
			return null;			
		}		
	}//prodajKartu
	
}
