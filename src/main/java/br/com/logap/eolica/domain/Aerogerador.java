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
	
	
	

}
