package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Anagrafica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public Long id;
	
	public String nome;
	
	public String cognome;
	
	public String cellulare;
	
	public String indirizzo;
	
	@OneToMany(mappedBy = "proprietari")
	public List<Vettura> auto;
	
	
	
	
	public Anagrafica(Long id, String nome, String cognome, String cellulare, String indirizzo, List<Vettura> auto,
			List<Prenotazione> prenotazioni) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.cellulare = cellulare;
		this.indirizzo = indirizzo;
		this.auto = auto;
	}

	public Anagrafica() {
		
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
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
	
	public String getCellulare() {
		return cellulare;
	}
	
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Vettura> getAuto() {
		return auto;
	}

	public void setAuto(List<Vettura> auto) {
		this.auto = auto;
	}
	
}
