package managers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	public double getDnevniProfit(Date datum,Radnik radnik){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			TypedQuery<Prodaja> upit = em.createQuery("SELECT p FROM Prodaja p WHERE p.datumprodaje = :datum AND p.radnik = :radnik",Prodaja.class)
					.setParameter("datum", datum)
					.setParameter("radnik", radnik);
			double dnevniProfit = 0.0;
			List<Prodaja> dnevniPrihodRadnika = upit.getResultList();
			for(Prodaja p: dnevniPrihodRadnika){
				dnevniProfit+=p.getIznos();
			}			
			return dnevniProfit;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}//getDnevniProfit
	
	public static void main(String[] args) {
		RezervacijaKarteManager rkm = new RezervacijaKarteManager();
		EntityManager em = JPAUtils.getEntityManager();
		Radnik r = em.find(Radnik.class, 1);
		Date datumProdaje = null;
		double dProfit=0.0;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			datumProdaje = sdf.parse("2017-05-23");
			dProfit = rkm.getDnevniProfit(datumProdaje, r);
			System.out.println("Radnik "+r.getIme()+" "+r.getPrezime()+" je dana "+datumProdaje+" ostvarila prihod od "+dProfit+" dinara!" );
		}catch(Exception e){
			e.printStackTrace();
		}
//		r.addProdaja(em.find(Prodaja.class, 1));
//		for(Prodaja p: r.getProdajas()){
//			System.out.println(p.getPolazak().getIdpolaska()+",radnik:"+p.getRadnik().getIme());
//		}
	}
	
}
