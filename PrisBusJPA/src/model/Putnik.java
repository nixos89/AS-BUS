package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Putnik database table.
 * 
 */
@Entity
@NamedQuery(name="Putnik.findAll", query="SELECT p FROM Putnik p")
public class Putnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPutnik;

	private int brKarata;

	private String ime;

	private String password;

	private String prezime;

	//bi-directional many-to-many association to Polazak
	@ManyToMany
	@JoinTable(
		name="rezervacijaPutnik"
		, joinColumns={
			@JoinColumn(name="idPutnik")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idPolaska")
			}
		)
	private List<Polazak> polazaks;

	public Putnik() {
	}

	public int getIdPutnik() {
		return this.idPutnik;
	}

	public void setIdPutnik(int idPutnik) {
		this.idPutnik = idPutnik;
	}

	public int getBrKarata() {
		return this.brKarata;
	}

	public void setBrKarata(int brKarata) {
		this.brKarata = brKarata;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
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