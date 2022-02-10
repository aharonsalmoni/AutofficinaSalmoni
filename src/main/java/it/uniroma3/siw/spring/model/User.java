package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users") // cambiamo nome perchè in postgres user e' una parola riservata
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String cellulare;
	private String indirizzo;

	
	@OneToMany(mappedBy = "proprietario")
	private List<Vettura> macchine;
	
	
	public User(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.nome = string;
		this.cognome = string2;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public List<Vettura> getMacchine() {
		return macchine;
	}

	public void setMacchine(List<Vettura> macchine) {
		this.macchine = macchine;
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

}
