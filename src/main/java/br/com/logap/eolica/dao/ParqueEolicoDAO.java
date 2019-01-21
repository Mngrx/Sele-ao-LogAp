package br.com.logap.eolica.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.logap.eolica.domain.ParqueEolico;

@Repository
public interface ParqueEolicoDAO extends GenericDAO<ParqueEolico> {

	Optional<ArrayList<ParqueEolico>> findAerogeradorByIdComplexoEolico(Long id);

	
}
