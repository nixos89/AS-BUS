package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VrstaPolaska database table.
 * 
 */
@Entity
@NamedQuery(name="VrstaPolaska.findAll", query="SELECT v FROM VrstaPolaska v")
public class VrstaPolaska implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPolazak;

	private String vrsta;

	//bi-directional many-to-one association to Polazak
	@OneToMany(mappedBy="vrstaPolaska")
	private List<Polazak> polazaks;

	public VrstaPolaska() {
	}

	public int getIdPolazak() {
		return this.idPolazak;
	}

	public void setIdPolazak(int idPolazak) {
		this.idPolazak = idPolazak;
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
		polazak.setVrstaPolaska(this);

		return polazak;
	}

	public Polazak removePolazak(Polazak polazak) {
		getPolazaks().remove(polazak);
		polazak.setVrstaPolaska(null);

		return polazak;
	}

}