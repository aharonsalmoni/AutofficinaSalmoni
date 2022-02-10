package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vettura {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String targa;
	
	private String marca;
	
	private String modello;
	
	private float cilindrata;
	
	@ManyToOne
	private User proprietario;
	
	@ManyToOne
	private Anagrafica proprietari;
	
	@OneToMany(mappedBy = "vettura")
	private List<Prenotazione> prenotazione;
	
	@OneToMany(mappedBy = "auto")
	private List<InterventoSvolto> interventoSvolto;
	
	public Anagrafica getProprietari() {
		return proprietari;
	}

	public void setProprietari(Anagrafica proprietari) {
		this.proprietari = proprietari;
	}

	public User getProprietario() {
		return proprietario;
	}

	public void setProprietario(User proprietario) {
		this.proprietario = proprietario;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public float getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(float cilindrata) {
		this.cilindrata = cilindrata;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public List<InterventoSvolto> getInterventoSvolto() {
		return interventoSvolto;
	}

	public void setInterventoSvolto(List<InterventoSvolto> interventoSvolto) {
		this.interventoSvolto = interventoSvolto;
	}

	
}
