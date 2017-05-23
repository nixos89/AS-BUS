package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PRODAJA database table.
 * 
 */
@Entity
@Table(name="PRODAJA")
@NamedQuery(name="Prodaja.findAll", query="SELECT p FROM Prodaja p")
public class Prodaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprodaja;

	@Temporal(TemporalType.DATE)
	private Date datumprodaje;

	//bi-directional many-to-one association to Polazak
	@ManyToOne
	@JoinColumn(name="IDPOLASKA")
	private Polazak polazak;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="IDRADNIK")
	private Radnik radnik;
	
	private int iznos;
	
	public Prodaja() {
	}

	public int getIdprodaja() {
		return this.idprodaja;
	}

	public void setIdprodaja(int idprodaja) {
		this.idprodaja = idprodaja;
	}

	public Date getDatumprodaje() {
		return this.datumprodaje;
	}

	public void setDatumprodaje(Date datumprodaje) {
		this.datumprodaje = datumprodaje;
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

	public int getIznos() {
		return iznos;
	}

	public void setIznos(int iznos) {
		this.iznos = iznos;
	}

	
}