package br.com.logap.eolica.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aerogerador")
public class Aerogerador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length = 9)
	private Long id;
	@Column(nullable = false, length = 45)
	private String nome;
	@Column(nullable = true)
	private Float latitude;
	@Column(nullable = true)
	private Float longitude;
	@Column(nullable = true, name = "altura_torre")
	private Float alturaTorre;
	@Column(nullable = true, name = "diametro_varredura")
	private Float diametroVarredura;
	@Column(nullable = false, length = 45)
	private String modelo;
	@Column(nullable = false, name = "parque_eolico_id")
	private Long idParqueEolico;
	
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
	public Float getAlturaTorre() {
		return alturaTorre;
	}
	public void setAlturaTorre(Float alturaTorre) {
		this.alturaTorre = alturaTorre;
	}
	public Float getDiametroVarredura() {
		return diametroVarredura;
	}
	public void setDiametroVarredura(Float diametroVarredura) {
		this.diametroVarredura = diametroVarredura;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Long getIdParqueEolico() {
		return idParqueEolico;
	}
	public void setIdParqueEolico(Long idParqueEolico) {
		this.idParqueEolico = idParqueEolico;
	}
}
