package br.com.logap.eolica.services;

import org.springframework.stereotype.Service;

import br.com.logap.eolica.dao.ComplexoEolicoDAO;
import br.com.logap.eolica.domain.ComplexoEolico;


@Service
public class ComplexoEolicoService extends GenericService<ComplexoEolico, ComplexoEolicoDAO>{

	@Override
	public boolean validar(ComplexoEolico complexo) {
		if (complexo.getIdentificador() != null
				&& complexo.getNome() != null
				&& complexo.getUf() != null) {
			return true;
		}
		
		return false;
	}

	
}
