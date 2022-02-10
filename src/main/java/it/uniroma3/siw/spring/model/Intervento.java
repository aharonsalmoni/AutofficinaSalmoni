package it.uniroma3.siw.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Intervento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private int prezzo;
	private String descrizione;
	private String codice;
	
	@OneToOne
	private Prenotazione prenotazione; 
	
	@ManyToOne
	private Meccanici meccanico;
	
	@ManyToOne
	private InterventoSvolto interventoSvolto;
	

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
	
	public int getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public InterventoSvolto getInterventoSvolto() {
		return interventoSvolto;
	}

	public void setInterventoSvolto(InterventoSvolto interventoSvolto) {
		this.interventoSvolto = interventoSvolto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Meccanici getMeccanico() {
		return meccanico;
	}

	public void setMeccanico(Meccanici meccanico) {
		this.meccanico = meccanico;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	

}
