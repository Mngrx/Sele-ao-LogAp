package br.com.logap.eolica.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.logap.eolica.domain.Aerogerador;

@Repository
public interface AerogeradorDAO extends GenericDAO<Aerogerador> {

	Optional<ArrayList<Aerogerador>> findAerogeradorByIdParqueEolico(Long id);
	
}
