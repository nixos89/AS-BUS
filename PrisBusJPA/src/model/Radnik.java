package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Radnik database table.
 * 
 */
@Entity
@NamedQuery(name="Radnik.findAll", query="SELECT r FROM Radnik r")
public class Radnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRadnik;

	private String ime;

	private String pass;

	private String prezime;

	private String user;

	//bi-directional many-to-one association to RezervacijaRadnik
	@OneToMany(mappedBy="radnik")
	private List<RezervacijaRadnik> rezervacijaRadniks;

	public Radnik() {
	}

	public int getIdRadnik() {
		return this.idRadnik;
	}

	public void setIdRadnik(int idRadnik) {
		this.idRadnik = idRadnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<RezervacijaRadnik> getRezervacijaRadniks() {
		return this.rezervacijaRadniks;
	}

	public void setRezervacijaRadniks(List<RezervacijaRadnik> rezervacijaRadniks) {
		this.rezervacijaRadniks = rezervacijaRadniks;
	}

	public RezervacijaRadnik addRezervacijaRadnik(RezervacijaRadnik rezervacijaRadnik) {
		getRezervacijaRadniks().add(rezervacijaRadnik);
		rezervacijaRadnik.setRadnik(this);

		return rezervacijaRadnik;
	}

	public RezervacijaRadnik removeRezervacijaRadnik(RezervacijaRadnik rezervacijaRadnik) {
		getRezervacijaRadniks().remove(rezervacijaRadnik);
		rezervacijaRadnik.setRadnik(null);

		return rezervacijaRadnik;
	}

}