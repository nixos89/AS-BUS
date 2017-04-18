package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Vrstapolaska;

public class PolasciManager {
	
	
	
	public Vrstapolaska sacuvajVrstuPolaska(String vrsta){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Vrstapolaska vp = new Vrstapolaska();
			vp.setVrsta(vrsta);

			em.getTransaction().commit();
			em.close();
			return vp;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}//sacuvajVrstuPolaska
	
	
//	public List<Vrstapolaska> sveVrstePolazaka(){
//		try {
//			EntityManager em = JPAUtils.getEntityManager();
//			TypedQuery<Vrstapolaska> upit = em.createNamedQuery("SELECT vp FROM Vrstepolaska vp", Vrstapolaska.class);
//			List<Vrstapolaska> sveVrste = upit.getResultList();
//			return sveVrste;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}//sveVrstePolazaka
	
	public static void main(String[] args) {
		PolasciManager pm = new PolasciManager();
		Vrstapolaska vpolaska = pm.sacuvajVrstuPolaska("Svakodnevni");
		System.out.println("Sacuvan "+vpolaska.getVrsta()+" polazak!");
//		List<Vrstapolaska> sveV = pm.sveVrstePolazaka();
//		for(Vrstapolaska vp:sveV){
//			System.out.println(vp.getVrsta());
//		}
		
	}

}
