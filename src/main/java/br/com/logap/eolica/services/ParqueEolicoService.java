package br.com.logap.eolica.services;

import org.springframework.stereotype.Service;

import br.com.logap.eolica.dao.ParqueEolicoDAO;
import br.com.logap.eolica.domain.ParqueEolico;

@Service
public class ParqueEolicoService extends GenericService<ParqueEolico, ParqueEolicoDAO>  {

	@Override
	public boolean validar(ParqueEolico parque) {
		// TODO Auto-generated method stub
		return false;
	}

}
