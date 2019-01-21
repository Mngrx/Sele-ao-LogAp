package br.com.logap.eolica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logap.eolica.dao.AerogeradorDAO;
import br.com.logap.eolica.dao.ParqueEolicoDAO;
import br.com.logap.eolica.domain.Aerogerador;

@Service 
public class AerogeradorService extends GenericService<Aerogerador, AerogeradorDAO>{

	@Autowired
	ParqueEolicoDAO parqueEolicoDAO;
	
	@Override
	public boolean validar(Aerogerador aerogerador) {
		
		if (aerogerador.getNome() != null 
				&& aerogerador.getModelo() != null
				&& parqueEolicoDAO.existsById(aerogerador.getIdParqueEolico())) {
			
		}
		
		return false;
	}

}
