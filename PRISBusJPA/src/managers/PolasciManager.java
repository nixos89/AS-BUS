package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	
	public static void main(String[] args) {
		PolasciManager pm = new PolasciManager();
//		Vrstapolaska vpolaska = pm.sacuvajVrstuPolaska("Nocni");
//		System.out.println("Sacuvan "+vpolaska.getVrsta()+" polazak!");
//		
		Vrstapolaska vpolaska2 = pm.nazivVrstePolaska("Svakodnevni");
		System.out.println("Naziv vrste polaska: "+vpolaska2.getVrsta());
//		
//		List<Vrstapolaska> sveV = pm.sveVrstePolazaka(JPAUtils.getEntityManager());
//		for(Vrstapolaska vp:sveV){
//			System.out.println(vp.getVrsta());
//		}
		
	}//main


}
