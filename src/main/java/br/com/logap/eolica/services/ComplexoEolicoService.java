package br.com.logap.eolica.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logap.eolica.dao.ComplexoEolicoDAO;
import br.com.logap.eolica.dao.ParqueEolicoDAO;
import br.com.logap.eolica.domain.ComplexoEolico;
import br.com.logap.eolica.domain.ParqueEolico;
import br.com.logap.eolica.exceptions.IdInvalidoException;


@Service
public class ComplexoEolicoService extends GenericService<ComplexoEolico, ComplexoEolicoDAO>{

	@Autowired
	ParqueEolicoDAO parqueEolicoDAO;
	
	@Override
	public boolean validar(ComplexoEolico complexo) {
		if (complexo.getIdentificador() != null
				&& complexo.getNome() != null
				&& complexo.getUf() != null) {
			return true;
		}
		
		return false;
	}

	public Optional<ArrayList<ParqueEolico>> aerogeradoresPeloIdDoParqueEolico(Long id) throws IdInvalidoException {
		
		if (!dao.existsById(id) || id < 0 || id == null) {
			throw new IdInvalidoException();
		}
		
		return parqueEolicoDAO.findAerogeradorByIdComplexoEolico(id);
	}
	
	
}
