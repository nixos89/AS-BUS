package managers;

import java.util.Date;
import java.util.Iterator;

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
	
	public Prodaja prodajKartu(int idpolaska, int brkarata, int cenaKarte, Radnik radnik){		
		try {
			EntityManager em = JPAUtils.getEntityManager();			
			Polazak polazak= em.find(Polazak.class, idpolaska);				
			int brojMesta=polazak.getPrevoznik().getBrmesta();
			int brprodatihkarata=polazak.getBrprodatihkarata();
			int ukKarata=brprodatihkarata + brkarata;
			if( ukKarata <= brojMesta){	
				em.getTransaction().begin();
				Prodaja prodaja = new Prodaja();
				prodaja.setDatumprodaje(new Date());				
				prodaja.setPolazak(polazak);
				prodaja.setRadnik(radnik);
				prodaja.setIznos(cenaKarte*brkarata);
				polazak.setBrprodatihkarata(ukKarata);
				em.persist(prodaja);		
				radnik.addProdaja(prodaja);
				polazak.addProdaja(prodaja);
				em.merge(radnik);				
				em.getTransaction().commit();;
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
	
	public static void main(String[] args) {
		RegistracijaManager rm = new RegistracijaManager();
		EntityManager em = JPAUtils.getEntityManager();	
		Radnik r = em.find(Radnik.class, 1);
		r.addProdaja(em.find(Prodaja.class, 1));
		for(Prodaja p: r.getProdajas()){
			System.out.println(p.getPolazak().getIdpolaska()+",radnik:"+p.getRadnik().getIme());
		}
	}
	
}
