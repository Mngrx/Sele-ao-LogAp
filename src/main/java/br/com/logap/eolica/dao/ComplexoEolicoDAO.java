package br.com.logap.eolica.dao;

import org.springframework.stereotype.Repository;

import br.com.logap.eolica.domain.ComplexoEolico;

@Repository
public interface ComplexoEolicoDAO extends GenericDAO<ComplexoEolico> {

	ComplexoEolico findByIdentificador(String identificador);
	
}
