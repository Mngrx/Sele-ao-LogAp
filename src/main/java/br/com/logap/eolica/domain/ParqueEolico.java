package br.com.logap.eolica.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parque_eolico")
public class ParqueEolico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, length = 9)
	private Long id;
	@Column(nullable = false, length = 45)
	private String nome;
	@Column(nullable = true)
	private Float latitude;
	@Column(nullable = true)
	private Float longitude;
	@Column(nullable = false, name = "potencia_instalada")
	private Float potenciaInstalada;
	@Column(nullable = false, name = "complexo_eolico_id")
	private Long idComplexoEolico;

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
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getPotenciaInstalada() {
		return potenciaInstalada;
	}
	public void setPotenciaInstalada(Float potenciaInstalada) {
		this.potenciaInstalada = potenciaInstalada;
	}
	public Long getIdComplexoEolico() {
		return idComplexoEolico;
	}
	public void setIdComplexoEolico(Long idComplexoEolico) {
		this.idComplexoEolico = idComplexoEolico;
	}
	
	
}
