package br.com.logap.eolica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.logap.eolica.domain.ComplexoEolico;

@Repository
public interface ComplexoEolicoDAO extends JpaRepository<ComplexoEolico, Long>{

	ComplexoEolico findByIdentificador(String identificador);
	
}
