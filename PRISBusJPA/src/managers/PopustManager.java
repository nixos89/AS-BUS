package managers;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Putnik;
//obavestenje o popustu, Nevena
public class PopustManager {
	
	public boolean getObavestiZaPopust(String user, String password, int brkarata){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			Query upit = em.createQuery("SELECT p FROM Putnik p WHERE p.user LIKE :user AND p.password LIKE :pass AND p.brkarata LIKE :brkarata")
					.setParameter("user", user)
					.setParameter("password", password)
					.setParameter("brkarata", brkarata);
			Putnik put = (Putnik)upit.getSingleResult();
		if(put.getBrkarata()>=3){
			return put!=null;
		}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		PopustManager pm = new PopustManager();
		boolean postoji = pm.getObavestiZaPopust("peki", "zdera",3);
		if(postoji)
			System.out.println("Dobili ste popust od 10% na cenu karte!");
	}


}
