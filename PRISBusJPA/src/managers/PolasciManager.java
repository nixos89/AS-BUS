package managers;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Grad;
import model.Karta;
import model.Linija;
import model.Polazak;
import model.Prevoznik;
import model.Putnik;
import model.Vrstapolaska;

public class PolasciManager {	
	
	public Vrstapolaska sacuvajVrstuPolaska(String vrsta){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();			
			Vrstapolaska vp = new Vrstapolaska();
			vp.setVrsta(vrsta);
			em.persist(vp);
			em.getTransaction().commit();
			em.close();
			return vp;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}//sacuvajVrstuPolaska
	
	
	public Vrstapolaska nazivVrstePolaska(String nazivVrste){
		try {
			EntityManager em = JPAUtils.getEntityManager();
			Query upit = em.createQuery("SELECT vp FROM Vrstapolaska vp WHERE vp.vrsta LIKE :nazivVrste").setParameter("nazivVrste", nazivVrste);
			Vrstapolaska vp = (Vrstapolaska)upit.getSingleResult();
			return vp;
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}//nazivVrstePolaska
	
	
	public List<Vrstapolaska> sveVrstePolazaka(EntityManager em){
		try {
			TypedQuery<Vrstapolaska> upit = em.createQuery("SELECT vp FROM Vrstapolaska vp", Vrstapolaska.class);
			List<Vrstapolaska> sveVrste = upit.getResultList();
			return sveVrste;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//sveVrstePolazaka
	
	
	public List<Polazak> sviPolasci(EntityManager em){
		try {
			TypedQuery<Polazak> upit = em.createQuery("SELECT p FROM Polazak p", Polazak.class);
			List<Polazak> sviPolasci = upit.getResultList();
			return sviPolasci;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//sveVrstePolazaka
	
	/* Ispisuje SAMO one gradove za koje POSTOJE polasci */
	public List<Grad> sviRazlicitiPolasci(){			
		try {
			EntityManager em = JPAUtils.getEntityManager();	
			TypedQuery<Grad> upit = em.createQuery("SELECT DISTINCT(p.linija.grad) FROM Polazak p join p.linija l join l.grad g",Grad.class);			
			List<Grad> sviPolasci = upit.getResultList();
			return sviPolasci;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}//sviRazlicitiPolasci
	
//	/* Daje SVE polaske koje je registrovani korisnik selektovao filtrirajuci DESTINACIJU, DATUM POLASKA i TIP KARTE!!! */
//	public List<Polazak> getTrazeniPolasci(int idGrad,Date datumPolaska,String vrstaKarte){
//		try{
//			EntityManager em = JPAUtils.getEntityManager();
//			TypedQuery<Polazak> upit = 
//				em.createQuery("SELECT p FROM Polazak p JOIN FETCH p.kartas k WHERE k.tipkarte "
//						+ "LIKE :vrstaKarte AND p.vremepolaska = :datumPolaska", Polazak.class);
//			upit.setParameter("idGrad", idGrad);
//			upit.setParameter("datumPolaska", datumPolaska);
//			upit.setParameter("vrstaKarte", vrstaKarte);
//			List<Polazak> polasci = upit.getResultList();
//			return polasci;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}		
//	}//getTrazeniPolasci
	
	/* Daje SVE polaske koje je registrovani korisnik selektovao filtrirajuci DESTINACIJU, DATUM POLASKA i TIP KARTE!!! */
	public List<Polazak> getTrazeniPolasci(int idGrad,Date datumPolaska,String vrstaKarte){
		try{
			System.out.println(idGrad);
			System.out.println(datumPolaska);
			System.out.println(vrstaKarte);
			EntityManager em = JPAUtils.getEntityManager();
			TypedQuery<Polazak> upit = 
				em.createQuery("SELECT p FROM Polazak p JOIN FETCH p.kartas k join p.linija l join l.grad g"
						+ " WHERE g.idgrad=:idGrad AND k.tipkarte "
						+ "LIKE :vrstaKarte AND l.datumpolaska = :datumPolaska", Polazak.class);

			upit.setParameter("idGrad", idGrad);
			upit.setParameter("datumPolaska", datumPolaska);
			upit.setParameter("vrstaKarte", vrstaKarte);
			List<Polazak> polasci = upit.getResultList();
			System.out.println("dodao sam getResultList() ...");			
			return polasci;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}//getTrazeniPolasci
	
	public static boolean sacuvajPrevoznika(String naziv, int brMesta){
		try {
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Prevoznik p = new Prevoznik();
			p.setNaziv(naziv);
			p.setBrmesta(brMesta);
			em.persist(p);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}//sacuvajPrevoznika
	
	
	public static boolean sacuvajGrad(String naziv){
		try {
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Grad g = new Grad();
			g.setNaziv(naziv);
			em.persist(g);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}//sacuvajGrad
	
	public static boolean sacuvajLinuju(int idGrad,String nazivLinije, Date datum){
		try {
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Linija l = new Linija();
			Grad g = em.find(Grad.class, idGrad);
			l.setNazivlinije(nazivLinije);
			l.setGrad(g);
			l.setDatumpolaska(datum);
			em.persist(l);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}//sacuvajLinuju
	
	public Polazak sacuvajPolazak(int idPrevoznika,int idLinije,int idVrstePolaska,Date datumP){
		try{
			System.out.println("pozvan manager");
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Polazak p = new Polazak();
			p.setPrevoznik(em.find(Prevoznik.class, idPrevoznika));
			p.setLinija(em.find(Linija.class, idLinije));
			p.setVrstapolaska(em.find(Vrstapolaska.class, idVrstePolaska));
			p.setVremepolaska(datumP);
			em.persist(p);
			em.getTransaction().commit();
			em.close();
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}//sacuvajPolazak
	
	public static List<Grad> sviGradovi(){
		try {
			EntityManager em =JPAUtils.getEntityManager();
			TypedQuery<Grad> upit = em.createQuery("SELECT g from Grad g",Grad.class);
			List<Grad> gradovi = upit.getResultList();
			return gradovi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//sviGradovi
	
	public static List<Prevoznik> sviPrevoznici(){
		try {
			EntityManager em =JPAUtils.getEntityManager();
			TypedQuery<Prevoznik> upit = em.createQuery("SELECT p from Prevoznik p",Prevoznik.class);
			List<Prevoznik> prevoznici = upit.getResultList();
			return prevoznici;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static List<Linija> sveLinije(){
		try {
			EntityManager em =JPAUtils.getEntityManager();
			TypedQuery<Linija> upit = em.createQuery("SELECT l from Linija l",Linija.class);
			List<Linija> linije = upit.getResultList();
			return linije;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//sveLinije
	
	public List<Polazak> vratiPolaskeZaDatumIDestinaciju(int idGrad, Date datum){
		try {
			EntityManager em = JPAUtils.getEntityManager();			
			TypedQuery<Polazak> q = em.createQuery("select p from Polazak p join p.linija l join l.grad g where l.datumpolaska=:datum and g.idgrad=:idGrad",Polazak.class);
			q.setParameter("idGrad", idGrad);
			q.setParameter("datum", datum);
			List<Polazak> polasci = q.getResultList();
			return polasci;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}//vratiPolaskeZaDatumIDestinaciju
	
	public boolean snimiCenuKarte(int cena,String tipKarte,int idPolaska){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();	
			Karta k = new Karta();
			k.setCenakarte(cena);
			k.setTipkarte(tipKarte);
			k.setPolazak(em.find(Polazak.class, idPolaska));	
			Polazak p = em.find(Polazak.class, idPolaska);
			p.getKartas().add(k);
			em.persist(k);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}//snimiCenuKarte
	
	/* Rezervacija karte za odredjeni POLAZAK, KARTU i tipKarte (koji odredjuje i njenu CENU)
	 * i vraca logicku vrednost!!! */
	public boolean rezervacijaMesta(int idPolaska, Putnik putnik,int brKarata){
		try{
			System.out.println("usao sam u rezervacijaMesta metod!");
			EntityManager em  = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Polazak pol = em.find(Polazak.class, idPolaska);
			int brProdatihKarata = pol.getBrprodatihkarata();
			int noviBrProdatihKarata = brKarata+brProdatihKarata;
			pol.setBrprodatihkarata(noviBrProdatihKarata);
			pol.getPutniks().add(putnik);
			System.out.println("dosao do putnik.getPolazaks().add(pol);...");
			putnik.getPolazaks().add(pol);
			System.out.println("...prosao do putnik.getPolazaks().add(pol);");
			em.merge(pol);
			em.merge(putnik);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		PolasciManager pm = new PolasciManager();		
//		try{
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date datumPolaska  = sdf.parse("2017-04-21");
//			List<Polazak> trazeniPolasci = pm.getTrazeniPolasci(2, datumPolaska, "Penzionerska");
//			if(trazeniPolasci.isEmpty())
//				System.out.println("Prazna lista TRAZENIH polazaka!");
//			else{
//				for(Polazak p : trazeniPolasci){
//					System.out.println("Prevoznik: "+p.getPrevoznik().getNaziv()+", destinacija: "+p.getLinija().getGrad().getNaziv()+", vreme: "+p.getVremepolaska()+
//							", vrsta polaska: "+p.getVrstapolaska().getVrsta()+", cena karte: ");
//				}
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		try{
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date datumPolaska  = sdf.parse("2017-04-21");
//			List<Polazak> trazeniPolasci = pm.getTrazeniPolasci(2, datumPolaska, "Penzionerska");
//			for(Polazak p : trazeniPolasci){
//				System.out.println("Prevoznik: "+p.getPrevoznik()+", vreme: "+p.getVremepolaska()+
//						", vrsta polaska: "+p.getVrstapolaska().getVrsta()+", broj karata " 
//						+ p.getBrprodatihkarata());
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		List<Grad> polasci = pm.sviRazlicitiPolasci();
//		for(Grad p: polasci){		
//			System.out.println(p.getNaziv());
//		}				
//		System.out.println(p.getLinija().getGrad().getNaziv());			
//		List<Linija> gradovi = sveLinije();
//		for(Linija g: gradovi)
//			System.out.println(g.getNazivlinije());		
//		Vrstapolaska vpolaska = pm.sacuvajVrstuPolaska("Nocni");
//		System.out.println("Sacuvan "+vpolaska.getVrsta()+" polazak!");
//		
//		Vrstapolaska vpolaska2 = pm.nazivVrstePolaska("Svakodnevni");
//		System.out.println("Naziv vrste polaska: "+vpolaska2.getVrsta());
//		
//		List<Vrstapolaska> sveV = pm.sveVrstePolazaka(JPAUtils.getEntityManager());
//		for(Vrstapolaska vp:sveV){
//			System.out.println(vp.getVrsta());
//		}
//		PolasciManager pm = new PolasciManager();
//		Vrstapolaska vpolaska = pm.sacuvajVrstuPolaska("Nocni");
//		System.out.println("Sacuvan "+vpolaska.getVrsta()+" polazak!");		
//		Vrstapolaska vpolaska2 = pm.nazivVrstePolaska("Svakodnevni");
//		System.out.println("Naziv vrste polaska: "+vpolaska2.getVrsta());		
//		List<Vrstapolaska> sveV = pm.sveVrstePolazaka(JPAUtils.getEntityManager());
//		for(Vrstapolaska vp:sveV){
//			System.out.println(vp.getVrsta());
//		}
//		
		Date d=null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			d = sdf.parse("2017-04-21");
			List<Polazak> nekiPolasci = pm.vratiPolaskeZaDatumIDestinaciju(4, d);
			for(Polazak p: nekiPolasci){
				System.out.println("idPolaska: " + p.getIdpolaska() + ", prevoznik: " + p.getPrevoznik().getNaziv() +
									", linija: " + p.getLinija().getNazivlinije());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}//main

}
