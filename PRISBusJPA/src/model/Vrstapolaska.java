package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VRSTAPOLASKA database table.
 * 
 */
@Entity
//@Table(name="VrstaPolaska")
@NamedQuery(name="Vrstapolaska.findAll", query="SELECT v FROM Vrstapolaska v")
public class Vrstapolaska implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idvrstapolaska;

	private String vrsta;

	//bi-directional many-to-one association to Polazak
	@OneToMany(mappedBy="vrstapolaska")
	private List<Polazak> polazaks;

	public Vrstapolaska() {
	}

	public int getIdvrstapolaska() {
		return this.idvrstapolaska;
	}

	public void setIdvrstapolaska(int idvrstapolaska) {
		this.idvrstapolaska = idvrstapolaska;
	}

	public String getVrsta() {
		return this.vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public List<Polazak> getPolazaks() {
		return this.polazaks;
	}

	public void setPolazaks(List<Polazak> polazaks) {
		this.polazaks = polazaks;
	}

	public Polazak addPolazak(Polazak polazak) {
		getPolazaks().add(polazak);
		polazak.setVrstapolaska(this);

		return polazak;
	}

	public Polazak removePolazak(Polazak polazak) {
		getPolazaks().remove(polazak);
		polazak.setVrstapolaska(null);

		return polazak;
	}

}