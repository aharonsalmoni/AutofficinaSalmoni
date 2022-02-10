package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Meccanici {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	@OneToMany(mappedBy = "meccanico")
	private List<InterventoSvolto> interventiSvolti;
	
	@OneToMany(mappedBy = "meccanico")
	private List<Intervento> intervento;
	

	public Meccanici(Long id, String nome, String cognome, List<InterventoSvolto> interventiSvolti,
			List<Intervento> intervento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.interventiSvolti = interventiSvolti;
		this.intervento = intervento;
	}
	public Meccanici() {
		
	}

	public String getNome() {
		return nome;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public List<InterventoSvolto> getInterventiSvolti() {
		return interventiSvolti;
	}
	public void setInterventiSvolti(List<InterventoSvolto> interventiSvolti) {
		this.interventiSvolti = interventiSvolti;
	}
	public List<Intervento> getIntervento() {
		return intervento;
	}
	public void setIntervento(List<Intervento> intervento) {
		this.intervento = intervento;
	}
	
	
}
