package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KARTA database table.
 * 
 */
@Entity
@Table(name="Karta")
@NamedQuery(name="Karta.findAll", query="SELECT k FROM Karta k")
public class Karta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkarta;

	private int cenakarte;

	private String tipkarte;

	//bi-directional many-to-one association to Polazak
	@ManyToOne
	@JoinColumn(name="IDPOLASKA")
	private Polazak polazak;

	public Karta() {
	}

	public int getIdkarta() {
		return this.idkarta;
	}

	public void setIdkarta(int idkarta) {
		this.idkarta = idkarta;
	}

	public int getCenakarte() {
		return this.cenakarte;
	}

	public void setCenakarte(int cenakarte) {
		this.cenakarte = cenakarte;
	}

	public String getTipkarte() {
		return this.tipkarte;
	}

	public void setTipkarte(String tipkarte) {
		this.tipkarte = tipkarte;
	}

	public Polazak getPolazak() {
		return this.polazak;
	}

	public void setPolazak(Polazak polazak) {
		this.polazak = polazak;
	}

}