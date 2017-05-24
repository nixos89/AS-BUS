package managers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Putnik;
import model.Radnik;

public class RegistracijaManager {

	
	/* @author: Nikola Stevanovic
	 * Registracija korisnika, tj. Putnik-a*/
	public Putnik sacuvajPutnika(String ime, String prezime,String user,String password){
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
	
	/* @author: Slobodan Babic
	 * Proverava da li se korisnik (tj. Putnik) sa prosledjenim podacima nalazi u bazi */
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
	
	public Putnik getPutnikZaUserPass(String user, String pass){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			TypedQuery<Putnik> upit = em.createQuery("SELECT p FROM Putnik p WHERE p.user LIKE :user AND p.password LIKE :pass", Putnik.class)
					.setParameter("user", user)
					.setParameter("pass", pass);
			Putnik put = upit.getSingleResult();
			return put;
		}catch(Exception e){			
			return null;
		}
	}
	
	public Radnik getRadnikZaUserPass(String user, String pass){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			TypedQuery<Radnik> upit = em.createQuery("SELECT r FROM Radnik r WHERE r.user LIKE :user AND r.password LIKE :pass",Radnik.class)
					.setParameter("user", user)
					.setParameter("pass", pass);
			Radnik radnik =upit.getSingleResult();
			return radnik;
		}catch(Exception e){			
			return null;
		}
	}
	
	public Radnik sacuvajRadnika(String ime, String prezime,String user,String password){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Radnik r = new Radnik();
			r.setIme(ime);
			r.setPrezime(prezime);
			r.setUser(user);
			r.setPassword(password);
			em.persist(r);
			em.getTransaction().commit();
			em.close();
			return r;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		RegistracijaManager rm = new RegistracijaManager();
		boolean postoji = rm.logInPutnik("peki", "zdera");
		Putnik p = rm.getPutnikZaUserPass("peki", "zdera");
		if(postoji)
			System.out.println("Putnik "+ p.getIme()+" "+p.getPrezime()+" sa user-om "+p.getUser()+" postoji!");
		else
			System.out.println("Greska, korisnik NE POSTOJI u bazi!");
		
		Radnik r = rm.sacuvajRadnika("Milica", "Salteric", "mica", "ubica");
		if(r!=null)
			System.out.println("Radnik "+r.getIme()+" "+r.getPrezime()+" je sacuvan!");
		else
			System.out.println("Greska, Radnik NIJE sacuvan!");
	}//main

}
