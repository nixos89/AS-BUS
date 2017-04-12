package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rezervacijaRadnik database table.
 * 
 */
@Entity
@NamedQuery(name="RezervacijaRadnik.findAll", query="SELECT r FROM RezervacijaRadnik r")
public class RezervacijaRadnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RezervacijaRadnikPK id;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Polazak
	@ManyToOne
	@JoinColumn(name="idPolaska")
	private Polazak polazak;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="idRadnik")
	private Radnik radnik;

	public RezervacijaRadnik() {
	}

	public RezervacijaRadnikPK getId() {
		return this.id;
	}

	public void setId(RezervacijaRadnikPK id) {
		this.id = id;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Polazak getPolazak() {
		return this.polazak;
	}

	public void setPolazak(Polazak polazak) {
		this.polazak = polazak;
	}

	public Radnik getRadnik() {
		return this.radnik;
	}

	public void setRadnik(Radnik radnik) {
		this.radnik = radnik;
	}

}