package br.com.logap.eolica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.logap.eolica.dao.ComplexoEolicoDAO;
import br.com.logap.eolica.domain.ComplexoEolico;
import br.com.logap.eolica.exceptions.FaltandoValoresException;
import br.com.logap.eolica.exceptions.IdInvalidoException;


@Service
public class ComplexoEolicoService {

	@Autowired
	ComplexoEolicoDAO complexoEolicoDAO;
	
	public List<ComplexoEolico> listarTodos() {
		return complexoEolicoDAO.findAll();
	}
	
	public Optional<ComplexoEolico> obterPeloId(Long id) throws IdInvalidoException {
		
		if (id == null || id < 0 || !complexoEolicoDAO.existsById(id)) {
			throw new IdInvalidoException();
		}
		
		return complexoEolicoDAO.findById(id);
	}

	public Optional<ComplexoEolico> removerPeloId(Long id) throws IdInvalidoException {
		
		if (id == null || id < 0 || !complexoEolicoDAO.existsById(id)) {
			throw new IdInvalidoException();
		}
		
		Optional<ComplexoEolico> removido = complexoEolicoDAO.findById(id);
		
		complexoEolicoDAO.deleteById(id);
		
		return removido;
	}
	

	public boolean cadastrar(ComplexoEolico complexo) throws FaltandoValoresException {
		if (!this.validar(complexo)) {
			throw new FaltandoValoresException();
		}
		complexoEolicoDAO.save(complexo);
		
		return true;
	}
	
	
	public boolean validar(ComplexoEolico complexo) {
		if (complexo.getIdentificador() != null
				&& complexo.getNome() != null
				&& complexo.getUf() != null) {
			return true;
		}
		
		return false;
	}
	
	
	public ComplexoEolico atualizarPeloId(Long id, ComplexoEolico complexo) throws IdInvalidoException, FaltandoValoresException {
		
		if (id == null || id < 0 || !complexoEolicoDAO.existsById(id)) {
			throw new IdInvalidoException();
		}
		
		if (!this.validar(complexo)) {
			throw new FaltandoValoresException();
		}
		
		return complexoEolicoDAO.save(complexo);
		
	}
	
}
