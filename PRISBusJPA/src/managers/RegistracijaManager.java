package managers;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Putnik;

public class RegistracijaManager {

	public Putnik sacuvajPutnika(String ime, String prezime,
			String user,String password){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Putnik p = new Putnik();
			p.setIme(ime);
			p.setPrezime(prezime);
			p.setUser(user);
			p.setPassword(password);			
			em.persist(p);
			em.getTransaction().commit();
			em.close();
			return p;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//sacuvajPutnika 

	/* Proverava da li se korisnik (tj. Putnik) sa prosledjenim podacima nalazi u bazi */
	public boolean logInPutnik(String user, String password){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			Query upit = em.createQuery("SELECT p FROM Putnik p WHERE p.user LIKE :user AND p.password LIKE :password");
			upit.setParameter("user", user);
			upit.setParameter("password", password);
			Putnik p = (Putnik)upit.getSingleResult();			
			return p!=null; // vraca true ako NE pokazuje na null!
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}//logInPutnik
	
	public static void main(String[] args) {

	}//main

}
