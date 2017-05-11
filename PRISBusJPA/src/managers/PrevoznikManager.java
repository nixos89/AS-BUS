package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Komentar7;
import model.Prevoznik;
import model.Putnik;

public class PrevoznikManager {
	
	public Prevoznik sacuvajPrevoznika(int brMesta,String naziv){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Prevoznik p = new Prevoznik();
			p.setBrmesta(brMesta);
			p.setNaziv(naziv);		
			em.persist(p);
			em.getTransaction().commit();
			em.close();
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}//sacuvajPrevoznika
	
	
	public List<Komentar7> sviKomentariZaPrevoznika(int idPrevoznik){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			TypedQuery<Komentar7> upit = em.createQuery("SELECT k FROM Komentar7 k JOIN k.prevoznik p WHERE p.idprevoznik =:idPrevoznik", Komentar7.class);
			upit.setParameter("idPrevoznik", idPrevoznik);
			List<Komentar7> komentariZP = upit.getResultList();
			return komentariZP;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}//sviKomentariZaPrevoznika
	
	public static void main(String[] args) {
		PrevoznikManager pm = new PrevoznikManager();
		Prevoznik prev = pm.sacuvajPrevoznika(50, "Dunav Prevoz");
		if(prev!=null)
			System.out.println("Prevoznik "+prev.getNaziv()+" je sacuvan!");
		else
			System.out.println("Greska, prevoznik NIJE sacuvan!");

	}

}
