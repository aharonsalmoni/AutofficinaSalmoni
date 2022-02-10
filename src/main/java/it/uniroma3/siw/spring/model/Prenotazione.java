package it.uniroma3.siw.spring.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dataPrenotazione;
	
	@OneToOne
	private Intervento intervento;
	
	
	@ManyToOne
	private Vettura vettura;
	
	


	public Prenotazione(Long id, LocalDateTime dataPrenotazione, Intervento intervento, Vettura vettura) {
		super();
		this.id = id;
		this.dataPrenotazione = dataPrenotazione;
		this.intervento = intervento;
		this.vettura = vettura;
	}

	public Prenotazione() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(LocalDateTime dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Intervento getIntervento() {
		return intervento;
	}

	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

	public Vettura getVettura() {
		return vettura;
	}

	public void setVettura(Vettura vettura) {
		this.vettura = vettura;
	}
	
	
}
