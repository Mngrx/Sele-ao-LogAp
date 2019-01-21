package br.com.logap.eolica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logap.eolica.dao.ComplexoEolicoDAO;
import br.com.logap.eolica.dao.ParqueEolicoDAO;
import br.com.logap.eolica.domain.ParqueEolico;

@Service
public class ParqueEolicoService extends GenericService<ParqueEolico, ParqueEolicoDAO>  {

	@Autowired
	ComplexoEolicoDAO complexoEolicoDAO;
	
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

}
