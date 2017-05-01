package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the LINIJA database table.
 * 
 */
@Entity
@NamedQuery(name="Linija.findAll", query="SELECT l FROM Linija l")
public class Linija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlinija;

	@Temporal(TemporalType.DATE)
	private Date datumpolaska;

	private String nazivlinije;

	//bi-directional many-to-one association to Grad
	@ManyToOne
	@JoinColumn(name="IDGRAD")
	private Grad grad;

	//bi-directional many-to-one association to Polazak
	@OneToMany(mappedBy="linija")
	private List<Polazak> polazaks;

	public Linija() {
		
	}

	public int getIdlinija() {
		return this.idlinija;
	}

	public void setIdlinija(int idlinija) {
		this.idlinija = idlinija;
	}

	public Date getDatumpolaska() {
		return this.datumpolaska;
	}

	public void setDatumpolaska(Date datumpolaska) {
		this.datumpolaska = datumpolaska;
	}

	public String getNazivlinije() {
		return this.nazivlinije;
	}

	public void setNazivlinije(String nazivlinije) {
		this.nazivlinije = nazivlinije;
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