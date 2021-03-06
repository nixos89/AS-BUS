package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PREVOZNIK database table.
 * 
 */
@Entity
@Table(name="PREVOZNIK")
@NamedQuery(name="Prevoznik.findAll", query="SELECT p FROM Prevoznik p")
public class Prevoznik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprevoznik;

	private int brmesta;

	@Lob
	private String komentar;

	private String naziv;

	//bi-directional many-to-one association to Polazak
	@OneToMany(mappedBy="prevoznik")
	private List<Polazak> polazaks;

	public Prevoznik() {
	}

	public int getIdprevoznik() {
		return this.idprevoznik;
	}

	public void setIdprevoznik(int idprevoznik) {
		this.idprevoznik = idprevoznik;
	}

	public int getBrmesta() {
		return this.brmesta;
	}

	public void setBrmesta(int brmesta) {
		this.brmesta = brmesta;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Polazak> getPolazaks() {
		return this.polazaks;
	}

	public void setPolazaks(List<Polazak> polazaks) {
		this.polazaks = polazaks;
	}

	public Polazak addPolazak(Polazak polazak) {
		getPolazaks().add(polazak);
		polazak.setPrevoznik(this);

		return polazak;
	}

	public Polazak removePolazak(Polazak polazak) {
		getPolazaks().remove(polazak);
		polazak.setPrevoznik(null);

		return polazak;
	}

}