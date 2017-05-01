package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RADNIK database table.
 * 
 */
@Entity
@Table(name="RADNIK")
@NamedQuery(name="Radnik.findAll", query="SELECT r FROM Radnik r")
public class Radnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idradnik;

	private String ime;

	private String password;

	private String prezime;

	private String user;

	//bi-directional many-to-one association to Prodaja
	@OneToMany(mappedBy="radnik")
	private List<Prodaja> prodajas;

	public Radnik() {
	}

	public int getIdradnik() {
		return this.idradnik;
	}

	public void setIdradnik(int idradnik) {
		this.idradnik = idradnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Prodaja> getProdajas() {
		return this.prodajas;
	}

	public void setProdajas(List<Prodaja> prodajas) {
		this.prodajas = prodajas;
	}

	public Prodaja addProdaja(Prodaja prodaja) {
		getProdajas().add(prodaja);
		prodaja.setRadnik(this);

		return prodaja;
	}

	public Prodaja removeProdaja(Prodaja prodaja) {
		getProdajas().remove(prodaja);
		prodaja.setRadnik(null);

		return prodaja;
	}

}