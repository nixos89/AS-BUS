package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Karta database table.
 * 
 */
@Entity
@NamedQuery(name="Karta.findAll", query="SELECT k FROM Karta k")
public class Karta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKarta;

	private int cenaKarte;

	private String tipKarte;

	//bi-directional many-to-one association to Polazak
	@ManyToOne
	@JoinColumn(name="idPolaska")
	private Polazak polazak;

	public Karta() {
	}

	public int getIdKarta() {
		return this.idKarta;
	}

	public void setIdKarta(int idKarta) {
		this.idKarta = idKarta;
	}

	public int getCenaKarte() {
		return this.cenaKarte;
	}

	public void setCenaKarte(int cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public String getTipKarte() {
		return this.tipKarte;
	}

	public void setTipKarte(String tipKarte) {
		this.tipKarte = tipKarte;
	}

	public Polazak getPolazak() {
		return this.polazak;
	}

	public void setPolazak(Polazak polazak) {
		this.polazak = polazak;
	}

}