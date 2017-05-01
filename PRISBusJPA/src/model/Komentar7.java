package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the KOMENTAR7 database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar7.findAll", query="SELECT k FROM Komentar7 k")
public class Komentar7 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkomentar;

	@Temporal(TemporalType.DATE)
	private Date datumkomentara;

	private int ocena;

	private String tekstkomentara;

	//bi-directional many-to-one association to Prevoznik
	@ManyToOne
	@JoinColumn(name="IDPREVOZNIK")
	private Prevoznik prevoznik;

	//bi-directional many-to-one association to Putnik
	@ManyToOne
	@JoinColumn(name="IDPUTNIK")
	private Putnik putnik;

	public Komentar7() {
	}

	public int getIdkomentar() {
		return this.idkomentar;
	}

	public void setIdkomentar(int idkomentar) {
		this.idkomentar = idkomentar;
	}

	public Date getDatumkomentara() {
		return this.datumkomentara;
	}

	public void setDatumkomentara(Date datumkomentara) {
		this.datumkomentara = datumkomentara;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getTekstkomentara() {
		return this.tekstkomentara;
	}

	public void setTekstkomentara(String tekstkomentara) {
		this.tekstkomentara = tekstkomentara;
	}

	public Prevoznik getPrevoznik() {
		return this.prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
	}

	public Putnik getPutnik() {
		return this.putnik;
	}

	public void setPutnik(Putnik putnik) {
		this.putnik = putnik;
	}

}