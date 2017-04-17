package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the PUTNIK database table.
 * 
 */
@Entity
@Table(name="Putnik")
@NamedQuery(name="Putnik.findAll", query="SELECT p FROM Putnik p")
public class Putnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idputnik;

	private int brkarata;

	private String ime;
	
	private String user;

	private String password;

	private String prezime;

	//bi-directional many-to-many association to Polazak
	@ManyToMany
	@JoinTable(
		name="REZERVACIJAPUTNIK"
		, joinColumns={
			@JoinColumn(name="IDPUTNIK")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDPOLASKA")
			}
		)
	private List<Polazak> polazaks;

	public Putnik() {
		polazaks = new ArrayList<Polazak>();
	}

	public int getIdputnik() {
		return this.idputnik;
	}

	public void setIdputnik(int idputnik) {
		this.idputnik = idputnik;
	}

	public int getBrkarata() {
		return this.brkarata;
	}

	public void setBrkarata(int brkarata) {
		this.brkarata = brkarata;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Polazak> getPolazaks() {
		return this.polazaks;
	}

	public void setPolazaks(List<Polazak> polazaks) {
		this.polazaks = polazaks;
	}

}