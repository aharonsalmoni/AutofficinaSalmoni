package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class InterventoSvolto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEffettuato;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dataPrenotazione;
	

	@OneToMany(mappedBy = "interventoSvolto")
	private List<Intervento> intervento;
	
	@ManyToOne
	private Meccanici meccanico;
	
	@ManyToOne
	private Vettura auto;
	
	public InterventoSvolto() {
		
	}
	
	public InterventoSvolto(Long id, LocalDate dataEffettuato, LocalDateTime dataPrenotazione, List<Intervento> intervento,
			Meccanici meccanico, Vettura auto) {
		super();
		this.id = id;
		this.dataEffettuato = dataEffettuato;
		this.dataPrenotazione = dataPrenotazione;
		this.intervento = intervento;
		this.meccanico = meccanico;
		this.auto = auto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEffettuato() {
		return dataEffettuato;
	}

	public void setDataEffettuato(LocalDate dataEffettuato) {
		this.dataEffettuato = dataEffettuato;
	}

	public List<Intervento> getIntervento() {
		return intervento;
	}

	public void setIntervento(List<Intervento> intervento) {
		this.intervento = intervento;
	}

	public Meccanici getMeccanico() {
		return meccanico;
	}

	public void setMeccanico(Meccanici meccanico) {
		this.meccanico = meccanico;
	}

	public Vettura getAuto() {
		return auto;
	}

	public void setAuto(Vettura auto) {
		this.auto = auto;
	}

	public LocalDateTime getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(LocalDateTime dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	
	
}
