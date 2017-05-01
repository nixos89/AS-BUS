package managers;

import java.util.Date;

import javax.persistence.EntityManager;

import model.Komentar7;
import model.Prevoznik;
import model.Putnik;

public class Komentar7Manager {

	public Komentar7 sacuvajKomentar(Date datumkomentara,int ocena,
			String tekstkomentara,Prevoznik prevoznik,Putnik putnik){
		try{
			EntityManager em = JPAUtils.getEntityManager();
			em.getTransaction().begin();
			Komentar7 k = new Komentar7();
			k.setDatumkomentara(datumkomentara);
			k.setOcena(ocena);
			k.setPrevoznik(prevoznik);
			k.setPutnik(putnik);
			k.setTekstkomentara(tekstkomentara);
			em.persist(k);
			em.getTransaction().commit();
			em.close();
			return k;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		Komentar7Manager k7m = new Komentar7Manager();
		EntityManager em = JPAUtils.getEntityManager();
		Putnik put = em.find(Putnik.class, 1);
		Prevoznik prev = em.find(Prevoznik.class, 1);
		Komentar7 kom = k7m.sacuvajKomentar(new Date(), 5, "Super vozac, losa ruta. Sve u svemu ok.", prev, put);
		if(kom!=null)
			System.out.println("Sacuvan komentar sa sadrzajem: \""+kom.getTekstkomentara()+"\"");
		else
			System.out.println("Greska, komentar NIJE sacuvan!");

	}

}
