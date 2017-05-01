package managers;

import javax.persistence.EntityManager;

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
	}
	
	public static void main(String[] args) {
		PrevoznikManager pm = new PrevoznikManager();
		Prevoznik prev = pm.sacuvajPrevoznika(50, "Dunav Prevoz");
		if(prev!=null)
			System.out.println("Prevoznik "+prev.getNaziv()+" je sacuvan!");
		else
			System.out.println("Greska, prevoznik NIJE sacuvan!");

	}

}
