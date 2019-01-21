package br.com.logap.eolica.services;

import org.springframework.stereotype.Service;

import br.com.logap.eolica.dao.AerogeradorDAO;
import br.com.logap.eolica.domain.Aerogerador;

@Service 
public class AerogeradorService extends GenericService<Aerogerador, AerogeradorDAO>{

	@Override
	public boolean validar(Aerogerador aerogerador) {
		// TODO Auto-generated method stub
		return false;
	}

}
