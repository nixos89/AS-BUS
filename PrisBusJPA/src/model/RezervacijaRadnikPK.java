package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rezervacijaRadnik database table.
 * 
 */
@Embeddable
public class RezervacijaRadnikPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idRadnik;

	@Column(insertable=false, updatable=false)
	private int idPolaska;

	public RezervacijaRadnikPK() {
	}
	public int getIdRadnik() {
		return this.idRadnik;
	}
	public void setIdRadnik(int idRadnik) {
		this.idRadnik = idRadnik;
	}
	public int getIdPolaska() {
		return this.idPolaska;
	}
	public void setIdPolaska(int idPolaska) {
		this.idPolaska = idPolaska;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RezervacijaRadnikPK)) {
			return false;
		}
		RezervacijaRadnikPK castOther = (RezervacijaRadnikPK)other;
		return 
			(this.idRadnik == castOther.idRadnik)
			&& (this.idPolaska == castOther.idPolaska);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRadnik;
		hash = hash * prime + this.idPolaska;
		
		return hash;
	}
}