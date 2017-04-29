package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GRAD database table.
 * 
 */
@Entity
@Table(name="GRAD")
@NamedQuery(name="Grad.findAll", query="SELECT g FROM Grad g")
public class Grad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idgrad;

	private String naziv;

	//bi-directional many-to-one association to Linija
	@OneToMany(mappedBy="grad")
	private List<Linija> linijas;

	public Grad() {
	}

	public int getIdgrad() {
		return this.idgrad;
	}

	public void setIdgrad(int idgrad) {
		this.idgrad = idgrad;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Linija> getLinijas() {
		return this.linijas;
	}

	public void setLinijas(List<Linija> linijas) {
		this.linijas = linijas;
	}

	public Linija addLinija(Linija linija) {
		getLinijas().add(linija);
		linija.setGrad(this);

		return linija;
	}

	public Linija removeLinija(Linija linija) {
		getLinijas().remove(linija);
		linija.setGrad(null);

		return linija;
	}

}