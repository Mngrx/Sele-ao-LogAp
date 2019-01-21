package br.com.logap.eolica.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logap.eolica.dao.AerogeradorDAO;
import br.com.logap.eolica.dao.ComplexoEolicoDAO;
import br.com.logap.eolica.dao.ParqueEolicoDAO;
import br.com.logap.eolica.domain.Aerogerador;
import br.com.logap.eolica.domain.ParqueEolico;
import br.com.logap.eolica.exceptions.IdInvalidoException;

@Service
public class ParqueEolicoService extends GenericService<ParqueEolico, ParqueEolicoDAO>  {

	@Autowired
	ComplexoEolicoDAO complexoEolicoDAO;
	
	@Autowired
	AerogeradorDAO aerogeradorDAO;
	
	@Override
	public boolean validar(ParqueEolico parque) {

		if (parque.getNome() != null
				&& parque.getPotenciaInstalada() != null
				&& complexoEolicoDAO.existsById(parque.getIdComplexoEolico())) {
			System.out.println("AQUIII"+parque.getNome());
			return true;
		}
		
		return false;
	}
	
	public Optional<ArrayList<Aerogerador>> aerogeradoresPeloIdDoParqueEolico(Long id) throws IdInvalidoException {
		
		if (!dao.existsById(id) || id < 0 || id == null) {
			throw new IdInvalidoException();
		}
		
		return aerogeradorDAO.findAerogeradorByIdParqueEolico(id);
	}

}
