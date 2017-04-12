package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Polazak database table.
 * 
 */
@Entity
@NamedQuery(name="Polazak.findAll", query="SELECT p FROM Polazak p")
public class Polazak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPolaska;

	private int brProdatihKarata;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vremePolaska;

	//bi-directional many-to-one association to Karta
	@OneToMany(mappedBy="polazak")
	private List<Karta> kartas;

	//bi-directional many-to-one association to VrstaPolaska
	@ManyToOne
	@JoinColumn(name="idPolazak")
	private VrstaPolaska vrstaPolaska;

	//bi-directional many-to-one association to Linija
	@ManyToOne
	@JoinColumn(name="idLinija")
	private Linija linija;

	//bi-directional many-to-one association to Prevoznik
	@ManyToOne
	@JoinColumn(name="idPrevoznik")
	private Prevoznik prevoznik;

	//bi-directional many-to-many association to Putnik
	@ManyToMany(mappedBy="polazaks")
	private List<Putnik> putniks;

	//bi-directional many-to-one association to RezervacijaRadnik
	@OneToMany(mappedBy="polazak")
	private List<RezervacijaRadnik> rezervacijaRadniks;

	public Polazak() {
	}

	public int getIdPolaska() {
		return this.idPolaska;
	}

	public void setIdPolaska(int idPolaska) {
		this.idPolaska = idPolaska;
	}

	public int getBrProdatihKarata() {
		return this.brProdatihKarata;
	}

	public void setBrProdatihKarata(int brProdatihKarata) {
		this.brProdatihKarata = brProdatihKarata;
	}

	public Date getVremePolaska() {
		return this.vremePolaska;
	}

	public void setVremePolaska(Date vremePolaska) {
		this.vremePolaska = vremePolaska;
	}

	public List<Karta> getKartas() {
		return this.kartas;
	}

	public void setKartas(List<Karta> kartas) {
		this.kartas = kartas;
	}

	public Karta addKarta(Karta karta) {
		getKartas().add(karta);
		karta.setPolazak(this);

		return karta;
	}

	public Karta removeKarta(Karta karta) {
		getKartas().remove(karta);
		karta.setPolazak(null);

		return karta;
	}

	public VrstaPolaska getVrstaPolaska() {
		return this.vrstaPolaska;
	}

	public void setVrstaPolaska(VrstaPolaska vrstaPolaska) {
		this.vrstaPolaska = vrstaPolaska;
	}

	public Linija getLinija() {
		return this.linija;
	}

	public void setLinija(Linija linija) {
		this.linija = linija;
	}

	public Prevoznik getPrevoznik() {
		return this.prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
	}

	public List<Putnik> getPutniks() {
		return this.putniks;
	}

	public void setPutniks(List<Putnik> putniks) {
		this.putniks = putniks;
	}

	public List<RezervacijaRadnik> getRezervacijaRadniks() {
		return this.rezervacijaRadniks;
	}

	public void setRezervacijaRadniks(List<RezervacijaRadnik> rezervacijaRadniks) {
		this.rezervacijaRadniks = rezervacijaRadniks;
	}

	public RezervacijaRadnik addRezervacijaRadnik(RezervacijaRadnik rezervacijaRadnik) {
		getRezervacijaRadniks().add(rezervacijaRadnik);
		rezervacijaRadnik.setPolazak(this);

		return rezervacijaRadnik;
	}

	public RezervacijaRadnik removeRezervacijaRadnik(RezervacijaRadnik rezervacijaRadnik) {
		getRezervacijaRadniks().remove(rezervacijaRadnik);
		rezervacijaRadnik.setPolazak(null);

		return rezervacijaRadnik;
	}

}