package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the POLAZAK database table.
 * 
 */
@Entity
@Table(name="POLAZAK")
@NamedQuery(name="Polazak.findAll", query="SELECT p FROM Polazak p")
public class Polazak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpolaska;

	private int brprodatihkarata;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date vremepolaska;

	//bi-directional many-to-one association to Karta
	@OneToMany(mappedBy="polazak")
	private List<Karta> kartas;

	//bi-directional many-to-one association to Vrstapolaska
	@ManyToOne
	@JoinColumn(name="IDVRSTAPOLASKA")
	private Vrstapolaska vrstapolaska;

	//bi-directional many-to-one association to Linija
	@ManyToOne
	@JoinColumn(name="IDLINIJA")
	private Linija linija;

	//bi-directional many-to-one association to Prevoznik
	@ManyToOne
	@JoinColumn(name="IDPREVOZNIK")
	private Prevoznik prevoznik;

	//bi-directional many-to-one association to Prodaja
	@OneToMany(mappedBy="polazak")
	private List<Prodaja> prodajas;

	//bi-directional many-to-many association to Putnik
	@ManyToMany(mappedBy="polazaks")
	private List<Putnik> putniks;

	public Polazak() {
		putniks = new ArrayList<Putnik>();
	}

	public int getIdpolaska() {
		return this.idpolaska;
	}

	public void setIdpolaska(int idpolaska) {
		this.idpolaska = idpolaska;
	}

	public int getBrprodatihkarata() {
		return this.brprodatihkarata;
	}

	public void setBrprodatihkarata(int brprodatihkarata) {
		this.brprodatihkarata = brprodatihkarata;
	}

	public Date getVremepolaska() {
		return this.vremepolaska;
	}

	public void setVremepolaska(Date vremepolaska) {
		this.vremepolaska = vremepolaska;
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

	public Vrstapolaska getVrstapolaska() {
		return this.vrstapolaska;
	}

	public void setVrstapolaska(Vrstapolaska vrstapolaska) {
		this.vrstapolaska = vrstapolaska;
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

	public List<Prodaja> getProdajas() {
		return this.prodajas;
	}

	public void setProdajas(List<Prodaja> prodajas) {
		this.prodajas = prodajas;
	}

	public Prodaja addProdaja(Prodaja prodaja) {
		getProdajas().add(prodaja);
		prodaja.setPolazak(this);

		return prodaja;
	}

	public Prodaja removeProdaja(Prodaja prodaja) {
		getProdajas().remove(prodaja);
		prodaja.setPolazak(null);

		return prodaja;
	}

	public List<Putnik> getPutniks() {
		return this.putniks;
	}

	public void setPutniks(List<Putnik> putniks) {
		this.putniks = putniks;
	}

}