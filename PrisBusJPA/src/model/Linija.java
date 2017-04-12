package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Linija database table.
 * 
 */
@Entity
@NamedQuery(name="Linija.findAll", query="SELECT l FROM Linija l")
public class Linija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLinija;

	@Temporal(TemporalType.DATE)
	private Date datumPolaska;

	private String nazivLinije;

	//bi-directional many-to-one association to Grad
	@ManyToOne
	@JoinColumn(name="idGrad")
	private Grad grad;

	//bi-directional many-to-one association to Polazak
	@OneToMany(mappedBy="linija")
	private List<Polazak> polazaks;

	public Linija() {
	}

	public int getIdLinija() {
		return this.idLinija;
	}

	public void setIdLinija(int idLinija) {
		this.idLinija = idLinija;
	}

	public Date getDatumPolaska() {
		return this.datumPolaska;
	}

	public void setDatumPolaska(Date datumPolaska) {
		this.datumPolaska = datumPolaska;
	}

	public String getNazivLinije() {
		return this.nazivLinije;
	}

	public void setNazivLinije(String nazivLinije) {
		this.nazivLinije = nazivLinije;
	}

	public Grad getGrad() {
		return this.grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	public List<Polazak> getPolazaks() {
		return this.polazaks;
	}

	public void setPolazaks(List<Polazak> polazaks) {
		this.polazaks = polazaks;
	}

	public Polazak addPolazak(Polazak polazak) {
		getPolazaks().add(polazak);
		polazak.setLinija(this);

		return polazak;
	}

	public Polazak removePolazak(Polazak polazak) {
		getPolazaks().remove(polazak);
		polazak.setLinija(null);

		return polazak;
	}

}